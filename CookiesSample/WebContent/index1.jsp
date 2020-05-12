<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% 
    
    String name= request.getParameter("text1");
    String pass= request.getParameter("text2");
    
    Cookie cku= new Cookie("cku",name);
    Cookie ckp= new Cookie("ckp",pass);
    
    cku.setMaxAge(10);
    ckp.setMaxAge(10);
    
    response.addCookie( cku );
    response.addCookie( ckp );
    %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>
   <%= request.getParameter("name")%>
   <%= request.getParameter("pass")%>
</body>
</html>