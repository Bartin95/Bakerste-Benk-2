<%-- 
    Document   : createmodule
    Created on : 01.okt.2018, 22:06:41
    Author     : anette jorgensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add module</title>
    </head>
    <body>
         <form action ="addmodule">
             
             Module ID:<br>
             <input type="text" name ="id" style = "width: 50 px"><br><br>
            
             Module title:<br>
             <input type="text" name ="title" style="width: 500px"><br><br>
            
             Module description:<br>
             <textarea name ="description" style ="width:500px; height:100px"></textarea><br><br>
             
             Module requirements: <br>
             <textarea name ="requirement" style ="width:500px; height:100px"></textarea><br><br>
             
             Total points:
             <input type ="text" name ="points" style= "width:50px"><br><br>
             
             <input type ="submit" value ="Create new module">
             <br><br>                     
            
        </form>
        
        <button onclick="createdeliverable.jsp"> Add deliverable </button>
             
              
            
             
           
    </body>
</html>
