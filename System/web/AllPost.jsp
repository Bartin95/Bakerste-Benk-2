<%-- 
    Document   : modules
    Created on : 03.okt.2018, 17:31:40
    Author     : anette jorgensen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modules</title>
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
        <div style ="width: 1200px;  margin-right: auto;">
            <table cellpadding ="10">
                <tr>
                    <th>Module ID</th>
                    <th>Module Title</th>
                    <th>Module Description</th>
                                                          
                </tr>
                <c:forEach items = "${AllPost}" var = "p">
                    <tr>
                        <td>${p.modID}</td>
                        <td>${p.modTitle}</td>
                        <td>${p.modDescription}</td>
                        <td>
                            <a href ="view?id=${p.modID}">View</a>
                            <a href ="edit?id=${p.modID}">Edit</a>
                            <a href ="delete?id=${p.modID}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
        <a href ="addmodule.jsp"> Add new module</a>
    </body>
</html>
