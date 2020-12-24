<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate()
{
	var f=true;

	
	var regx=/^[a-zA-Z0-9_.]{2,50}@[a-zA-Z0-9_.]{2,30}[.][a-zA-Z0-9_.]{2,15}$/
		if(document.myform.email.value.search(regx)==-1)
		{//if match field
				alert("Please enter your valid email id")
				f=false;
		}
	
	return f;
}


</script>
<style type="text/css">
	body{
			background-color:pink;
	}
	</style>
</head>
<body>
<form action="Forgotpwddriver" name="myform"method="get"onsubmit="return validate()">
				<table border="1" align="center" cellpadding="20">
					<tr><th>Enter Your Email Id</th>
						<th align="left"><input type="text" name="email"size="30"></th>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" size="30"></th>
					</tr>
			</table>


		</form>
</body>
</html>