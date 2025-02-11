<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 수정</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
</head>
<body>
	<main>
		<h2>메뉴 수정</h2>
		<form action="/Menus/Update/${ menu.menu_seq }" method="POST">
			<table>
				<tr>
					<td>메뉴 아이디</td>
					<td><input type="text" name="menu_id" value="${menu.menu_id}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>메뉴 이름</td>
					<td><input type="text" name="menu_name" value="${menu.menu_name}" /></td>
				</tr>
				<tr>
					<td>메뉴 순서</td>
					<td><input type="text" name="menu_seq" value="${menu.menu_seq}" readonly="readonly" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" /><input
						type="button" value="취소" id="cancel_btn" /></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			const goListEl = document.getElementById('cancel_btn');
			goListEl.addEventListener('click', function(e) {
				location.href = '/Menus/List';
			});
		</script>
	</main>
</body>
</html>