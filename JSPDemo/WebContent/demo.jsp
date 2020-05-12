<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int result=0; %>

<% int number1 = Integer.parseInt(request.getParameter("text1"));
   int number2 = Integer.parseInt(request.getParameter("text2"));
%>
   
<%=number1+number2 %> 
<% out.print(number1-number2); %> 
<%
if((number1+number2)%2==0){
out.print("hello");
	}

else{
	out.print("bye");
}

session.setAttribute("num1",number1); 
session.setAttribute("num2",number2); 
%> 
<a href="action.jsp">response</a>
</body>
</html>