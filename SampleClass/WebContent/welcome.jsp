<html>  
<body>  
<%   
String name=request.getParameter("uname");  
out.print("Welcome "+name);   
session.setAttribute("user",name);  

</body>  
</html>  