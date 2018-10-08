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
                <tr><th>Name</th><th>Email</th><th>Phone</th></tr>
                    <c:forEach items="${rs.rows}" var="user">
                    <tr><td class="w3-btn" onclick="document.getElementById('id01').style.display='block'"><c:out value="${user.name}"></c:out></td><td><c:out value="${user.email}"></c:out></td><td><c:out value="${user.phone}"></c:out></td></tr>
                    
                    </c:forEach>
                    <div id="id01" class="w3-panel w3-green w3-display-container" style="display:none">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-display-topright">X</span>
  <p>Click on the X to close this panel.</p>
</div>
        </table>
        
    </div>
</div>
            
<c:import url="footer.jsp" />