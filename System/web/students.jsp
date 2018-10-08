<%-- 
    Author     : glenn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<c:import url="header.jsp" />

<!-- Page Content -->
<div class="w3-container w3-content" style="max-width:1280px;margin-top:30px">
    <div class="w3-container w3-white w3-round w3-card">
        <h2>Students in class</h2>

        <sql:setDataSource var="db" driver="${initParam['driverClass']}" url="${initParam['connectionURL']}" user="${initParam['username']}" password="${initParam['password']}" />
        <sql:query var="rs" dataSource="${db}">SELECT * FROM users ORDER BY users.name ASC</sql:query>

            <table class="w3-table w3-striped w3-bordered">
                <tbody style="cursor:pointer">
                <tr><th>Name</th><th>Email</th><th>Phone</th></tr>
                    <c:forEach items="${rs.rows}" var="user">
                    <tr><td><c:out value="${user.name}"></c:out></td><td><c:out value="${user.email}"></c:out></td><td><c:out value="${user.phone}"></c:out></td></tr>
                    
                    </c:forEach>
                </tbody>
        </table>
        
        
    </div>
</div>

            
<c:import url="footer.jsp" />