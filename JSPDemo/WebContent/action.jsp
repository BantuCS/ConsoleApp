<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

int sum=(int)session.getAttribute("num1")+(int)session.getAttribute("num2");
if(sum%2!=0)
{
	response.sendRedirect("https://www.instagram.com/anil_kshatriya_official/");
}
else
{
	response.sendRedirect("https://www.facebook.com/bantu9");
}
%>

</body>
</html>