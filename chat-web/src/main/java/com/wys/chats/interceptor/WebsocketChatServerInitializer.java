package com.wys.chats.interceptor;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * 
 * @author WangYS 2018年5月20日上午1:42:05
 *
 */
public class WebsocketChatServerInitializer extends ChannelInitializer<SocketChannel> {
	
	static final EventExecutorGroup executorGroup = new DefaultEventExecutorGroup(20);
	
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new HttpServerCodec());
		pipeline.addLast(new StringDecoder());
		pipeline.addLast(new HttpObjectAggregator(64 * 1024));
		pipeline.addLast(new ChunkedWriteHandler());
		pipeline.addLast("deflater", new HttpContentCompressor());
		pipeline.addLast(executorGroup,new ChannelHandler[] { new MyRequestHandler() });
	}
}
