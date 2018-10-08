<%-- 
    Document   : ModuleDetails
    Created on : 08.okt.2018, 12:53:54
    Author     : anette jorgensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Module</title>
          <style>
                table,th,td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th {
                text-align: left;
            }                   
        </style>
    </head>
    <body>
        <div style ="width: 1200px; margin-right: auto;">
            
                <c:forEach items = "${viewModuleById}" var = "p">
                    
                    <h1>${p.modID}: ${p.modTitle} </h1>
                    
                    <h2>Module description:</h2>
                    ${p.modDescription}<br>
                    
                    <h2>Module requirements:</h2>
                    ${p.modRequirements}<br>
                    
                    <h2>Total points for this module:</h2>
                    ${p.modPoints}<br>
                    
                   
                    <a href ="edit?id=${p.modID}">Edit</a>
                    <a href ="delete?id=${p.modID}">Delete</a>
                       
                </c:forEach>
            </table>
        </div>
    </body>
</html>
