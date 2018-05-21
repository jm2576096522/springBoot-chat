package com.wys.chats.interceptor;


import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wys.chats.util.SysLog;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;


/**
 * 
 * @author WangYS 2018年5月20日上午1:42:23
 *
 */
@SuppressWarnings("all")
public class MyRequestHandler extends SimpleChannelInboundHandler<Object> {

	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * ws://localhost:6879/chat/1234
	 * {"mac":"123*1234","msg":"萨顶顶撒"}
	 */
	private static final String WEBSOCKET_PATH = "/chat";

	private WebSocketServerHandshaker handshaker;

	private ObjectMapper jsonMapper = new ObjectMapper();

	private FullHttpResponse response;

	public static ConcurrentHashMap<String, Channel> clientChannel = new ConcurrentHashMap(5);

	public String  clientMac = "";

	public DateTimeFormatter dft =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");


	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpRequest) {
			handlerWebSocketRegister(ctx, msg);
		}
	}

	/**
	 * 建立连接
	 * @param ctx
	 * @param msg
	 */
	private void handlerWebSocketRegister(ChannelHandlerContext ctx,Object msg){
		String requestUrl = "";
		HttpRequest mRequest = ((HttpRequest) msg);
		requestUrl = mRequest.getUri();
		SysLog.info( LocalDateTime.now().format(dft) + "来自的请求-----"+ requestUrl);
		String socketUrl = null;
		try {
			socketUrl = requestUrl.substring(0, requestUrl.lastIndexOf("/"));
			if (WEBSOCKET_PATH.equals(socketUrl)) {
				clientMac = requestUrl.substring(requestUrl.lastIndexOf("/") + 1,requestUrl.length());
				if (!StringUtils.isEmpty(clientMac)) {
					Object newChannel = clientChannel.get(clientMac);
					if (newChannel == null) {
						Channel incoming = ctx.channel();
						clientChannel.put(clientMac, incoming);
					} else {
						Channel incoming = ctx.channel();
						if(!(newChannel.equals(incoming))){
							clientChannel.put(clientMac, incoming);
						}
					}
				}
			}
			handleHttpRequest(ctx, mRequest);
			if (!StringUtils.isEmpty(clientMac)&& WEBSOCKET_PATH.equals(socketUrl)) {
				
				/***
				 * 保存数据库
				 */
				SysLog.info("更新数据库设备状态--------"+clientMac);
				
				
				/**
				 * 加载好友和群 好友申请 未读信息
				 */
			}
		} catch (Exception e) {
			SysLog.error(e);
		}
	}

	
	/**
	 * 断开连接
	 */
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		SysLog.info("______________:" + incoming.remoteAddress() + "掉线");
		for(String key : clientChannel.keySet()) {  
			if(incoming.equals(clientChannel.get(key))){
				clientChannel.remove(key);
				SysLog.info("mac:"+key+"移除成功----ip---->>修改用户数据库在线状态"+incoming.remoteAddress());
				/**
				 * 保存数据库
				 */
				break;
			}
		}
	}
	
	/**
	 * 主动推送消息
	 * @param param
	 */
	public static void handlerWebSocketPush(Map<String, Object> param){
		try {
			String []macStr = null;
			for (String ksv : param.keySet()) {
				macStr = String.valueOf(param.get("mac")).split("\\*");
			}
			for (int i = 0; i < macStr.length; i++) {
				Channel mChannel = clientChannel.get(macStr[i]);
				if(mChannel!=null&&mChannel.isActive()){
					System.out.println(String.valueOf(param.get("msg")));
					TextWebSocketFrame tws = new TextWebSocketFrame(String.valueOf(param.get("msg")));
					mChannel.writeAndFlush(tws);
				}
			}
		} catch (Exception e) {
			SysLog.error("主动推送消息到连接的Socket：---"+e);
		}
	}
	

	/**
	 * /////////////////////////////////////////////
	 * 
	 *  @param ctx
	 *  @param req
	 * 
	 * /////////////////////////////////////////////
	 */
	private void handleHttpRequest(ChannelHandlerContext ctx, HttpRequest req) {
		if (!req.getDecoderResult().isSuccess()
				|| (!"websocket".equals(req.headers().get("Upgrade")))) {

			if (req.getMethod().equals(HttpMethod.POST)) {
				SysLog.info("这是post请求");
			} else if (req.getMethod().equals(HttpMethod.GET)) {

				SysLog.info("这是get请求");
			}
			try {
				DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer("success".getBytes("UTF-8")));
				sendHttpResponse(ctx, req, response);
			} catch (Exception e) {
				SysLog.error(""+e);
			}
			return;
		}
		WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory( getWebSocketLocation(null), null, false);
		handshaker = wsFactory.newHandshaker(req);
		if (handshaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
		} else {
			handshaker.handshake(ctx.channel(), req);
		}
	}

	private static void sendHttpResponse(ChannelHandlerContext ctx,
			HttpRequest req, DefaultFullHttpResponse res) {
		// 返回应答给客户端
		if (res.getStatus().code() != 200) {
			ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(),CharsetUtil.UTF_8);
			res.content().writeBytes(buf);
			buf.release();
		}
		// 如果是非Keep-Alive，关闭连接
		ChannelFuture f = ctx.channel().writeAndFlush(res);
		if (!isKeepAlive(req) || res.getStatus().code() != 200) {
			f.addListener(ChannelFutureListener.CLOSE);
		}
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		// channels.add(incoming);
		SysLog.info("------------客户端在线状态--------------:"+ incoming.remoteAddress() + "在线");
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// super.exceptionCaught(ctx, cause);
		SysLog.info("客户端异常");
	}

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	private static String getWebSocketLocation(HttpRequest req) {
		return "";
	}

	private static boolean isKeepAlive(HttpRequest req) {
		return false;
	}
}
