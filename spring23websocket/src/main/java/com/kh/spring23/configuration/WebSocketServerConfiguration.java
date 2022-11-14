package com.kh.spring23.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.kh.spring23.websocket.BasicWebsocketServer;
import com.kh.spring23.websocket.MultipleUserWebsocketServer;

@Configuration
@EnableWebSocket//웹소켓 활성화
public class WebSocketServerConfiguration implements WebSocketConfigurer{
	
	@Autowired
	private BasicWebsocketServer basicWebsocketServer;
	
	@Autowired
	private MultipleUserWebsocketServer multipleUserWebsocketServer;
	
	@Override
	public void registerWebSocketHandlers(
							WebSocketHandlerRegistry registry) {
		//등록 시 주의사항
		//- 절대로 다른 페이지와 주소가 겹치면 안된다
		//- HTTP가 사용중이면 웹소켓 서버는 정상 작동하지 않는다
		registry.addHandler(basicWebsocketServer, "/ws/basic")
					.addHandler(multipleUserWebsocketServer, "/ws/multiple");
	}
}
