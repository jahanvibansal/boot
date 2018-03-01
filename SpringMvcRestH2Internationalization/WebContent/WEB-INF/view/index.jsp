<%@page errorPage="./errorPage.jsp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix= "spring"%>
<html>
<body>

<a href="./index?language=en">English</a>
<a href="./index?language=fr">French</a>
<a href="./index?language=zh">Chinese</a>
<h2><spring:message code="label.greeting"></spring:message></h2>
<spring:message code="label.name"></spring:message>:  <input type="text" name="username">
</body>
</html>
