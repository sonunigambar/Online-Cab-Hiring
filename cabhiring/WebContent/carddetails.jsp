<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
        window.history.forward();
        function noBack()
        {
            window.history.forward();
        }
	</script>

<style type="text/css">
body{
		background-color:pink;
}
h1,h2{
		color:green;
}
</style>
</head>
<body onLoad="noBack();">

<%	int amount=Integer.parseInt(request.getParameter("amount"));

	
		//PrintWriter pw=response.getWriter();
		//pw.print(amount);
		

	String tid = request.getParameter("tid");
	String DriverId = request.getParameter("DriverId");

%>

<h1>
<center>Make Payment</center></h1>
<form action ="carddetails">
<input type="hidden" name="tid" value="<%=tid%>" >
<input type="hidden" name="driverid" value="<%=DriverId%>" >
<table border="1" align="center" cellpadding="20">
<tr>
<th>Card No</th>
<th align="left"><input type="text" name="cardno" size="30"></th>
</tr>
<tr>
<th>Pin</th>
<th align="left"><input type="password" name="pin" size="30"></th>
</tr>

<tr>
<th>Expiry Month</th>
<th align="left"><input type="text" name="expmonth" size="30"></th>
</tr>

<tr>
<th>Expiry Year</th>
<th align="left"><input type="text" name="expyear" size="30"></th>
</tr>
<tr>
<th>Cardholder Name</th>
<th align="left"><input type="text" name="cardholdername" size="30"></th>
</tr>

<input type="hidden" name="amount" value="<%=amount %>" ></th>


<tr>
<th colspan="2"><input type="submit" value="Submit"size="50"></th>
</tr>

</table>
</form>

</body>
</html>