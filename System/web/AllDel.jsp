<%-- 
    Document   : AllDel
    Created on : 09.okt.2018, 13:14:45
    Author     : anette jorgensen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
       <h1>All deliverables</h1>
        <div style ="width: 1200px;  margin-right: auto;">
            <table cellpadding ="10">
                <tr>
                    <th>Deliverable ID</th>
                    <th>Description</th>
                    <th>Feedback</th>
                    <th>Points</th>
                    <th>Status</th>
                    <th>Module ID</th>
                                                          
                </tr>
                <c:forEach items = "${AllDel}" var = "b">
                    <tr>
                        <td>${b.del_ID}</td>
                        <td>${b.del_description}</td>
                        <td>${b.del_feedback}</td>
                        <td>${b.del_points}</td>
                        <td>${b.del_status}</td>
                        <td>${b.mod_ID}</td>
                        <td>
                            <a href ="view?id=${b.mod_ID}">View</a>
                            <a href ="edit?id=${b.mod_ID}">Edit</a>
                            <a href ="delete?id=${b.mod_ID}">Delete</a>
                        </td>
                        
                            
                      </tr>
                </c:forEach>
            </table>  
        </div>
    </body>
</html>
