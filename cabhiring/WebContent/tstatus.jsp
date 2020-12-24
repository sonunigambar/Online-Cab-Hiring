<%@page import="traveller.rate"%>
<%@page import="traveller.travellingrequest"%>
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
</style>
</head>
<body>

<%
	//ArrayList ar=(ArrayList) request.getAttribute("tstatus"); 

	
	travellingrequest tstatus=(travellingrequest)request.getAttribute("tstatus");
	//int amount= (Integer) request.getAttribute("amount");	
	String tid = (String)request.getAttribute("tid");
	
%>





		<table align= 'center' border='1' cellpadding='20'>
			
			
			<tr>	
			<th>Source Address</th>
			
           <th><%=tstatus.getSource() %></th>
			</tr>
			
			<tr>
			<th>Destination Address</th>
			<th><%=tstatus.getDestination() %></th>
			</tr>
			<tr>
			<th>Date</th>
			 <th><%=tstatus.getDate() %></th>
			</tr>
			
			
			<tr><th>Time</th>
			 <th><%=tstatus.getTime() %></th>
			</tr>
			
			<% rate rt=new rate();
			
			rt.setSource(tstatus.getSource());
			rt.setDestination(tstatus.getDestination());
			int fare = rt.getfare(); %>
			
			<tr><th>Amount</th>
			 <th><%=fare%></th>
			</tr>
		
			
			<tr><th colspan="2"><a href='carddetails.jsp?amount=<%=fare%>&tid=<%=tid%>'> Make Payement</a></th>
		
			</tr>
			</table>
		
		

</body>
</html>