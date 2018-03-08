<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   ${mssg}
	<center>
		<div class="log-form">
			<h2>Login to your account</h2>
			<form action="/saveDetails" method="post">
				<input type="text" title="username" name="username" placeholder="username" /> <input
					type="password" title="username"name="password"  placeholder="password" />
				<button type="submit" class="btn">Login</button>
				<a class="forgot" href="/Employee.jsp">Register?</a>
			</form>
		</div>
		<!--end log form -->
	</center>
</body>
</html>