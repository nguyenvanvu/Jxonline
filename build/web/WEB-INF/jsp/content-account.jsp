<%-- 
    Document   : content-account
    Created on : Jun 2, 2014, 1:36:02 AM
    Author     : VuNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
function emailActive(){
        $('#xacnhanemail').html(" <img align=\"center\"   src=\"<%=request.getContextPath()%>/images/ajax-loader.gif\">");
        $('#resultemailActive').html("");
        $.ajax({
		type: "get",
		url: "<%=request.getContextPath()%>/tai-khoan/kich-hoat-email.htm",
		cache: true,		
                data: {},
		success: function(response){
			
			if (response == "true") {
               
                            var str = "<ul class=\"flashes\"><li class\"message\">Đã gửi mã xác nhận email, vui lòng kiểm tra mail để xác nhận thông tin!</li></ul>";
                            $('#resultemailActive').html(str);
                        }
                        else if(response == "error"){
                            var str = "<ul class=\"flashes\"><li class\"message\">Lỗi gửi mã xác nhận!</li></ul>";
                            $('#resultemailActive').html(str);
                        }
                        else {
                         var str = "<ul class=\"flashes\"><li class\"message\">Đã gửi mã xác nhận email, vui lòng kiểm tra mail để xác nhận thông tin!</li></ul>";
                         $('#resultemailActive').html(str);       
                        }
                         $('#xacnhanemail').html(" <a  href=\"javascript:emailActive()\"><img align=\"left\"   src=\"<%=request.getContextPath()%>/images/icon_clock_date.png\"><span>Gửi mã xác thực</span></a>");

			
		},
		error: function(){						
			alert('Error while request..');
		}
	});
}
</script>
<div id="warp_con">
    <div class="fade">
        <div class="line_ql martop">
            <div class="line_ql_L">
                <h2 class="h2_lable">Tài khoản <span class="doc">|</span> <span class="texttran"> Account</span></h2>
                <div class="div_line1">
                    <a href="#">Trang chủ</a><span>&gt;</span><span>Tài khoản</span><span>&gt;</span><span>Quản lý tài khoản</span><span>&gt;</span><span>Cập nhật thông tin tài khoản</span>
                </div>
            </div>
            <div class="line_ql_R">
                <div class="divql_R">
                    <div class="div_line_rt">
                        <span>Chào</span><font>${cAccName}</font><span>|</span>
                        <a href="/tai-khoan/dang-xuat.htm">Thoát</a>
                    </div>
                </div>
            </div>
            <div style="clear:both"></div>
        </div>   
        ${thanhcong}
        <div style="clear:both"></div>
        <span style="margin-bottom:5px;" class="span_text_l">
            Để xác nhận quyền sở hữu tài khoản này và sử dụng các dịch vụ thanh toán, bạn vui lòng nhập đầy đủ các thông tin sau:
        </span>
        <div class="warp_bs">
            <div class="warp_bs_box">
                <div id="resultemailActive">

                </div>
 
                <div class="line_bs">
                <div class="line_top_mk">
                    <h2 class="h2_lable h3 w " >Thông tin tài khoản</h2>
                </div>
                <div style="clear:both"></div>
                <div class="box_line_bs ma1">
                    <div class="bs_l">
                        <span>Tên đăng nhập</span>
                    </div>
                    <div class="bs_md">
                         <font>${cAccName}</font>
                    </div>
                </div>
                     <div style ="margin-left: 425px" class="box_line_bs ma1">
                    
                    <div style="width:40%; " class="bs_l2">
                        <div style=" display:block;width:110px;" class="box_ten">
                            <a target ="_blank" href="<%=request.getContextPath()%>/tai-khoan/kich-acc.htm">
                                <img align="left" class="img_cicl" src="<%=request.getContextPath()%>/images/btn_icon_clock.png">
                                <span class="span_text_bs"> Kich acc</span>
                            </a>
                            <span class="arrow_l"></span>
                        </div>
                    </div>
                </div>
                <div class="box_line_bs ma1">
                    <div class="bs_l">
                        <span>Mật khẩu 1</span>
                    </div>
                    <div class="bs_l2">
                        <font>*********</font>
                    </div>
                    <div style="width:40%;" class="bs_l2">
                        <div style=" display:block;width:110px;" class="box_ten">
                            <a href="<%=request.getContextPath()%>/tai-khoan/doi-mat-khau.htm?type=1">
                                <img align="left" class="img_cicl" src="<%=request.getContextPath()%>/images/btn_icon_clock.png">
                                <span class="span_text_bs"> Đổi mật khẩu 1</span>
                            </a>
                            <span class="arrow_l"></span>
                        </div>
                    </div>
                </div>
                <div class="box_line_bs ma1">
                    <div class="bs_l">
                        <span>Mật khẩu 2</span>
                    </div>
                    <div class="bs_l2">
                        <font>*********</font>
                    </div>
