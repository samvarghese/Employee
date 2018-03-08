<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<center>
		<form action="/Register" method="post" modelAttribute="Register">
			<h1>Register Employee</h1>
			<table border="black">
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" name="empName" required></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Departement:</td>
					<td><select name="deptId">
							<option value="1">Java</option>
							<option value="2">Php</option>
							<option value="3">Asp</option>
					</select></td>
				</tr>
				<tr>
					<td>Login UserName:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"/></td>
					<td><button onclick="test()">Hai</button></td>
				</tr>

			</table>
	</center>
	</form>
<script>
    function test(){
        alert("Hello"); // added sample text
    }
 </script>
</body>
</html>
