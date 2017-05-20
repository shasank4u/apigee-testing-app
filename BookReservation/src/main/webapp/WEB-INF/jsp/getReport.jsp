<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Report</title>
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
<form:form action="getReport.action" method="POST" commandName="report" >
Project <form:select path="project.title">
<form:options items="${projList}"/> 
</form:select><br />
Severity<form:select path="severity">
<form:options items="${severityList}" />
</form:select><br />

Status<form:select path="status">
<form:options items="${statusList}" />
</form:select><br />

Start Date<form:input path="startDate"/>
<form:errors  path="startDate" cssClass="errClass"/><br />

End Date<form:input path="endDate"/>
<form:errors  path="endDate" cssClass="errClass"/><br />

<input type="submit" value="SEARCH"/>
<input type="button" value="CANCEL" onclick="goHome(this.form)" /><br />

<c:if test="${requestScope.flag}">
<table border="5">
<tr>
<th>Project</th>
<th>Number of</th>
<th>Bug</th>
<th>Bug</th>
<th>Bug </th>
<th>Bug</th>
<th>Bug</th>
</tr>
<tr>
<th>Name</th>
<th> Team Members</th>
<th>Title</th>
<th> Description</th>
<th>Severity</th>
<th>Status</th>
<th>Created On</th>
</tr>

<c:forEach var="report" items="${reportList}">

<tr>
<td>${report[0]}</td>
<td>${report[1]}</td>
<td>${report[2]}</td>
<td>${report[3]}</td>
<td>${report[4]}</td>
<td>${report[5]}</td>
<td>${report[6]}</td>
</tr>


</c:forEach>
</table>


</c:if>
</form:form>
</body>
</html>