<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <p>${student }</p>--%>
<div>
		
			<a href="/CollegeFests/student/add">Add Student</a>
			
			
			
		
		
	</div>
	<table class ="table">
	<tr>
	    <th>ID</th>
		<th>Name</th>
		<th>Country</th>
		<th>Department</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${student }" var="student">
		<tr>
		    <td>${student.id }</td>
			<td>${student.name }</td>
			<td>${student.country }</td>
			<td>${student.department }</td>
			<td><a href="/CollegeFests/student/update/${student.id }">Update</a>
			<a href="/CollegeFests/student/delete/${student.id }">Delete</a></td>
		</tr>
		
	</c:forEach>
	</table>
	</div>
</table>
</body>
</html>