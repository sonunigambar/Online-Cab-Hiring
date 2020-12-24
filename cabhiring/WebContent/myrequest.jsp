<%@page import="java.util.ArrayList"%>
<%@page import="traveller.driver"%>
<%@page import="traveller.paymentinfo"%>
<%@page import="traveller.travellerrequest"%>
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
	ArrayList ar=(ArrayList) request.getAttribute("myallrequest"); 
	//int amount= (Integer) request.getAttribute("amount");
	
%>

<table align= 'center' border='1' cellpadding='20'>
			
			<tr>
			<th>Travell Id</th>
			<th>Source Address</th>
			<th>Destination Address</th>	
			<th>Date</th>
			<th>Time</th>
			<th>driver id</th>
			<th>driver phno</th>
			<th>Pstatus</th>
			</tr>
			<%
			
			for(int a=0;a<ar.size();a++)
			{
				travellerrequest tr = (travellerrequest)ar.get(a);
				
			%>
			
			<tr>
			<th><%=tr.getTravelid()%></th>
			
			<%  paymentinfo pi=new paymentinfo();
			pi.setTravelid(tr.getTravelid());
			int amount=pi.getamount(); 
			
			
			driver dr=new driver();
			dr.setTravelid(tr.getTravelid());
			dr=dr.getpnodid();
			
			%>
			
			 <th><%=tr.getSource() %></th>
          	 <th><%=tr.getDestination() %></th>
         	  <th><%=tr.getDate() %></th>
         	  <th><%=tr.getTime() %></th>
         	  <%
         	  	if(tr.getPstatus()!=null)
         	  	{
         	  		%>
         	  		<th><%=dr.getDid() %></th>
         	  		<th><%=dr.getPhno() %></th>
         	  	<% } else { %>
         	  		<th>Not assigned</th>
         	  		<th>Not assigned</th>
         	  	<% } %>
         	    <%
         	  	if(tr.getPstatus()==null)
         	  	{
         	  %>
         	  <th>Driver Not Assigned</th>   	  
         	  <%
         	  	}
         	  	else if(tr.getPstatus().equals("Paid"))
         	  	{
         	  %>
         	  	<th><%=tr.getPstatus()%></th>
         	  <%} 
         	  	else
         	  	{
         	  		
         	  %>
         	  <th><a href='carddetails.jsp?tid=<%=tr.getTravelid()%>&amount=<%=amount%>&DriverId=<%=dr.getDid()%>'>Pay</a></th>
         	  <%}
         	   }%>
			</tr>
			
		

</table>

</body>
</html>