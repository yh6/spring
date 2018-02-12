<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="gridbox" style="width:410px;height:400px;"></div> 
	<script>
		var mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath("${dPath}/imgs/");
		mygrid.setHeader("번호,아이디,비밀번호,이름,이메일,관리자권한");
		mygrid.setInitWidths("50,148,200");
		mygrid.setColAlign("left,left,left,left,left,left");
		mygrid.setColTypes("ro,ed,ed,ed,ed,ro");
		mygrid.setColSorting("int,str,str,str,str,str");
		mygrid.setColumnIds("uNo,uID,uPwd,uName,uEmail,admin");
		mygrid.init();

		var au = new AjaxUtil("${root}/userInfo/list", null, "GET", "json");
		function callback(res) {
			mygrid.parse({data : res}, "js");
		}
		au.setCallbackSuccess(callback);
		au.send();
	</script>
</body>
</html>