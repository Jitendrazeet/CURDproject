<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>CRM :Customer Registration Management</h2>
<table width="100%" border="0">

	<tr>
		<td colspan="3" width="841" height="108">
			<form name="form1" method="post" action="customerInquiryResult">
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
									<span class="style3">Inquiry : </span>
								</div>
							</td>

						</tr>
						<tr>
							<td valign="top" align="center">
								<p align="right">
									<span style="font-family: Verdana; font-size: 10pt">Brief
										Profile or Message</span><br>
									<textarea name="message" rows="10" id="message" cols="30">							
						</textarea>
							<td width="17%">
								<div align="left">
									<input type="submit" name="Submit" value="Submit"> <br>
									<a href="customerLogOut">Log Out</a>
								</div>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>

						</tr>

					</table>

				</div>
			</form>

		</td>
	</tr>
</table>