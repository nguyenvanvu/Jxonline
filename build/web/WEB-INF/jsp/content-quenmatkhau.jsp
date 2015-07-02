<%-- 
    Document   : content-quenmatkhau
    Created on : Jun 30, 2014, 6:48:05 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="warp_con">
<div class="fade">
<div id="conten_L">
<div class="box_con_l">
<div class="line_ql">
<h2 style="padding-bottom:20px;" class="h2_lable">Quên mật khẩu</h2>
<div style="clear:both"></div>
</div>
    ${thongtin}
<div class="menu_list" id="firstpane">
<p class="menu_head">
    <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);" class="img_sms" src="${pageContext.request.contextPath}/images/icon_sms_big.png">Lấy lại mật khẩu sử dụng Email</p>
<div style="display: block" class="menu_body">
<div class="box_mk">
<form name="forgot_password_form" method="POST" action="/user/gui-mail.htm">
  
    <div class="box_text_mk">
    <span class="span_text_l">
    Vui lòng nhập email của bạn, mã xác nhận sẽ được gửi vào email bạn đã đăng ký:
    </span>
    <div class="box_in">
    <div class="box_in_L">
    <span class="span_text_l l3">Địa chỉ email</span>
    </div>
    <div class="box_in_R">
    <input type="text" value="" name="email" id="email" class="text_id2">
    </div>
    </div>
    <div style="clear:both"></div>
    <div class="box_in">
    <div class="box_in_L">
    <span class="span_text_l l3">Nhập mã kiểm tra</span>
    </div>
    <div class="box_in_R">
    <div><input type="input" style="width:50px;float:left;" name="captcha" maxlength="5" id="captcha" class="text_id2" autocomplete="off">
        <img   src="${pageContext.request.contextPath}/captcha/image.htm" style="border:1px solid #ccc;"></div><br>
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
</form>
<div class="arrow_top"></div>
</div>
</div>
</div>
</div>
</div>
<div style="clear:both"></div>
</div>
</div>

