<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style>
</style>
</head>
<body>
<form action="/UserManegment/LoginResult" method="post">
<Div Align="center">
<font size='7'>ログイン画面</font><br>
<br>
<font color ="red">${error}</font>
<font color ="green">${logout}</font>
<br>
ログインID :<input type ="text" name="login_id" required><br>
<br>
パスワード :<input type ="password" name="pass"required><br>
<br>
<br>
<input type="submit"value="送信">
</div>
</form>
</body>
</html>