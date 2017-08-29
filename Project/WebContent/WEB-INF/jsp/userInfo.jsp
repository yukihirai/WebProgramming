<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報詳細参照</title>
</head>
<body>
<p style="background-color:#808080;" align ="right"><font size="3" color="white">${sessionScope.name}さん　　<a href="/UserManegment/Logout">ログアウト</a></font></p>
<p align ="center"><font size='7'>ユーザ情報詳細参照</font></p>
<br>
<div align="center"><font size="5">


<%@ page import="beans.UserBeans"%>

<%UserBeans user = (UserBeans)request.getAttribute("userInfo");%>

ログインID　　　<%=user.getLogin_id()%>
<br>
<br>
ユーザ名　　　　<%=user.getName()%>
<br>
<br>
生年月日　　　　<%=user.getBirth_date()%>
<br>
<br>
登録日時　　　　<%=user.getCreate_date()%>
<br>
<br>
更新日時　　　　<%=user.getUpdate_date()%>
<br></font></div>
<a href="/UserManegment/UserList">戻る</a>
</body>
</html>