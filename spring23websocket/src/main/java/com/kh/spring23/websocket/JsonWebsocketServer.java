package com.kh.spring23.websocket;


import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring23.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

/**
  JSON message를 주고받는 서버
 */

@Slf4j
@Service
public class JsonWebsocketServer  extends TextWebSocketHandler{
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("메세지 - {} ", message.getPayload());
		//(주의)
		// - 웹소켓 서버는 JSON을 자동으로 변환해주지 않는다. 
		// - jackson-databind를 통해 수동변환해야 한다. 
		// [1] MAP으로 바꾸는 방법 
		// [2] 클래스의 객체로 바꾸는 방법
		
		//변환 도구 생성
		ObjectMapper mapper = new ObjectMapper();
		//Map json = mapper.readValue(message.getPayload(), Map.class);
		//log.debug("json = {}", json);
		
		MessageVO json = mapper.readValue(message.getPayload(), MessageVO.class);
		log.debug("json = {}", json);
		
		// json에 시간을 추가 
		json.setTime(new Date());
		
		//바뀐 정보를 이용하여 신규 메세지 생성 
		String payload = mapper.writeValueAsString(json);
		TextMessage jsonMessage = new TextMessage(payload);
		
		//모두에게 발송(broadcast)
		for(WebSocketSession user: users) {
			//user.sendMessage(json);  안됨 이거는 ! 
			user.sendMessage(jsonMessage);
		}
	}
}
