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
        <h1>List Of Queries</h1>
        <p>Queries  list here of Customer  </p>
         <form method="post" action="">
					<div class="form_settings">

						<table class="table">
							<tbody>
								<tr>
									<td><b>PostedBy</b></td>
									<td><b>PostedOn</b></td>
									<td><b>Status</b></td>
									<td><b>Message</b></td>
								</tr>
								<c:forEach items="${ListOfQueries}" var="enquiry">
									<tr>
										<td>${enquiry.postedBy.firstName}</td>
										<td>${enquiry.postedOn}</td>
										<td>${enquiry.status}</td>
										<td>${enquiry.message}</td>
										<td><a href="openDashBoard/${enquiry.postedOn}"><b> Open </b></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="pagination">
							<a href="previousPagelistOfQuery">&laquo;</a> <a href="nextPagelistOfQuery">1</a> <a href="nextPagelistOfQuery">2</a> <a
								href="nextPagelistOfQuery">3</a> <a href="nextPagelistOfQuery">&raquo;</a>
						</div>
					</div>
				</form>
        <p><br /><br />NOTE: A contact form such as this would require some way of email the input to an email address.</p>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; CRM :Customer Relationship Management 
    </div>
  </div>
  	
</body>
</html>
