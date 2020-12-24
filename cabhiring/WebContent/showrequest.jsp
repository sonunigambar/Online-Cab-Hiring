<%@page import="java.util.ArrayList"%>
<%@page import="traveller.travellingrequest"%>
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
h1,h2{
		color:blue;
}
</style>
</head>
<body>
<%
	ArrayList ar=(ArrayList) request.getAttribute("shawrequest"); 
	
	
%>

<table align= 'center' border='1' cellpadding='20'>
			
			<tr>
			<th>Travel Id</th>
			<th>Source Address</th>
			<th>Destination Address</th>	
			<th>Date</th>
			<th>Time</th>
			<th>Traveller Id</th>
			<th>Driver assign</th>
			</tr>
			<%
			for(int a=0;a<ar.size();a++)
			{
				travellingrequest tr=(travellingrequest)ar.get(a);
			%>
			
			<tr>
			 <th><%=tr.getTravelid() %></th>
			 <th><%=tr.getSource() %></th>
          	 <th><%=tr.getDestination() %></th>
         	  <th><%=tr.getDate() %></th>
         	  <th><%=tr.getTime() %></th>
         	   <th><%=tr.getTravellerid() %></th>
         	   
         	   
         	  <th><a href='availabledriver?tdt=<%=tr.getDate()%>&travelid=<%=tr.getTravelid()%>&travellerid=<%=tr.getTravellerid()%>&source=<%=tr.getSource()%>&destination=<%=tr.getDestination()%>'>assigndriver</a></th>
			</tr>
			
			<%
			} 
			%>

</table>

</body>
</html>