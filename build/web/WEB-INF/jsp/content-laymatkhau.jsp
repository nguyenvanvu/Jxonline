<%-- 
    Document   : content-laymatkhau
    Created on : Jun 30, 2014, 9:12:04 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="warp_con">
<div class="fade">
<div id="conten_L">
<div class="box_con_l">
<div class="line_ql">
<h2 style="padding-bottom:20px;" class="h2_lable">Đổi mật khẩu</h2>
<div style="clear:both"></div>
</div>
<div class="menu_list" id="firstpane">
<p class="menu_head">
    <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);"  class="img_sms" src="/images/icon_sms_big.png">
    Lấy lại mật khẩu sử dụng Email
</p>
<div style="display: block" class="menu_body">
<div class="box_mk">
<form:form method="POST" action="/tai-khoan/lay-mat-khau.htm"  commandName = "resetpass">
    <div class="box_text_mk">
        <span class="span_text_l">
            Thiết lập mật khẩu mới cho tài khoản của bạn
        </span>
        <div class="box_in">
            <div class="box_in_L">
                <span class="span_text_l l3">Chọn Mật khẩu</span>
            </div>
            <div class="box_in_R">
                <ul id="type">
                    <li>
                        <form:radiobutton path="type" id = "type-0"  value = "1" checked = "true" />
                        <label for="type-0">Mật khẩu 1</label>
                    </li>
                    <li>
                         <form:radiobutton path="type" id = "type-1"  value = "2" />
                        <label for="type-1">Mật khẩu 2</label>
                    </li>
                </ul>
            </div>
        </div>
        <div style="clear:both"></div>
        <div class="box_in">
            <div class="box_in_L">
                <span class="span_text_l l3">Mật khẩu mới</span>
            </div>
            <div class="box_in_R">
                    <form:input path ="Password" type="password" value="" name="password" id="password" class="text_id2" />
                     <form:errors STYLE="color: #ff0000; " path="Password"/>
                     <p STYLE="color: #ff0000;">${errorTrungMatKhau}</p>
            </div>
        </div>
        <div style="clear:both"></div>
        <div class="box_in">
            <div class="box_in_L">
                <span class="span_text_l l3">Xác nhận lại mật khẩu</span>
            </div>
            <div class="box_in_R">
                    <form:input path ="Password_confirm" type="password" value="" name="password_confirm" id="password_confirm" class="text_id2"/>
            </div>
        </div>
        <div style="clear:both"></div>
        <div class="box_in">
            <div class="box_in_L">
                <span class="span_text_l l3">Nhập mã kiểm tra</span>
            </div>
            <div class="box_in_R">
                <div>
                    <form:input path="captcha" type="input" style="width:50px;float:left;" name="captcha" maxlength="5" id="captcha" class="text_id2" autocomplete="off"/>
                    <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);"  src="<%=request.getContextPath()%>/captcha/image.htm" style="border:1px solid #ccc;">
                </div>
                <br>
            </div>
        </div>
        <div style="clear:both"></div>
        <div class="box_in">
            <div class="box_in_L">
                <br>
            </div>
            <div class="box_in_R">
                <input type="submit" value="Gửi" style="width:90px;" class="bt_gradent btweb">
                <input type="reset" value="Nhâp lại" style="width:90px;" class="bt_gradent btweb">
            </div>
        </div>
        <div style="clear:both"></div>
    </div>
</form:form>
<div class="arrow_top"></div>
</div>
</div>
</div>
</div>
</div>
<div style="clear:both"></div>
</div>
</div>