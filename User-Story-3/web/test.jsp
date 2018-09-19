<%-- 
    Document   : test
    Created on : Sep 19, 2018, 8:22:06 PM
    Author     : glenn
--%>

 <%@ page import="classes.Tools" %>
 <%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Tools dbTools = new Tools(); 
            dbTools.loggInn2(out);
            dbTools.printUsers(out);
            %>
    </body>
</html>
