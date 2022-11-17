package com.kh.spring23.websocket;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberWebsocketServer  extends TextWebSocketHandler{
	// 여러명이 동시 접속해도 괜찮은 어쩌고.. 
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("session ={}", session.getAttributes());		
		Map<String, Object> attributes = session.getAttributes();
		String loginId = (String)attributes.get("loginId");
		String loginNick = (String)attributes.get("loginNick");
		String loginAuth = (String)attributes.get("loginAuth");
		log.debug("{}, {}, {}", loginId, loginNick, loginAuth);
		users.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Map<String, Object> attributes = session.getAttributes();
		String loginId = (String)attributes.get("loginId");
		String loginNick = (String)attributes.get("loginNick");
		String loginAuth = (String)attributes.get("loginAuth");
		users.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> attributes = session.getAttributes();
		String loginId = (String)attributes.get("loginId");
		String loginNick = (String)attributes.get("loginNick");
		String loginAuth = (String)attributes.get("loginAuth");
	}
}
