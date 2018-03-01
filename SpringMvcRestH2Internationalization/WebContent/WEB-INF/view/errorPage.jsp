<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" isErrorPage="true"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>

<h2> Error Occurred! </h2>
<c:choose>
<c:when test="${empty errorMessage}">
<%= exception %>
</c:when>
<c:otherwise>
<h4>${errorMessage}</h4>
<h4>${errorcode}</h4>
</c:otherwise>
</c:choose>
<a href="#">Home Page</a>
</body>
</html>