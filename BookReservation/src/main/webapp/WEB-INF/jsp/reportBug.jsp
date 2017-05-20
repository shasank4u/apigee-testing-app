<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report A New Bug</title>
<script type="text/javascript">
function goHome(frm){
	frm.action="index.jsp";
	frm.submit();
}
</script>
<style type="text/css">
.errClass{
color : red
}
</style>
</head>
<body>
<form:form method="POST" action="reportBug.action" commandName="bug">
Bug Title<form:input path="bugTitle"/>
<form:errors path="bugTitle" cssClass="errClass" /> <br />

Project<form:select path="project.title">
<form:options items="${projList}"/>
</form:select><br />

Description<form:textarea path="description" />
<form:errors path="description" cssClass="errClass" /><br />

Severity<form:select path="severity">
<form:options items="${severityList}" />
</form:select><br />

Status<form:select path="status">
<form:options items="${statusList}" />
</form:select><br />

Created Date<form:input path="createdDate"/>
<form:errors path="createdDate" cssClass="errClass" /><br />

<input type="submit" value="SUBMIT"/>
<input type="button" value="CANCEL" onclick="goHome(this.form)" />"
</form:form>
</body>
</html>