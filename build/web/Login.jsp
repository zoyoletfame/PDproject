<%-- 
    Document   : Login
    Created on : Mar 30, 2017, 11:25:05 PM
    Author     : Fame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="/SeniorProject/LoginServlet"> 
            username : <input type="text" name="username"><br>
            password :<input type="password" name="password"><br>
            <input type="submit" name="submit" value="เข้าสู่ระบบ">
        </form>
        <p><a href ="Register.jsp">Register</a></p>
        <br>
        <%
            if(request.getAttribute("msg") == null){
                out.print(" ");
            }else{
                out.print(request.getAttribute("msg"));
            }
        %>
    </body>
</html>
