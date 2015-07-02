<%-- 
    Document   : demo
    Created on : Jul 17, 2014, 11:16:12 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${demo}
         <c:forEach items="${lstFileName}" var="filename">
              <br>
             <c:out  value="${filename.getLevel()}" />
             <c:out  value="${filename.getName()}" />
         </c:forEach>
    </body>
</html>
