<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
	<div id="logo">
		<div id="logo_text">
			<!-- class="logo_colour", allows you to change the colour of the text -->
			<h1>
				<a href="index.html">GPS-SIM<span class="logo_colour">CRM</span></a>
			</h1>
			<h2>CRM :Customer Relationship Management</h2>
		</div>
	</div>
	<div id="menubar">
		<ul id="menu">
			<li><a href="homePage">Home</a></li>

			<li><a href="#">Contact Us</a></li>
			<li><a href="listOfQuery">List Of Queries</a></li>
			
			<c:choose>
				<c:when test="${sessionScope.logInUser != null }">
				<li><a href="myPage">Profile</a></li>
					<li><a href="myQuerysPage">Query</a></li>
					<li><a href="LogOut">Log Out</a></li>
					<font face="verdana" size="2" color="red"><c:out
	 				value="Welcome :${sessionScope.logInUser.firstName }" />
					</font>
				</c:when>

				<c:otherwise>
					<li><a href="signUpPage">SignUp</a></li>
					<li><a href="loginPage">LogIn</a></li>
				</c:otherwise>
				
			</c:choose>
			
		</ul>
	</div>
</div>
<h2>
	<font face="verdana" size="2" color="red"> <c:out
			value="${errorMsg}" />

	</font>
	
</h2>

