<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CRM</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
	<h2>CRM :Customer Login Management</h2>
	<form method="get" action="customerLogInValidate">
		<c:if test="${!empty roleList}">
			<select name="role">
				<c:forEach items="${roleList}" var="role">
					<option value="${role.roleId}">${role.roleName}</option>
				</c:forEach>
			</select>
		</c:if>
		<table>
			<tr>
				<td colspan="3"><font face="verdana" size="2" color="RED">
						<c:out value="${errorMsg}" />
				</font></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="logiId" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SignIn" /><a
					href="homePage">Home</a></td>
			</tr>
		</table>
	</form>
</body>
</html>