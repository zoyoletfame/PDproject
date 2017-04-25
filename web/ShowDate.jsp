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
            <input type="hidden" name="roundId" value="${roundId}">
            
            <p><a href="Home.jsp">HOME</a>
            <p><%=request.getAttribute("showDate")%><p> <input type="submit" value="น้ำเข้า">
            <p><a href="/SeniorProject/recordTableServlet">ดูประวัติ</a> 
            
        <br>
        </form>     
         
          
           
    </body>
</html>
