<%-- 
    Document   : content-register
    Created on : Jun 30, 2014, 2:33:59 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : content-login
    Created on : May 23, 2014, 5:23:43 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="warp_con">
<div class="fade">
<div class="warp_bs">
<div class="warp_bs_box">
     <form:form method="POST" action="${pageContext.request.contextPath}/user/register.htm" commandName = "registerInfo">
                 
                    <div class="box_con_login1">
                        <div class="line_top2">
                            <h3 class="h3_lable">Đăng ký tài khoản</h3>
                            <div class="line_bs1">
                                <label for="username">Tên đăng nhập</label>
                                <div class="box1">
                                    <div onclick="HideandUNhideObj('div1')" onmouseout="HideandUNhideObj('div1')">
                                        <form:input path="cAccName" class="text_id" id="username" name="username" type="text" value=""/>
                                        <form:errors STYLE="color: #ff0000;" path="cAccName"/>
                                        <p STYLE="color: #ff0000;">${errorExistsUserName}</p>
                                    </div>
                                    <div class=" drop4" style=" display:none;" id="div1">
                                        <div class="box_tool_con">
                                            <div class="text_div_con">
                                                <span style="color:red">Thông tin bắt buộc</span><br/>
                                                 Chiều dài từ 6-24 ký tự, có thể sử dụng chữ cái, chữ số.
                                            </div>
                                            <span class="arrow_left"></span>
                                        </div>
                                    </div>
                                </div>
                                    
                            </div>
                            <div class="line_bs1">
                                <label for="email">Địa chỉ Email</label>
                                <div class="box1">
                                    <div onclick="HideandUNhideObj('div2')" onmouseout="HideandUNhideObj('div2')">
                                        <form:input path="cEmail" class="text_id" id="email" name="email" type="text" value=""/>
                                        <form:errors STYLE="color: #ff0000;" path="cEmail"/>  
                                        <p STYLE="color: #ff0000;">${errorExistsEmail}</p>
                                    </div>
                                    <div class=" drop4" style=" display:none;" id="div2">
                                        <div class="box_tool_con">
                                            <div class="text_div_con">
                                                <span style="color:red">Thông tin bắt buộc</span>
                                            </div>
                                            <span class="arrow_left"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="line_bs1">
                                <label for="password">Mât khẩu</label>
                                <div class="box1">
                                    <div onclick="HideandUNhideObj('div3')" onmouseout="HideandUNhideObj('div3')">
                                        <form:input path="cPassWord" class="text_id" id="password" name="password" type="password" value=""/>
                                        <form:errors STYLE="color: #ff0000;" path="cPassWord"/>
                                    </div>
                                    <div class=" drop4" style=" display:none;" id="div3">
                                        <div class="box_tool_con">
                                             <div class="text_div_con">
                                                <span class="span_b">Mức độ mạnh yếu</span>
                                                <div class="div_bg">
                                                    <div style="width:30%;"></div>
                                                </div>
                                                 Sử dụng ít nhất 8 ký tự. Không gõ tiếng Việt có dấu.
                                            </div>
                                            <span class="arrow_left"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="line_bs1">
                                <label for="password_confirm">Xác nhận lại mật khẩu</label>
                                <div class="box1">
                                    <form:input path="ConfirmcPassWord" class="text_id" id="password_confirm" name="password_confirm" type="password" value=""/>
                                    <p STYLE="color: #ff0000;">${errorConfirmcPassWord}</p>
                                </div>
                            </div>
                            <div class="line_bs1">
                                Nhập mã kiểm tra
                                <div class="box1">
                                <div><input autocomplete="off" class="text_id2" id="captcha" maxlength="5" name="captcha" style="width:50px;float:left;" type="input">
                                    <img style="border:1px solid #ccc;" src="${pageContext.request.contextPath}/captcha/image.htm"/></div><br/>
                                    <p STYLE="color: #ff0000;">${errorCaptcha}</p>
                                </div>
                            </div>
                            <div style="clear:both"></div>
                        </div>
                       
                        <div class="line_top" style="border-bottom:none; margin-bottom:20px;">
                            <input type="submit" class="bt_gradent btweb" style="width:90px;" value="Đồng ý"/>
                             <input type="reset" class="bt_gradent btweb" style="width:90px;" value="Nhâp lại"/>
                        </div>
                        <div style="clear:both"></div>
                    </div>
                </form:form>
</div>
<div style="clear:both"></div>
</div>
</div>
</div>

   



