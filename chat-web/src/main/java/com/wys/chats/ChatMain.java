package com.wys.chats;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wys.chats.interceptor.WebsocketChatServerInitializer;
import com.wys.chats.util.SysLog;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@SpringBootApplication
public class ChatMain implements CommandLineRunner{

	public static int port = 6666;

	public static void main( String[] args ){
		SpringApplication.run(ChatMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WebsocketChatServerInitializer childHandlers = new WebsocketChatServerInitializer();
		try {
			port = Integer.parseInt("6879");
		} catch (Exception e) {
			SysLog.error(e);
		}
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(childHandlers).childOption(ChannelOption.SO_KEEPALIVE, true);
			SysLog.info("=============websocket服务器启动成功======================"+ port);
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			SysLog.info(e);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
			SysLog.info("=============服务端 关闭了");
		}
	}


}
