<c:if test="${not empty param.login_error}">
	<font color="red"> Your login attempt was not successful, try
	again.<br />
	<br />
	Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />. </font>
</c:if>

<h1> Social Update Status Demo App</h1>

<h2>Login:</h2>
<form action="<c:url value='/j_spring_security_check'/>" method="post">
	<table>
		<tr>
			<td>User Name:</td>
			<td><input type="text" name='j_username'
				value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='j_password' /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
	</table>
</form>