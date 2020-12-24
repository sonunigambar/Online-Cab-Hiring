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
	</style>
</head>
<body  onLoad="return noBack();"background color="aqua">

<p><h1 align="center">SUCCESSFULY LOGGED OUT</h1></p>
<BR>

<center><a href="tlogin.html">LOGIN AGAIN</a></center>
<br>
<br>
<center><a href="homepage.html">GO TO HOME</a></center>
</body>
</html>