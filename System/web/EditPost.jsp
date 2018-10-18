<%-- 
    Document   : EditPost
    Created on : 04.okt.2018, 09:34:58
    Author     : anett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Module</title>
        <style>
        
        </style>
    </head>
    <body>
        <h1>Edit Module</h1>
        <c:forEach items = "${getModuleById}" var = "p">
         <form action ="editmodule">
             <input type ="hidden" value ="${p.modID}">
            
             Module ID:<br>
             <input type="text" value ="${p.modID}" name = "id" style="width:50 px"><br><br>
            
             Module title:<br>
             <input type="text" value ="${p.modTitle}" name ="title" style="width: 500px"><br><br>
             
             Module description:<br>
             <textarea name ="description" style ="width:500px; height:100px">${p.modDescription}</textarea><br><br>
             
             Module requirements: <br>
             <textarea name ="requirement" style ="width:500px; height:100px">${p.modRequirements}</textarea><br><br>
             
             Total points:<br>
             <input type ="text" value = "${p.modPoints}" name ="points" style= "width:50px"><br><br>
             
             <input type ="submit" value ="Update module">
             <br><br>    
         </form>
        </c:forEach>
</html>
