<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
		background-color:pink;
}
th{
		color:blue;
		font-size:30px;
}
</style>
</head>
<body>


<% 
		ArrayList ar1=(ArrayList) request.getAttribute("drivers");

		String travelid=(String)request.getAttribute("travelid");
		String travellerid=(String)request.getAttribute("travellerid");
		String source=(String)request.getAttribute("source");
		String destination=(String)request.getAttribute("destination");
%>
	
	<form action='assigndriver'>
	
	<input type="hidden" name="travelid" value="<%=travelid%>">
	<input type="hidden" name="travellerid" value="<%=travellerid%>">
	<input type="hidden" name="source" value="<%=source%>">
	<input type="hidden" name="destination" value="<%=destination%>">
	<table align='center'>

			<tr>
			<br>
			<br>
			<th><u>Available Drivers</u></th>
			</tr>
			<tr>
			<td> <select name="driverid">
			
			<%
				for(int i=0;i<ar1.size();i++)
				{
			%>
				
				<option value='<%=ar1.get(i)%>'><%=ar1.get(i)%></option>				
			<%
				}
			%>	
		</select>	
		
			</td>
	        </tr> 
	         
	          
	       
	               
	        <tr><td colspan='2' align='center'><input type='submit'></td></tr>
	  </table>
	  
	  </form>

</body>

</html>