<%-- 
    Document   : modules
    Created on : 18.sep.2018, 10:46:34
    Author     : anett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modules</title>
    </head>
    <body>
         <header>                
            <nav>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="modules.jsp">Modules</a></li>
                    <li><a href="resouce.jsp">Resources</a></li>
                    <li><a href="message.jsp">Messages</a></li>
                    <li><a href="info.jsp">Information</a></li>
                    <li><a href="progress.jsp">Progress</a></li>
                </ul>
            </nav>
        </header>
        
        <h1>This is the modules page</h1>
        <h2>Here we will have a list of all the modules</h2>
        <h2>Create new module-button and edit module button</h2>
        
       
           
        
        
         <form action="create.html">
            <input type = "submit" value = "Create new module "/>
        </form>
        
        <form action="edit.html">
            <input type = "submit" value = "Edit module "/>
        </form>
    </body>
</html>
