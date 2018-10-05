<%-- 
    Author     : glenn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IS-109/110</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
        <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    </head>
    <body class="w3-theme-l5">
        <!-- Navbar -->

        <div class="w3-bar w3-dark-grey">
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-home"></i> Dashboard</a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i> Messages</a>
            <a href="printUsers" class="w3-bar-item w3-button"><i class="fa fa-users"> Students</i></a>
            <a href="GetModuleData" class="w3-bar-item w3-button"><i class="fa fa-folder"> Modules</i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-sign-out"> Sign out</i></a>
        </div>

        <!-- Page Content -->
        <div class="w3-container w3-content" style="max-width:1280px;margin-top:30px">
            <div class="w3-container w3-white w3-round w3-card">
                <h2>Students in class</h2>

                <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/202" user="root" password="root"/>
                <sql:query var="rs" dataSource="${db}">select * from users</sql:query>

                <table class="w3-table w3-striped w3-bordered">
                    <tr><th>Name</th><th>Email</th><th>Phone</th></tr>
                    <c:forEach items="${rs.rows}" var="user">
                    <tr><td> <c:out value="${user.fname} ${user.lname}"></c:out></td><td><c:out value="${user.cus_email}"></c:out></td><td><c:out value="${user.cus_phone}"></c:out></td></tr>
                    </c:forEach>
                </table>

            </div>
        </div>

    </div>
</body>

</html>
