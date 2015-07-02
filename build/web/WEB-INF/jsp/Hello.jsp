<%-- 
    Document   : Hello
    Created on : Apr 30, 2014, 2:21:58 AM
    Author     : VuNguyen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
    </head>
    <body>
        <table>
            <script type="text/javascript">
                var hello = "dasdsad";
            </script>
        <c:forEach items="${lstUser}" var="user">
          <tr>
            <td><c:out value="${user.cAccName}" /></td>
            
          </tr>
        </c:forEach>
          
            
          
</table>
        ${id}
        
    </body>
</html>
