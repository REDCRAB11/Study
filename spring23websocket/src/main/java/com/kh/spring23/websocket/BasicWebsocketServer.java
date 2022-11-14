package com.kh.spring23.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;


/**
 * 웹소켓 서버(WebSocket Server)
 *  - HTTP 연결을 처리하는 컨트롤러와는 별개로 연결형 통신을 제공하는 서버
 *  - 상속을 통해서 자격을 획득해야함
 *  - (I) WebSocketHandler
 *  - (C) TextWebSocketHandler, BinaryWebSocketHandler
 *  - 주요 연결 및 통신 처리는 Spring에서 자동으로 수행한다
 *  - 중요한 작업(접속, 종료, 메세지 수신)은 개발자에게 처리 메소드를 제공
 */
@Slf4j
@Service
//public interface BasicWebsocketServer implements WebSocketHandler {
public class BasicWebsocketServer extends TextWebSocketHandler {
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      log.debug("사용자 접속: {}", session);
   }
   
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      log.debug("사용자 종료: {}", session);
   }
}