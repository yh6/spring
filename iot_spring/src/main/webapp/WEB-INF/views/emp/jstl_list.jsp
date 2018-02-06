<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${rPath}/ui/css/list.css" />
<body>
<div><br><br><br><br><br></div>
	<div class="container">
		<table class="table table-striped table-bordered ">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>월급</th>
				<th class="text-center" data-field="BTN">
				<em class="glyphicon glyphicon-cog"></em></th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr >
					<td>${emp.empNO}</td>

					<td>${emp.empName}</td>


					<td style="cursor: hand">${emp.empSal}</td>
					<td class="btn btn-default" onclick="updateEmp">
					<em class="glyphicon glyphicon-pencil"></em></td>
					<td class="btn btn-danger" onclick="deleteEmp">
					<em class="glyphicon glyphicon-trash" ></em></td>
				</tr>

			</c:forEach>
		</table>
		<a href="${pPath}/emp/write"><button>사원정보추가</button></a>
	</div>

</body>



</html>