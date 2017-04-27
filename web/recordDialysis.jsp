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
        <br>

        <br>
        <form action="/SeniorProject/DialysisServlet" method="get">
            <%
                if (request.getAttribute("volIn") != null) {
            %>
            <input type="textfield" name="date" value="${dates}" readonly>  

            <%
            } else {
            %>
            <input type="textfield" name="date" value="${date}" readonly>  
            <%}%>
            <br>
            รอบที่ <h5 style="margin-left: 90%;"><input type="checkbox" name="auto1" value="auto1">ตั้งเวลาอัตโนมัติ</h5>

            <table width="100%" border="1">
                <tr>

                    <%
                        if (request.getAttribute("volIn") != null) {
                    %>
                    <td>น้ำยาเข้า</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartInput" value="${timeIn_start}">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndInput" value="${timeIn_end}">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityInput" value="${volIn}"> </td>                  
                    <td>ความเข้มข้น <select name="intensity" >
                            <option value="0.5" ${intensity==0.5?selected:""}>0.5</option>
                            <option value="1" ${intensity==1?selected:""} >1</option>
                            <option value="1.5" ${intensity==1.5?selected:""}>1.5</option>
                            <option value="2" ${intensity==2?selected:""}>2</option>
                            <option value="2.5" ${intensity==2.5?selected:""}>2.5</option>
                            <option value="3">3 ${intensity==3?selected:""}</option>
                        </select>
                    </td>
                <tr>
                    <td>น้ำยาออก</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartOut">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndOut">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityOutput"></td>
                </tr>
                <tr>
                    <td>ปัสสาวะ</td>
                    <td><input type="text" name="urinate"></td>
                    <td> ลักษณะน้ำยา  <select name="desDia">
                            <option value="เหลืองใส">เหลืองใส</option>
                            <option value="ขาวใส">ขาวใส</option>

                        </select>
                    </td>

                </tr>
                </tr>
                <tr>
                <tr>

                    <%
                    } else if (request.getAttribute("volIn") != null && request.getAttribute("volOut") != null) {
                    %>
                    <td>น้ำยาเข้า</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartInput" value="${timeIn_start}">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndInput" value="${timeIn_end}">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityInput" value="${volIn}"> </td>
                    <td>ความเข้มข้น <select name="intensity" >
                            <option value="0.5" ${intensity==0.5?selected:""}>0.5</option>
                            <option value="1" ${intensity==1?selected:""} >1</option>
                            <option value="1.5" ${intensity==1.5?selected:""}>1.5</option>
                            <option value="2" ${intensity==2?selected:""}>2</option>
                            <option value="2.5" ${intensity==2.5?selected:""}>2.5</option>
                            <option value="3">3 ${intensity==3?selected:""}</option>
                        </select>
                    </td>          
                </tr>
                <tr>
                    <td>น้ำยาออก</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartOut">นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndOut">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityOutput"></td>
                </tr>
                <tr>
                    <td>ปัสสาวะ</td>
                    <td><input type="text" name="urinate"></td>
                    <td> ลักษณะน้ำยา  <select name="desDia">
                            <option value="เหลืองใส">เหลืองใส</option>
                            <option value="ขาวใส">ขาวใส</option>

                        </select>
                    </td>

                </tr>
                <tr>
                    <%
                    } else {
                    %>
                    <td>น้ำยาเข้า</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartInput" >นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndInput">นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityInput"></td>
                    <td>ความเข้มข้น <select name="intensity">
                            <option value="0.5">0.5</option>
                            <option value="1">1</option>
                            <option value="1.5">1.5</option>
                            <option value="2">2</option>
                            <option value="2.5">2.5</option>
                            <option value="3">3</option>
                        </select> </td>
                <tr>
                    <td>น้ำยาออก</td>
                    <td>เวลาเริ่ม <input type="time" name="timeStartOut" readonly>นาที</td>
                    <td>เวลาออก <input type="time" name="timeEndOut" readonly>นาที</td>
                    <td>ปริมาตร <input type="text" name="capacityOutput" readonly></td>
                </tr>
                <tr>
                    <td>ปัสสาวะ</td>
                    <td><input type="text" name="urinate" readonly></td>
                    <td> ลักษณะน้ำยา  <select name="desDia" readonly>
                            <option value="เหลืองใส">เหลืองใส</option>
                            <option value="ขาวใส">ขาวใส</option>

                        </select>
                    </td>

                </tr>
                <%}%>
                </tr>   

            </table>

            <input type="submit" name="submit" value="บันทึก">
        </form>
    </body>
</html>
