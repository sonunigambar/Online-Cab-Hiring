<%@page import="traveller.admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<%
	ArrayList ar=(ArrayList) request.getAttribute("getalldetails"); 
	
	
%>

<table align= 'center' border='1' cellpadding='20'>
			
			<tr>
			<th>Travel Id</th>
			<th>Traveller Id</th>
			<th>Source Address</th>
			<th>Destination Address</th>	
			<th>Travel Date</th>
			<th>Time</th>
			<th>Driver assign</th>
			<th>Payment status</th>
			</tr>
			<%
			for(int a=0;a<ar.size();a++)
			{
				admin ad=(admin)ar.get(a);
			%>
			
			<tr>
			 <th><%=ad.getTravelid() %></th>
			<th><%=ad.getTid() %></th>
         	   <th><%=ad.getSource() %></th>
         	   <th><%=ad.getDestination() %></th>
         	   <th><%=ad.getDate() %></th>
         	   <th><%=ad.getTime() %></th>
         	   <th><%=ad.getDid() %></th>
         	   <th><%=ad.getPstatus() %></th>
         	   
         	 
			</tr>
			
			<%
			} 
			%>

</table>

</body>
</html>