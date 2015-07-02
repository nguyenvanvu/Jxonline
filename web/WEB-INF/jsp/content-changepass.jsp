<%-- 
    Document   : changepass
    Created on : Jun 30, 2014, 2:44:07 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="warp_con">
<div class="fade">
<div class="line_ql martop">
<div class="line_ql_L">
<h2 class="h2_lable">Tài khoản <span class="doc">|</span> <span class="texttran"> Account</span></h2>
<div class="div_line1">
<a href="#">Trang chủ</a><span>&gt;</span><span>Tài khoản</span><span>&gt;</span><span>Quản lý tài khoản</span><span>&gt;</span><span>Đổi mật khẩu</span>
</div>
</div>

<div class="line_ql_R">
<div class="divql_R">
<div class="div_line_rt">
<span>Chào </span><font>${cAccName}</font><span>|</span>
<a href="<%=request.getContextPath()%>/tai-khoan/dang-xuat.htm">Thoát</a>
</div>
</div>
</div>
<div style="clear:both"></div>
</div>
<div style="clear:both"></div>
<div class="warp_bs">
<div class="warp_bs_box">
<div class="line_bs">
<div class="line_top_mk">
<h2 class="h2_lable h3 w">Đổi mật khẩu </h2>
</div>
<div style="clear:both"></div>
<form:form action="/tai-khoan/doi-mat-khau.htm" method="POST" commandName= "changepass" >
    
    <div style="clear:both"></div>
    <ul style="margin-left: 200px" id="type">
        <c:choose>
            <c:when test="${type == 1}">
                     <li>
                        <form:radiobutton path="type" id = "type-0"  value = "1" checked = "true" />
                        <label for="type-0">Mật khẩu 1</label>
                    </li>
                    <li>
                         <form:radiobutton path="type" id = "type-1"  value = "2" />
                        <label for="type-1">Mật khẩu 2</label>
                    </li>
            </c:when>
            <c:otherwise>
                <li>
                        <form:radiobutton path="type" id = "type-0"  value = "1"  />
                        <label for="type-0">Mật khẩu 1</label>
                    </li>
                    <li>
                         <form:radiobutton path="type" id = "type-1"  value = "2" checked = "true" />
                        <label for="type-1">Mật khẩu 2</label>
                    </li>
            </c:otherwise>        
        </c:choose>
       
                    
     </ul>
    <div class="box_line_bs ma">
        <div class="bs_l">
        <span>Mật khẩu 2 </span>
        </div>
        <div class="bs_md">
            <form:input path="cSecPassWord" class="text_id2" id="password" name="password" type="password" value=""/>
            
             <p STYLE="color: #ff0000;">${errorPass2}</p>
        </div>
    </div>
    <div style="clear:both"></div>
    <div class="box_line_bs ma">
        <div class="bs_l">
            <span>Mật khẩu mới</span>
        </div>
        <div class="bs_md">
            <form:input path="cNewPassWord" class="text_id2" id="new_password" name="new_password" type="password" value=""/>
            
            <form:errors STYLE="color: #ff0000;" path="cNewPassWord"/>
            <p STYLE="color: #ff0000;">${errorConfirmcPassWord}</p>
        </div>
    </div>
    <div style="clear:both"></div>
    <div class="box_line_bs ma">
        <div class="bs_l">
        <span>Xác nhận mật khẩu mới</span>
        </div>
        <div class="bs_md">
            <form:input path="ConfirmcNewPassWord" class="text_id2" id="new_password_confirm" name="new_password_confirm" type="password" value=""/>
            <p STYLE="color: #ff0000;">${errorConfirmcPassWord}</p>
           
        </div>
    </div>
    <div style="clear:both"></div>
        <div class="box_line_bs ma">
            <div class="bs_l">
                <span>Nhập mã kiểm tra</span>
            </div>
            <div class="bs_md">
                <div>
                    <form:input path="captcha" class="text_id2"  maxlength="5" name="captcha" style="width:50px;float:left;" type="input"/>
                    <img style="border:1px solid #ccc;" src="${pageContext.request.contextPath}/captcha/image.htm"  />
                    <form:errors STYLE="color: #ff0000;" path="captcha"/>
                     <p STYLE="color: #ff0000;">${errorCapcha}</p>
                </div>
                <br>
            </div>
        </div>
    <div style="clear:both"></div>
    <div class="box_line_bs" style="padding-bottom:20px;">
        <div class="bs_l"><br></div>
        <div class="bs_md">
            <input type="submit" class="bt_gradent btweb" style="width:90px;" value="Đồng ý">
            <input type="resert" class="bt_gradent btweb" style="width:90px;" value="Nhâp lại">
        </div>
    </div>
    <div style="clear:both"></div>
</form:form>
</div>
</div>
<div style="clear:both"></div>
</div>
</div>
</div>