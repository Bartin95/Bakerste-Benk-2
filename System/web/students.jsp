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
            <a href="dashboard.jsp" class="w3-bar-item w3-button"><i class="fa fa-home"></i> Dashboard</a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-envelope"></i> Messages</a>
            <a href="students.jsp" class="w3-bar-item w3-button"><i class="fa fa-users"> Students</i></a>
            <a href="GetModuleData" class="w3-bar-item w3-button"><i class="fa fa-folder"> Modules</i></a>
            <a href="#" class="w3-bar-item w3-button"><i class="fa fa-sign-out"> Sign out</i></a>
        </div>

        <!-- Page Content -->
        <div class="w3-container w3-content" style="max-width:1280px;margin-top:30px">
            <div class="w3-container w3-white w3-round w3-card">
                <h2>Students in class</h2>

                <sql:setDataSource var="db" driver="${initParam['driverClass']}" url="${initParam['connectionURL']}" user="${initParam['username']}" password="${initParam['password']}" />
                <sql:query var="rs" dataSource="${db}">SELECT * FROM users  ORDER BY users.name ASC</sql:query>

                <table class="w3-table w3-striped w3-bordered">
                    <tr><th>Name</th><th>Email</th><th>Phone</th></tr>
                    <c:forEach items="${rs.rows}" var="user">
                    <tr><td> <a href="profile.jsp"><c:out value="${user.name}"></c:out></a></td><td><c:out value="${user.email}"></c:out></td><td><c:out value="${user.phone}"></c:out></td></tr>
                    </c:forEach>
                </table>
            </div>
        </div>
</body>

</html>
