<%-- 
    Document   : content-login
    Created on : Jun 3, 2014, 10:59:47 PM
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
    <h2 class="h2_lable">Tài khoản <span class="doc">|</span> <span class="texttran"> Account</span></h2>
    <div class="div_line1">
    <a href="#">Trang chủ</a>
        <span>&gt;</span><span>Tài khoản</span>
    </div>
    <div style="clear:both"></div>
</div>
 ${warring}   
<div class="box_banner">

    <div style="clear:both"></div>
    <div class="boxtext_dkn">
        <h2 class="h2_lable h3">Tài khoản game</h2>
        <span class="span_text_l l2">
            Với tài khoản này, người dùng có thể sử dụng để chơi và nạp tiền đồng cho Game.
        </span>
        <h2 class="h2_lable h3">Đăng ký nhanh</h2>
        <span class="span_text_l l2">
        Chỉ cần vài bước đơn giản là bạn có ngay một tài khoản Game.
        </span>
        <h2 class="h2_lable h3">Dễ sử dụng và an toàn</h2>
        <span class="span_text_l l2">
            Dễ dàng trong việc quản lý tài khoản và tuyệt đối an toàn.<br><br>
            Đăng nhập ở bên phải hoặc 
            <a style="font-weight:normal" class="a_dk" href="/tai-khoan.htm">tạo tài khoản miễn phí.</a>
        </span>
    </div>
</div>
</div>
</div>
<div id="conten_R">
    <div class="box_login">
    <div class="box_con_login">
    <div class="line_top">
        <a class="btdkn" href="/tai-khoan.htm">Đăng ký tài khoản</a>
    </div>
<div class="line_top">
    <span class="lable_name">Sử dụng tài khoản để tham gia</span>
    <form:form action="/tai-khoan/dang-nhap.htm" method="POST" commandName = "logininfo">
        <div class="box_input">
            <div class="input_text">
                <p STYLE="color: #ff0000;">${errorLogin}</p>
                <div class="bg_inputtext">
                    <form:input path="cAccName" type="text" value="" placeholder="Tài khoản" name="email" id="email" class="text_tk" />
                </div>
                <div style="margin-bottom:0px;" class="bg_inputtext">
                    <form:input path="cPassWord" type="password" value="" placeholder="Mật Khẩu" name="password" id="password" class="text_tk"/>
                </div>
            </div>
            <div class="input_bt">
                <a class="bt_dn" type="button" href="#"> <span>Đăng nhập</span>
                    <input type="submit" class="inputdn" value="">
                </a>
            </div>
        </div>
        <input type="checkbox" value="y" name="remember" id="remember" class="che"> <span class="span_ch">Ghi nhớ đăng nhập</span>
    </form:form>
    <div style="clear:both"></div>
    <div class="div_ta">
        <a class="a_qmk" href="/tai-khoan/quen-mat-khau.htm">Quên mật khẩu?</a>
    </div>
</div>
</div>
</div>
<div style="clear: both"></div>
</div>
<div style="clear:both"></div>
</div>
</div>
