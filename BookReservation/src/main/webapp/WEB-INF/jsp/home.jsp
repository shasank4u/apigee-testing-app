<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Tracking System</title>
</head>
<body>
	${requestScope.message} <br />
	<a href="addProject.action">Add a New Project</a><br />
	<a href="reportBug.action">Report a New Bug</a><br />
	<a href="getReport.action">View Bug Reports</a><br />
	

</body>
</html>