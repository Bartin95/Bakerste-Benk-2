<%-- 
    Document   : AddDeliverable
    Created on : 09.okt.2018, 10:29:16
    Author     : anett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <body>
         <form action ="addDeliv">
             
             Deliverable ID:<br>
             <input type="text" name ="del_id" style = "width: 50 px"><br><br>
             
             Module ID:<br>
             <input type="text" name ="mod_id" style = "width: 50 px"><br><br>
                          
             Deliverable description:<br>
             <textarea name ="description" style ="width:500px; height:100px"></textarea><br><br>
             
             Deliverable feedback: <br>
             <textarea name ="feedback" style ="width:500px; height:100px"></textarea><br><br>
             
             Total points:<br>
             <input type ="text" name ="points" style= "width:50px"><br><br>
             
             Deliverable status (Approved/Not approved): <br>
             <input type ="text" name ="status" style= "width:50px"><br><br>
             
             <input type ="submit" value ="Add deliverable">
             <br><br>                     
            
        </form>
    </body>
</html>
