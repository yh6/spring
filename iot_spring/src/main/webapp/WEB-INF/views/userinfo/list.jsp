<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head><script>
$(document).ready(function(){
	var au = new AjaxUtil("${root}/userinfo/list", null, "GET", "json");
	function callback(res) {
		console.log(res);
		$("#userInfoTable").bootstrapTable({
			data : res
		});
	}
	au.setCallbackSuccess(callback);
	au.send();
});
</script>
<body>
<div class="container">
		<table data-toggle="table" id="userInfoTable" class="table table-bordered ">
		<thead>
			<tr>
				<th data-field="uNo">번호</th>
				<th data-field="uName">이름</th>
				<th data-field="uID">아이디</th>
				<th data-field="uPwd">비밀번호</th>
				<th data-field="uEmail">이메일</th>
				<th data-field="admin">관리</th>						
			</tr>
			<tbody id="tBody"></tbody>
		</thead>
		</table>
	</div>


</body>
</html>