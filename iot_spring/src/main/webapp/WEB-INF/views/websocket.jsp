<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	<input id="textMessage" type="text">
	<input onclick="sandMessage()" value="송신" type="button">
	<input onclick="disconnect()" value="종료" type="button">
	</form>
	<br/>
	<textarea id="messageTextArea" rows="10" cols="50"></textarea>
<script type="text/javascript">
var webSocket = new webSocket("ws://localhost:80/com.iot.spring/WebSocket");
var messageTextArea = document.getElementById("messageTextArea");
webSocket.onopen = function(message){
    messageTextArea.value += "Server connect.."};

webSocket.onclose = function(message){
    messageTextArea.value += "Server Disconnect..."};

webSocket.onerror = function(message){
    messageTextArea.value += "error..."};

webSocket.onmessage = function(message){
    messageTextArea.value += "Recieve From Server => "+message.data+"\n";
};

function sendMessage(){
    var message = document.getElementById("textMessage");
    messageTextArea.value += "Send to Server => "+message.value+"\n";
    webSocket.send(message.value);
    message.value = "";
}

function disconnect(){
    webSocket.close();
}
</script>
</body>
</html>