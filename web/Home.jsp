<%-- 
    Document   : Home
    Created on : Mar 30, 2017, 11:29:31 PM
    Author     : Fame
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="Home.jsp">HOME</a>


        <p><a href ="CreateRecord.jsp">สร้าง</a></p>
        <form action="/SeniorProject/recordTableServlet">
            <p><a href ="/SeniorProject/recordTableServlet">ดูประวัติ</a></p>
        </form>

        <c:forEach items = "${showDate}" var = "showBack">

            <form action = "/SeniorProject/ShowDialysisEndServlet">    
                <input type="textfiled" name="date" value=" ${showBack.thaiDate}" readonly>
                รอบที <input type="textfiled" name="maxRound" value=" ${showBack.round}" readonly>
                <a href="ShowDialysisEndServlet?dateLoop=${showBack.thaiDate}">น้ำออก</a>
                <a href="resolveRecordServlet?dateLoop=${showBack.thaiDate}&maxRound=${showBack.round}">แก้ไข</a>  
                <a href="deleteServlet?date=${showBack.thaiDate}">ลบ</a>

                <%--      <c:choose>
                                  <c:when test = "${showBack==showBack}">
                                    
                                      <c:choose>
                                          <c:when test = "${volOut != null}">
                                              <a href="resolveRecordServlet?date=${showBack}">แก้ไข</a> 
                                                <a href="deleteServlet?date=${showBack}">ลบ</a>  
                                          </c:when>
                                          <c:otherwise>
                                              
                                          </c:otherwise>
                                      </c:choose>
                                  </c:when>
                              </c:choose>
                --%>
            </form> 

        </c:forEach>

    </body>
</html>
