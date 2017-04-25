<%-- 
    Document   : recordTable
    Created on : Mar 26, 2017, 6:10:05 PM
    Author     : Fame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><center>บันทึกการล้างไต</center></p>
<table width = "100%" border = "1">
    <tr>
        <th rowspan="2">วันที่</th>
        <th rowspan="2">รอบที่</th>
        <th rowspan="2">ปริมาณความเข้มข้นนน้ำยา</th>
        <th colspan="3">น้ำยาเข้า</th>
        <th colspan="3">น้ำยาออก</th>
        <th rowspan="2">กำไรขาดทุน</th>
        <th rowspan="2">สุทธิ</th>
        <th rowspan="2">ปัสสาวะ</th>
        <th rowspan="2">น้ำหนัก</th>
        <th rowspan="2">ความดันโลหิต</th>
        <th rowspan="2">หมายเหตุ</th>
    </tr>
    <tr>
        <td>เวลาเริ่ม</td>
        <td>เวลาหมด</td>
        <td>ปริมาตร</td>
        <td>เวลาเริ่ม</td>
        <td>เวลาหมด</td>
        <td>ปริมาตร</td>

    </tr>
      <c:forEach items="${dia}" var="record">
    <tr>
       
            <td>${record.date}</td>
            <td>${record.round}</td>
            <td>1</td>
            <td>${record.timeDiaIn_start}</td>
            <td>${record.timeDiaIn_end}</td>
            <td>${record.volDiaIn}</td>
            <td>${record.timeDiaOut_start}</td>
            <td>${record.timeDiaOut_end}</td>
            <td>${record.volDiaOut}</td>
            <td>${record.profit}</td>
            <td>${record.totalProfit}</td>
            <td>${record.urinate}</td>
            <td>${record.weight}</td>
            <td>${record.bloodPressure}</td>
            <td>${record.desDiaLiquid}</td>
    </tr>
      </c:forEach>
</table>
</body>
</html>
