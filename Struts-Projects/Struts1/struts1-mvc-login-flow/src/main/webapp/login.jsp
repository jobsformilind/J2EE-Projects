<%@taglib uri="struts-html.tld" prefix="html" %>
<html>
<head>
<title>Login Page</title>
</head>
<body>
<center>
    <div style="color:red">
    	<html:errors/>
    </div><br/>
    <html:form action="/Login" >
    <table>
    	<tr align="left" valign="middle">
        	<td>User Name </td><td>: <html:text name="LoginForm" property="userName" /><td>
        </tr>
        <tr align="left" valign="middle">
        	<td>Password  </td><td>: <html:password name="LoginForm" property="password" /><td>
        </tr>
        <tr align="center" valign="middle">
        	<td colspan="2"><html:submit value="Login" /><td>
        </tr>
    </html:form>
<center>
</body>
</html>