package com.iot.spring;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocket {
	@OnOpen  //서버측에서 클라이언트와웹소켓이 연결되엇을데 호출되는 함수
	public void handleopen() {
		System.out.println("클라이언트 지금연결 ");
	}
	@OnMessage //클라이언트에서 서버측으로 메시지를 보내면 호출되는 함수
	public String handleMessage(String message) {
		System.out.println("클라이언트 받은 : " + message);
		String replymessage = "echo" + message;
		System.out.println("클라이언트 보내는 : " + message);
		return replymessage;
	}
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트 연결 끊김");
	}
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
}
