<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a New Project</title>
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
<form:form method="POST" action="addProject.action" commandName="project">
Project Title<form:input path="title"/>
<form:errors path="title" cssClass="errClass"/> <br />

Start Date<form:input path="startDate"/>
<form:errors path="startDate" cssClass="errClass"/><br />

End Date<form:input path="endDate"/>
<form:errors path="endDate" cssClass="errClass"/><br />

Description<form:textarea path="description"/>
<form:errors path="description" cssClass="errClass"/><br />

Employee List<form:select path="employees">
<form:options items="${empList}"/>
</form:select><br />

<input type="submit" value="SUBMIT" />
<input type="button" value="CANCEL" onclick="goHome(this.form)" />"
</form:form>

</body>
</html>