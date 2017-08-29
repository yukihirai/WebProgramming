<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ新規登録</title>
</head>
<body>
<form action="/UserManegment/UserRegi" method="post">
<p style="background-color:#808080;" align ="right"><font size="3" color="white">${sessionScope.name}さん　<a href="/UserManegment/Logout">ログアウト</a></font></p>
<p align ="center"><font size='7'>ユーザ新規登録</font></p>
<br>
<div align ="center">ログインID　　　<input type ="text"style="width:250px;" name="login_id" ></div><br>
<br>
<div align ="center">パスワード　　　<input type ="text"style="width:250px;" name="pass1"></div><br>
<br>
<div align ="center">パスワード(確認)　<input type ="text"style="width:250px;" name="pass2"></div><br>
<br>
<div align ="center">ユーザ名　　　<input type ="text"style="width:250px;" name="user"></div><br>
<br>
<div align ="center">生年月日　　　<input type ="date"style="width:250px;" name="birth"></div><br>
<br>
<div align="center"><font color ="red">${passError}</font></div>
<br>
 <div Align="center"><input type="submit"value="登録" style="width:100px"></div>
 </form>>
</body>
</html>