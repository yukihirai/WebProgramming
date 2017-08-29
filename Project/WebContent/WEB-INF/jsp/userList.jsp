<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧</title>
</head>
<body>
<form action="/UserManegment/Logout" method="post">
<div style="background-color:#808080;" align ="right"><font size="3" color="white">${sessionScope.name}さん　　<a href="/UserManegment/Logout">ログアウト</a></font></div>
<div align = center><font size='7'>ユーザ一覧</font></div>
<div align ="right"><a href="/UserManegment/UserRegi">新規登録</a></div>
<br>
<br>
<div align ="center">ログインID　<input type ="text"style="width:250px;" name="id" ></div><br>
<div align ="center">ユーザ名　　<input type ="text"style="width:250px;" name="user"></div><br>
<div align ="center">生年月日　　<input type ="date"style="width:150px;" name="birth"placeholder="年/月/日"> ～ <input type ="date"style="width:150px;" name="birth"placeholder="年/月/日"><br></div>
<br>
<p align ="right"><input type="submit"value="検索"></p>
<div align = "center"><table border ="1"></div>


  <tr>
    <th width="150">ログインID</th>
    <th width="150">ユーザ名</th>
  	<th width="150">生年月日</th>
  </tr>
<%@page import="beans.UserBeans"%>
<%@page import="java.util.List"%>

<%List<UserBeans> users =(List<UserBeans>)request.getAttribute("userList");
for(UserBeans list : users){%>

	<tr>
		<td class="center"><%=list.getLogin_id()%></td>
		<td class="center"><%=list.getName()%></td>
	    <td class="center"><%=list.getBirth_date()%></td>
		<td>
			<input type="button" onClick="location.href='/UserManegment/UserInfo?id=<%=list.getId()%>'"value="詳細"style="background-color: skyblue;">
  			<input type="button" onClick="location.href='userUpdate.jsp'"value="更新"style="background-color: yellowgreen;">
  			<input type="button" onClick="location.href='userDelete.html'"value="削除"style="background-color: tomato;">
  		</td>
	</tr>
<%}%>



</table>
 </div>
</form>
</body>
</html>