<%@page import="traveller.traveller"%>
<%@page import="java.util.ArrayList"%>
<%@page import="traveller.driver"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
	//driver dstatus=(driver)request.getAttribute("dstatus");
	String did=(String)request.getAttribute("did");
	System.out.print(did);
	ArrayList ar=(ArrayList) request.getAttribute("dstatus"); 	
%>

		<table align= 'center' border='1' cellpadding='20'>
	<tr>
			<th>Travel Id</th>
			<th>Source Address</th>
			<th>Destination Address</th>	
			<th>Date</th>
			<th>Time</th>
			<th>Traveller Id</th>
			<th>Traveller phone no</th>
			<th>My Id</th>
			</tr>
			<%
			for(int a=0;a<ar.size();a++)
			{
				driver dr=(driver)ar.get(a);
			%>
			
		<tr>
		<th><%=dr.getTravelid() %></th>
		<th><%=dr.getSource() %></th>
		<th><%=dr.getDestination() %></th>
		<th><%=dr.getDate() %></th>
		<th><%=dr.getTime() %></th>
		<th><%=dr.getEmail()%></th>
		<%
			traveller tr=new traveller();
			tr.setEmail(dr.getEmail());
			String phoneno=tr.gettravellerpno();
		%>
		<th><%=phoneno %></th>
		<th><%=dr.getDid() %></th>
         </tr>
         
			<%
			} 
			%>
	</table>

</body>
</html>