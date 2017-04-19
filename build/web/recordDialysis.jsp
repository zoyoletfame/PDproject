<%-- 
    Document   : recordDialysis.jsp
    Created on : Mar 8, 2017, 12:02:02 AM
    Author     : Fame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .menu {
                overflow: hidden;
                background-color: #333;
                font-family: Arial;
            }

            .menu a {
                float: left;
                font-size: 16px;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            .ล้างไต{
                float: left;
                overflow: hidden;
            }

            .ล้างไต .dropbtn {
                font-size: 16px;    
                border: none;
                outline: none;
                color: white;
                padding: 14px 16px;
                background-color: inherit;
            }

            .container a:hover, .dropdown:hover .dropbtn {
                background-color: red;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                float: none;
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                text-align: left;
            }

            .dropdown-content a:hover {
                background-color: #ddd;
            }

            .ล้างไต:hover .dropdown-content {
                display: block;
            }
        </style>
    </head>
    <body>
        <form>
            <div class="menu">
                <div class="ล้างไต">
                    <button class="dropbtn">บันทึกการล้างไต</button>
                    <div class="dropdown-content">
                        <a href="">ล้างไต</a>
                    </div>
                </div>
                <a href="">Home</a>
            </div>
        </form>    
        
        <%
            Object o = request.getAttribute("round");
            int round = Integer.parseInt(o.toString());
        %>
        <%             for (int i = 1; i <= round; i++) {


        %>  
  
        <form action="/SeniorProject/DialysisServlet" method="get">

            รอบที่<%=i%> <h5 style="margin-left: 90%;"><input type="checkbox" name="auto1" value="auto1">ตั้งเวลาอัตโนมัติ</h5>

            <table width="100%" border="1">
                <tr>
                   
                    <%
                        if (request.getAttribute("volIn") != null) {
                    %>
                    <td>น้ำยาเข้า</td>
                    <td>เวลาเริ่ม <%=request.getAttribute("timeIn_start")%>นาที</td>
                    <td>เวลาออก <%=request.getAttribute("timeIn_end")%>นาที</td>
                    <td>ปริมาตร <%=request.getAttribute("volIn")%></td>
                    <%
                    }else{
                    %>
                    <td>น้ำยาเข้า</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartInput1">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndInput1">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityInput1"></td>
                    <%}%>
                </tr>   
                <tr>
                    <td>น้ำยาออก</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartOut1">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndOut1">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityOut1"></td>
                </tr>
                <tr>
                    <td>ปัสสาวะ</td>
                    <td><input type="text" name="urinate1"></td>
                </tr>
            </table>
            <%}%>
            <input type="submit" name="submit" value="บันทึก">
        </form>
    </body>
</html>
