<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CRM</title>
   <style type="text/css">
<%@ include file="../style/style.css"%>
</style>
</head>
<body>
<div id="main">
<c:out value="${sessionScope.EnquiryDetails}"> </c:out>
  <jsp:include page="header.jsp"/>
    <%--  <%@ include file=""%> --%>
    <div id="content_header"></div>
    <div id="site_content">
      <div id="content">
      
      <a href="listOfQuery" ><b> <b>Back To List</b> </b></a>
        <!-- insert the page content here -->
        <h1> Queries DashBoard </h1>
        <p>Resolution In Short Process   </p>
         <form method="post" action="assignToUser">
         	<div class="form_settings">

						<p>
							<span>Posted By</span><input type="text" readonly
								value="${EnquiryDetails.postedBy.logInId}" />
						</p>
						<p>
							<span>Posted On</span><input type="text" name="postedOn"
								value="${EnquiryDetails.postedOn}" readonly />
						</p>

						<p>
							<span>Status</span><input type="text" readonly
								value="${EnquiryDetails.status}" />
						</p>
						<p>
							<span>Inquiry related to </span>
							<input type="text" readonly
								value="${moduleName}" />
							
						<p>
						
						<p>
							<span>Message</span>
							<textarea rows="6" cols="50"
								placeholder="${EnquiryDetails.message}"></textarea>

						</p>
						<p>
							<span>Assign to</span>
							<c:if test="${!empty AssignToList}">
								<select name="assignedTo">
									<c:forEach items="${AssignToList}" var="user">
										<option value="${user.logInId}">${user.firstName}</option>
									</c:forEach>
								</select>
							</c:if>
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="contact_submitted" value="Assign To" />
						</p>
						
			</div>
				</form>
        <p><br/><br />NOTE: A contact form such as this would require some way of email the input to an email address.</p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; CRM :Customer Relationship Management 
    </div>
  </div>
	
</body>
</html>
