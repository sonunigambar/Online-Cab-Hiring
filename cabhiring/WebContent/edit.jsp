

<%@page import="traveller.traveller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: cyan;
}

</style>
</head>
<body>
<%
	
	traveller t=(traveller) request.getAttribute("edit");

%>

<center><h1>Update your Profile</h1></center>
<form action='update'>
			
		<table align= 'center' border='1' cellpadding='20'>
			
			<tr>
			
			<th>Address</th>			
			
		<th><input type='text' value='<%= t.getAdr()%>' name='adr'></th>

			</tr>
			
				<tr>
			
			
		<th>Phone No</th>
			
			
			
		<th><input type='text' value='<%=t.getPhno()%>' name='phno'></th>
           
			</tr>
			
			<tr>
			
			
		<th>Password</th>
			
			
			
		<th><input type='text' value='<%=t.getPwd()%>' name='pwd'></th>
           
			</tr>
			
			<tr>
			
		<th colspan='2'><input type='submit'></th>
			
			</tr>
			
			</table>
		</form>
			
		
</body>

</html>