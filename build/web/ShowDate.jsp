<%-- 
    Document   : ShowDate.jsp
    Created on : Mar 14, 2017, 4:40:24 PM
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
        <form action = "/SeniorProject/ShowDialysisEndServlet">
            <p><a href="/SeniorProject/ShowDialysisEndServlet" ><%=request.getAttribute("showDate")%></a><p>
                <input type="submit" value="fs">
        <br>
        </form>     
         <%
                Object d = request.getSession().getAttribute("userId");
                out.print(d);
         %>
    </body>
</html>
