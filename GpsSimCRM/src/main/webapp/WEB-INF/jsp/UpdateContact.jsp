<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CRM</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
	<h2>Update CRM Details</h2>

	<form:form method="post"
		action="/CRM/updateDetails${contactDetails.id}"
		commandName="contact">

		<table>

			<tr>
				<td><form:label path="firstName">

						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstName"
						value="${contactDetails.firstName}" /></td>
			</tr>

			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" value="${contactDetails.email}" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastName"
						value="${contactDetails.lastName}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.update"/>" /></td>
			</tr>

		</table>
	</form:form>


	<h3>Records</h3>
	<c:if test="${!empty contactList}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.firstName}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td><a href="update/${contact.id}">Update</a></td>
					<td><a href="delete/${contact.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>