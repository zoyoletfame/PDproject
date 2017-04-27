<%-- 
    Document   : rr
    Created on : Mar 11, 2017, 5:59:00 PM
    Author     : Jenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
  
  <form action="/SeniorProject/RoundServ" method="post">
      <input type="date" name="date">
            รอบ  <select name="roundSelect">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="3">3</option>
                     <option value="4">4</option>
                     <option value="5">5</option>
                     <option value="6">6</option>
                 </select>
            ครั้ง
            <input id="saveRound" type="submit" value="บันทึก">
</form>
    
</body>
</html>