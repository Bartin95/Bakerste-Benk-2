<%-- 
    Document   : test
    Created on : 16.sep.2018, 14:04:50
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
         <%= session.getAttribute("id") %>
          <%= session.getAttribute("title") %>
           <%= session.getAttribute("moduledescription") %>
    </body>
</html>
