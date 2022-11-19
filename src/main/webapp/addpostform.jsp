<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Post</h1>
<form action="addpost.jsp" method="post" enctype="multipart/form-data">
<table>
<tr><td>First Name:</td><td><input type="text" name="firstName"/></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lastName"/></td></tr>
    <tr><td>Team:</td><td><input type="text" name="team"/></td></tr>
    <tr><td>Age:</td><td><input type="number" name="age"/></td></tr>
    <tr><td>Anual Average:</td><td><input type="text" name="aav"/></td></tr>
    <tr><td>Team Control:</td><td><input type="number" name="teamControl"/></td></tr>
    <tr><td>Photo:</td><td><input type="file" name="photo"></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</body>
</html>