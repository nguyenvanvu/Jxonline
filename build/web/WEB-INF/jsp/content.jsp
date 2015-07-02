<%-- 
    Document   : content
    Created on : May 23, 2014, 5:14:24 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="head_conten">
    <jsp:include page="${page}"/>   
    <jsp:include page="content-footer.jsp"/>  
    
    <script type="text/javascript">function HideandUNhideObj(ThisObj){nav=document.getElementById(ThisObj).style
    if(nav.display=="none"){nav.display='block';}else{nav.display='none';}}
    </script>
   
</div>

