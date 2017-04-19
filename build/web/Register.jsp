<%-- 
    Document   : Register
    Created on : Mar 30, 2017, 11:29:21 PM
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
        <form action="/SeniorProject/RegisterServlet">
            Username : <input type="text" name="user"><br>
            Password : <input type="text" name="password"><br>
            ชื่อ       : <input type="text" name="fname"><br>
            นามสกุล   : <input type="text" name="lname"><br>
            เพศ      : <input type="radio" name="sex" value="ชาย">ชาย<br>
            <input type="radio" name="sex" value="หญิง">หญิง<br>
            <input type="submit" name="submit" value="สมัครสมาชิก">
        </form>
        <% if(request.getAttribute("message") == null){
            out.print(" ");
        %>
        <%}else{
        %>  
          <%=request.getAttribute("message")%>
        <%}%>
    </body>
</html>
