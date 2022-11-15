package com.kh.spring23.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageWebsocketServer extends TextWebSocketHandler{
   
   private Set<WebSocketSession> users = new CopyOnWriteArraySet<>(); 
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      users.add(session);
      log.debug("사용자 접속");
   }
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      users.remove(session);
      log.debug("사용자 종료");
   }
   
   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
         log.debug("메세지 수신 {}", message);
         
         //message의 내용은 payload에 존재하며, 메세지는 사용자(session)에게 전송
         
         //발신자에게만 회신하는 코드
         //session.sendMessage(message);
         
         //접속한 모든 사용자에게 전송하는 코드
         for(WebSocketSession user: users) {
        	 user.sendMessage(message);
         }
   } 
}