<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Protein</title>
</head>
<body>
	<center>
		<h1>Protein Add</h1>

		<s:form>
			<s:textfield name="enteredProtein"></s:textfield>
			<s:submit value="Enter"></s:submit>
		</s:form>

		<div><s:text name="last.text"/>  : <s:property value="enteredProtein" /></div>
		<div><s:text name="total.text"/> : <s:property value="proteinData.total"/></div>
		<div><s:text name="goal.text"/>  : <s:property value="proteinData.goal"/></div>

		<a href="<s:url action="add-goal"/>">Edit Goal</a>

		<s:if test="%{proteinData.total >= proteinData.goal}">
			<s:property value="resetTotal()" />
		</s:if>		
	</center>
</body>
</html>