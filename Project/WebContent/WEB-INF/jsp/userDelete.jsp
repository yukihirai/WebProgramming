<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認</title>
</head>
<body>
<form action="/UserManegment/UserDelete" method="post">
<p style="background-color:#808080;" align ="right"><font size="3" color="white">${UserLoginidName.name}さん　　<a href="/UserManegment/Logout">ログアウト</a></font></p>
<p align ="center"><font size='7'>ユーザ削除確認</font></p>

<%@ page import="beans.UserBeans"%>
<%UserBeans user = (UserBeans)request.getAttribute("userInfo");%>
<div align="center"><font color ="red">${errorMsg}</font></div>
<input type ="hidden" name="id" value="<%=user.getId()%>">
<div align="center">ログインID　　　　　　　　<%=user.getLogin_id()%></div><br>
<div align="center">を本当に削除してもよろしいでしょうか。</div>
<br>
<br>
<br>
<br>
<div align="center"><input type="button"value="キャンセル" onclick="location.href='/UserManegment/UserList'">　　<input type="submit"value="OK" style="width:80px"></div>
</form>
</body>
</html>