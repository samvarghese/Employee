<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>List Employee</h1>
		<table border="black">
			<tr>
				<th>Employee Name</th>
				<th>Employee Email</th>
				<th>Employee userName</th>
				<th>Action</th>
			</tr>

			<c:forEach var="i" items="${emp}">
				<tr>
					<td>${i.getUsername()}</td>
					<td>${i.getEmail()}</td>
					<td>${i.getUsername()}</td>
                    <td><input type="button" onclick="test('${i.getUsername()}','${i.getUser().getUser_id()}' )">Role</input></td>
				</tr>
			</c:forEach>

		</table>
		<form action="/setRole" method="post">
			<table>
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" name="name" id="name"></td>
					<td><input type="hidden" name="userId" id="userId"></td>

					<td><select name="userRole">
							<option value="1">Admin</option>
							<option value="2">Developer</option>
					</select></td>
					<td>
						<input type="submit"/>
					</td>
				</tr>
			</table>
		</form>

	</center>
	<script>
    function test(i,id){
    	console.log(i+" "+id);
    	document.getElementById('name').value=i
    	document.getElementById('userId').value=id
        //alert("Hello"+i); // added sample text
    }
 </script>

</body>
</html>