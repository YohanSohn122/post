<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
	request.setAttribute("vo", u);
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSeq() %>"/>
<table>
<tr><td>First Name:</td><td><input type="text" name="firstName" value="<%= u.getFisrtName()%>"/></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lastName" value="<%= u.getLastName()%>" /></td></tr>
	<tr><td>Team:</td><td><input type="text" name="team" value="<%= u.getTeam()%>" /></td></tr>
	<tr><td>Age:</td><td><input type="number" name="age" value="<%= u.getAge()%>" /></td></tr>
	<tr><td>Aav:</td><td><input type="text" name="aav" value="<%= u.getAav()%>" /></td></tr>
	<tr><td>Team Control:</td><td><input type="number" name="teamControl" value="<%= u.getTeamControl()%>" /></td></tr>
	<tr><td>Photo</td><td><input type="file" name="photo" value="${u.getPhoto()}" />
	<c:if test="${u.getPhoto ne ''}"><br /><img src="${pageContext.request.contextPath}/upload/${u.getPhoto()}" class="photo"></c:if></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

</body>
</html>