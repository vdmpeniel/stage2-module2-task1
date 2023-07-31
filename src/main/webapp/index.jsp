<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <%-- This way it also works
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <button class="w3-btn w3-green w3-round-large" onclick="location.href='${contextPath}/add'">Add User</button>
        <button class="w3-btn w3-light-blue w3-round-large" onclick="location.href='${contextPath}/users'">Users</button>
        --%>

        <button class="w3-btn w3-green w3-round-large" onclick="location.href='<c:url value="/add" />'">Add User</button>
        <button class="w3-btn w3-light-blue w3-round-large" onclick="location.href='<c:url value="/users" />'">Users</button>

    </div>
</div>
</body>
</html>