<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>CRM</title>
   <style type="text/css">
<%@ include file="../style/style.css"%>
</style>
</head>

<body>
  <div id="main">
  <jsp:include page="header.jsp"/>
    <%--  <%@ include file=""%> --%>
    <div id="content_header"></div>
    <div id="site_content">
      <div id="content">
        <!-- insert the page content here -->
        <h1>My Inquiry</h1>
        <p>Inquiry here As Customer ,Sale to Use our Service </p>
         <form method="post" action="postEnquiry">
					<div class="form_settings">
						<p>
							<span>Inquiry related to </span>
							<c:if test="${!empty ModuleList}">
								<select name="module">
									<c:forEach items="${ModuleList}" var="module">
										<option value="${module.id}">${module.name}</option>
									</c:forEach>
								</select>
							</c:if>
							</p>
						<p>
							<span>Description</span>
							<textarea rows="8" cols="50" name="message" required></textarea>
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="contact_submitted" value="submit" />
						</p>
					</div>
				</form>
        <p><br /><br />NOTE: A contact form such as this would require some way of emailing the input to an email address.</p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; CRM :Customer Relationship Management 
    </div>
  </div>
</body>
</html>
