<%-- 
    Document   : Home
    Created on : Mar 30, 2017, 11:29:31 PM
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
        <p><a href ="Login.jsp">Login</a></p><br>
        <p><a href ="Register.jsp">Register</a></p>
        <p><a href ="CreateRecord.jsp">สร้าง</a></p>
        <form action="/SeniorProject/recordTableServlet">
        <p><a href ="/SeniorProject/recordTableServlet">ดูประวัติ</a></p>
        </form>
          <%
                Object d = request.getSession().getAttribute("userId");
                out.print(d);
            %>
    </body>
</html>