<div style="width:40%;" class="bs_l2">
<div style=" display:block;width:110px;" class="box_ten">
    
            <a href="<%=request.getContextPath()%>/tai-khoan/doi-mat-khau.htm?type=2">
                <img align="left" class="img_cicl" src="<%=request.getContextPath()%>/images/btn_icon_clock.png">
                <span class="span_text_bs"> Đổi mật khẩu 2</span>
            </a>
     
<span class="arrow_l"></span>
</div>
    <c:choose>
        <c:when test = "${user.getcPassWord() == user.getcSecPassWord()}">
            <p>(Mặc định giống mật khẩu 1)</p>
        </c:when>
    </c:choose>
</div>
</div>
</div>

<div class="line_bs ">
<h2 style="float:left;" class="h2_lable h3">Thông tin chứng thực </h2><span class="te2">(Dùng để xác nhận việc sở hữu tài khoản)</span>
<div style="clear:both"></div>
<div class="box_line_bs ma1">
<div class="bs_l">
<span>Email đăng ký </span>
</div>
<div class="bs_l2">
<span>${user.getcEmail()}</span>
</div>

<div style="width:40%;" class="bs_l2">
    <c:choose>
        <c:when test="${user.getEmailactive() == 1}">
            <div class="box_ten">
                <a>
                    <img align="left" class="img_cicl" src="<%=request.getContextPath()%>/images/bt_daxt_icon.png">
                    <span class="span_text_bs co_g"> Đã xác thực</span>
                </a>
                <span class="arrow_l"></span>
            </div>
            <div style=" display:block;width:120px;" class="dropdown">
                <a><img align="left" src="<%=request.getContextPath()%>/images/icon_clock_date.png"><span>Thay đổi</span></a>
            </div>

            
        </c:when>
        <c:otherwise>
                <div class="box_ten">
                    <a>
                        <img align="left"  src="<%=request.getContextPath()%>/images/bt_xacthuc_icon.png">
                        <span class="span_text_bs co_g"> Chưa xác thực</span>
                    </a>
                    <span class="arrow_l"></span>
                </div>
                <div style=" display:block;width:120px;" class="dropdown">
                    <div id ="xacnhanemail">
                         <a  href="javascript:emailActive()">
                        <img align="left"   src="<%=request.getContextPath()%>/images/icon_clock_date.png">
                        <span>Gửi mã xác thực</span>
                        </a>
                    </div>
                   
                </div>
        </c:otherwise>
    </c:choose>
</div>

</div>
</div>
<div style="clear:both"></div>
</div>
<div style="border-bottom:none;" class="line_bs" id = "accountinfo">
<form:form   method="POST" action="${pageContext.request.contextPath}/tai-khoan/sua-thong-tin.htm#accountinfo"  commandName = "personinfo" >
    <div style="display:none;"></div>
    <div class="line_top_mk" style="margin-left: 20px">
        <h2 class="h2_lable h3 w">Thông tin tài khoản</h2>
    </div>
    <div style="clear:both"></div>
    <div class="box_line_bs ma1">
        <div class="bs_l">
            <span class=" span_l">Họ tên</span>
        </div>
        <div class="bs_md">
            <form:input path="cRealName" type="text" value="${user.getcRealName()}" name="fullname" id="fullname" class="text_id2"/>
            <form:errors STYLE="color: #ff0000;" path="cRealName"/>
        </div>
    </div>
    <div style="clear:both"></div>
    <div class="box_line_bs ma">
        <div class="bs_l">
        <span class=" span_l">Giới tính </span>
        </div>
        <div class="bs_md">
            <c:choose>
                <c:when test = "${user.getCSex() == 1}">
                     <form:select path= "CSex" class="text_id2">
                        <option value="1" selected>Nam</option>
                        <option value="0" >Nữ</option>
                    </form:select>
                </c:when>
                <c:otherwise>
                    <form:select path= "CSex" class="text_id2">
                        <option value="1">Nam</option>
                        <option value="0" selected>Nữ</option>
                    </form:select>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <div style="clear:both"></div>
    <div class="box_line_bs ma">
        <div class="bs_l">
            <span class=" span_l">Ngày sinh </span>
        </div>
        <div class="bs_md">
            
            <form:input path="dBirthDay" type="text" value="${birthday}" name="dob" id="dob" class="text_id2" />
             
        </div>
    </div>
    <div class="box_line_bs ma">
        <div class="bs_l">
            <span class=" span_l">Số điện thoại </span>
        </div>
        <div class="bs_md">
            <form:input path="cPhone" type="text" value="${user.getcPhone()}" name="phone" id="phone" class="text_id2"/>
            <form:errors STYLE="color: #ff0000;" path="cPhone"/>
        </div>
    </div>
    <div style="clear:both"></div>
    <div style="padding-bottom:25px;" class="box_line_bs ma">
        <div class="bs_l"><br></div>
        <div class="bs_md">
            <input type="submit" value="Đồng ý" style="width:90px;" class="bt_gradent btweb">
            <input type="reset" value="Nhâp lại" style="width:90px;" class="bt_gradent btweb">
        </div>
    </div>
</form:form>
</div>
</div>
<div style="clear:both"></div>
</div>
</div>
</div>
