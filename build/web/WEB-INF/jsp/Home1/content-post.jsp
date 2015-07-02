<%-- 
    Document   : content-post
    Created on : Oct 28, 2014, 4:31:35 PM
    Author     : vunguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="line_contentext">
                        <!--<h1 class="contenh1">Liên Đấu</h1>-->
                        <span> <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss "  value="${post.getPost_time()}" /> </span>
                 </div>
                    
                    <!-- text_conten-->
                     <div class = "box_textcon">
                         ${post.getPost_text()}  
                     </div>
