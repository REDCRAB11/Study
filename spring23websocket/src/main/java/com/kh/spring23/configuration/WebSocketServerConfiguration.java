package com.kh.spring23.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import com.kh.spring23.websocket.BasicWebsocketServer;
import com.kh.spring23.websocket.JsonWebsocketServer;
import com.kh.spring23.websocket.MessageWebsocketServer;
import com.kh.spring23.websocket.MultipleUserWebsocketServer;
import com.kh.spring23.websocket.SockJSWebsocketServer;

@Configuration
@EnableWebSocket//웹소켓 활성화
public class WebSocketServerConfiguration implements WebSocketConfigurer{
	
	@Autowired
	private BasicWebsocketServer basicWebsocketServer;
	
	@Autowired
	private MultipleUserWebsocketServer multipleUserWebsocketServer;
	
	@Autowired
	private MessageWebsocketServer messageWebsocketServer;
	
	@Autowired
	private JsonWebsocketServer jsonWebsocketServer;
	
	@Autowired
	private SockJSWebsocketServer sockJSWebsocketServer;
	@Override
	public void registerWebSocketHandlers(
							WebSocketHandlerRegistry registry) {
		//등록 시 주의사항
		//- 절대로 다른 페이지와 주소가 겹치면 안된다
		//- HTTP가 사용중이면 웹소켓 서버는 정상 작동하지 않는다
		registry.addHandler(basicWebsocketServer, "/ws/basic")
					.addHandler(multipleUserWebsocketServer, "/ws/multiple")
					.addHandler(messageWebsocketServer, "/ws/message")
					.addHandler(jsonWebsocketServer, "/ws/json")
					.addHandler(sockJSWebsocketServer, "/ws/sockjs").withSockJS();
	}
}




