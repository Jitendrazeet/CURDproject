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
        <h1>Sign Up</h1>
        <p>Registration here As Customer ,Sale to Use our Service </p>
         <form method="#" action="#">
         
					<div class="form_settings">
						<p>
							<span>Name</span><input type="text" name="" value="${sessionScope.logInUsers.firstName }" />
						</p>
						<p>
							<span>Email</span><input type="text" name="" value="${sessionScope.logInUsers.loginId }" />
						</p>
						<p>
							<span>Mobile</span><input type="text" name="" value="" />
						</p>
						
						<p>
							<span>Password</span><input type="password" name="" value="" />
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
