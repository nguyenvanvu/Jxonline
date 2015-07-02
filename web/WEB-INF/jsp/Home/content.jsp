<%-- 
    Document   : content
    Created on : Jun 23, 2014, 1:42:30 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="warpbody_md">
    <div class="box_play">
        <a class="a_play" href="<%=request.getContextPath()%>/Huong-dan-tai-game-post.htm">
            <img onmouseout="this.src='<%=request.getContextPath()%>/images/a_play.jpg'" onmouseover="this.src='<%=request.getContextPath()%>/images/a_playhover.png'" src="<%=request.getContextPath()%>/images/a_play.jpg">
        </a>
        <div class="boxnt_help">
            <a class="bt_napthe " href="<%=request.getContextPath()%>/tai-khoan.htm"></a><!-- napthe_active-->
            <a class="bt_help " href="<%=request.getContextPath()%>/tai-khoan/nap-the.htm"></a><!--help_active-->
        </div>
        <div style="clear:both"></div>
    </div>
    
<div class="boxwarp_content">
    <div class="boxwarp_top"></div>
    <div class="boxwarp_md"><div class="boxwarp_md_left"><div class="boxwarp_md_right">
        <div class="warpboxcon">
            <!--warpbox_left-->
           <jsp:include page="content-left.jsp"/>
            <!--end warpbox_left-->
            <!--warpbox_right-->
            <jsp:include page="content-right.jsp"/>
            <!--end warpbox_right-->
        </div>
        <span class="bgboxright_top_left"></span>
        <span class="bgboxright_top_right"></span>
        <span class="bgboxright_bt_left"></span>
        <span class="bgboxright_bt_right"></span>
        <div style="clear:both"></div>
    </div></div></div>
    <div class="boxwarp_bt"></div>
</div>
</div>