<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>CRM :Customer Registration Management</h2>
<table width="100%" border="0">

	<tr>
		<td colspan="3" width="841" height="108">
			<form name="form1" method="post" action="customerUpdateAddress">
				<!-- loginchk.asp-->
				<div align="left">
					<table width="50%" border="0">

						<tr>
							<td colspan="3"><font face="verdana" size="2" color="RED">
									<c:out value="${errorMsg}" />
							</font></td>
						</tr>
						<tr>
							<td>
								<div align="right">
									<span class="style3">Name: </span>
								</div>
							</td>
							<td colspan="2">
								<div align="left">
									<span class="style3"><input name="firstName" type="text"
										id="firstName" size="20"
										value='${sessionScope.logInCustomer.firstName}'> </span>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									<span class="style3"> </span>
								</div>
							</td>
							<td colspan="2">
								<div align="left">
									<span class="style3"><input type="text" size="20"
										value='       Enter Your Address' readonly> </span>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									<span class="style3">City: </span>
								</div>
							</td>
							<td colspan="2">
								<div align="left">
									<span class="style3"><input name="address.city"
										type="text" id="address.city" size="20"
										value='${sessionScope.logInCustomer.address.city}'> </span>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									<span class="style3">County: </span>
								</div>
							</td>
							<td colspan="2">
								<div align="left">
									<span class="style3"><input name="address.country"
										type="text" id="address.country" size="20"
										value='${sessionScope.logInCustomer.address.country}'>
									</span>
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td width="17%">
								<div align="left">
									<input type="submit" name="Submit" value="Update"> <a
										href="customerInquiry">Inquiry</a> <a href="customerLogOut">Log
										Out</a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>

		</td>
	</tr>
</table>