<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>DataBase Administrator</title>
</head>
<script>
	$(document).ready(function(){
		$("#goLogin").click(function(){
			location.href="${pPath}/user/login"
		})
	})
	

	
	

</script>
<body>
<h1>
	DataBase Administrator
</h1>
<button id="goLogin" type="button">로그인</button>

</body>
</html>
