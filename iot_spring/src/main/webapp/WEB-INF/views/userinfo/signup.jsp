<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${title}</title>
</head>
<style>
div#winVP {
	position: relative;
	height: 100%;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
	var winF, popW;
	$(document).ready(function() {
		alert("${sessionScope.isLogin}");
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1", 20, 30, 380, 500);
		//popW.hide(); 
		popW.button("close").hide();
		popW.button("minmax").hide();
		popW.button("park").hide();
		popW.setText("Login");

		winF.window("win1").centerOnScreen();
		winF.window("win1").denyMove();
		winF.window("win1").denyResize();
		
		var formObj = [ {
			type : "settings",
			offsetTop : 12,
			name : "connectionInfo",
			labelAlign : "left"
		}, {
			type : "input",
			name : "uName",
			label : "이름 : ",
			required : true
		}, {
			type : "input",
			name : "uID",
			label : "아이디 : ",
			required : true
		}, {
			type : "password",
			name : "uPwd",
			label : "비밀번호 : ",
			required : true
		}, {
			type : "input",
			name : "uEmail",
			label : "이메일 : ",
			required : true
		}, {
			type : "label",
			name : "admin",
			label : "관리자권한 : ",
			list : [ {
				type : "radio",
				name : "admin",
				value : "1",
				label : "예",
				checked : true
			},

			{
				type : "radio",
				name : "admin",
				value : "0",
				label : "아니오"
			} ]
		},

		{
			type : "block",
			blockOffset : 0,
			list : [ {
				type : "button",
				name : "signupBtn",
				value : "회원가입"
			}, {
				type : "button",
				name : "cancelBtn",
				value : "취소"
			}, {
				type : "button",
				name : "goBack",
				value : "돌아가기"
			}

			]
		} ];
		var form = popW.attachForm(formObj, true);
		
		form.attachEvent("onButtonClick", function(id) {
			if (id == "signupBtn") {
				if (form.validate()) {
					form.send("${root}/userInfo/signup", "post", callback);
				}
			} else if (id == "cancelBtn") {
				form.clear();
			} else if (id == "goBack") {
				document.location.href = "${root}/userInfo/login";
			}
		});
	})

	

	function callback(loader, res) {
		if (loader.xmlDoc.status == 200) {
			var res = JSON.parse(res);
			alert(res.msg);
			if (res.loginOk) {
				document.location.href = "${root}/path/db/main";
			}

		}
	}

	function setPopW(onOff) {
		if (onOff) {
			popW.show();
			return;
		}
		popW.hide();
	}
</script>
<body>
	<div id="winVP"></div>
</body>
</html>