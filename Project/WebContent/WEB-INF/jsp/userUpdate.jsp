<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報更新</title>
</head>
<body>
<form action="/UserManegment/UserUpdate" method="post">
<p style="background-color:#808080;" align ="right"><font size="3" color="white">${sessionScope.name}さん　　<a href="/UserManegment/Logout">ログアウト</a></font></p>
<p align ="center"><font size='7'>ユーザ情報更新</font></p>
<br>
<div align="center"><font color ="red">${errorMsg}</font></div>
<%@ page import="beans.UserBeans"%>

<%UserBeans user = (UserBeans)request.getAttribute("userInfo");%>
<input type ="hidden" name="id" value="<%=user.getId()%>">
<div align="center">ログインID　　　　　　　　　　<%=user.getLogin_id()%></div>
<br>
<div align="center">パスワード　　　　　　<input type ="password"style="width:250px;" name="pass1"></div><br>
<br>
<div align="center">パスワード(確認)　　　　<input type ="password"style="width:250px;" name="pass2"></div><br>
<br>
<div align="center">ユーザ名　　　　　　<input type ="text"style="width:250px;" name="name" required value="<%=user.getName()%>" ></div><br>
<br>
<div align="center">生年月日　　　　　　<input type ="date"style="width:250px;" name="birth_date" required value="<%=user.getNoConvertBirth_date()%>"></div><br>
<br>
<div align="center"><input type="submit"value="更新" style="width:100px"></div>
<br>
<a href="/UserManegment/UserList">戻る</a>
</form>
</body>
</html>