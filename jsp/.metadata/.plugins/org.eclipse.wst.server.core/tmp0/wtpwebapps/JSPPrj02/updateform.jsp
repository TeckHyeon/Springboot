<%@page import="db.MemberVo"%>
<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String mid = request.getParameter("mid");

//데이터 조회 : mid 로 
DBHandler db = new DBHandler();
MemberVo vo = db.getMember(Integer.parseInt(mid));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<main>
		<form action="update.jsp" method="GET">
			<h2>회원 정보 수정</h2>
			<table>
				<tr>
					<td>번호</td>
					<td><input type="text" name="mid" value="<%=vo.getMid()%>"
						readonly /></td>
				</tr>
				<tr>

					<td>이름</td>
					<td><input type="text" value="<%=vo.getName()%>" name="name" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" value="<%=vo.getPhone()%>" name="phone" /></td>
				</tr>
				<tr>

					<td>가입일</td>
					<td><input type="text" name="phone"
						value="<%=vo.getIndate()%>" readonly /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" /> <input
						type="button" value="목록" onclick="location.href= 'list.jsp'" /></td>
				</tr>
			</table>
		</form>
	</main>
</body>
</html>