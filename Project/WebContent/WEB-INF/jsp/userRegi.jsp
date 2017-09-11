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
<p style="background-color:#808080;" align ="right"><font size="3" color="white">${UserLoginidName.name}さん　<a href="/UserManegment/Logout">ログアウト</a></font></p>
<p align ="center"><font size='7'>ユーザ新規登録</font></p>
<div align="center"><font color ="red">${errorMsg}</font></div>
<br>
<div align ="center">ログインID　　　<input type ="text"style="width:250px;" name="login_id" value="${login_id}" required></div><br>
<br>
<div align ="center">パスワード　　　<input type ="password"style="width:250px;" name="pass1" required></div><br>
<br>
<div align ="center">パスワード(確認)　<input type ="password"style="width:250px;" name="pass2"required></div><br>
<br>
<div align ="center">ユーザ名　　　<input type ="text"style="width:250px;" name="name" value="${name}" required></div><br>
<br>
<div align ="center">生年月日　　　<input type ="date"style="width:250px;" name="birth_date" value="${birth_date}" required></div><br>
<br>
<br>
 <div Align="center"><input type="submit"value="登録" style="width:100px"></div>
 <a href="/UserManegment/UserList">戻る</a>
 </form>
</body>
</html>