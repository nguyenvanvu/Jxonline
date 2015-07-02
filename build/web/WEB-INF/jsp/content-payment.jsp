<%-- 
    Document   : payment
    Created on : Aug 26, 2014, 12:56:23 PM
    Author     : vunguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
    document.getElementById("tabpayment").className += "cur";
    document.getElementById("tabaccount").className -= "cur";
</script>
<div id="warp_con">
    <div class="fade">
        <div id="conten_L">
            <div class="box_con_l">
                <div class="line_ql">
                    <h2 class="h2_lable">
                        Nạp tiền 
                        <span class="doc">|</span> 
                        <span class="texttran"> Payment</span>
                    </h2>
                    <div class="div_line1">
                        <a href="#">Trang chủ</a><span>&gt;</span><span>Nạp tiền</span>
                    </div>
                    <div style="clear:both"></div>
                </div>
                <div class=" box_banner boxtab_game">
                    <div class="boxlistgame news">
                        <div style="display:block" id="1">
                            <div class="boxlistcongame">
                                <div style="clear:both"></div>
                                <h1 id="tigia">TỈ GIÁ: 1.000 VND = 10 &lt;Tiền đồng&gt;</h1>
                                <h2 style="text-align: center;"><a target="_blank" href="http://hoiucmotthoi.com/cam-nang/huong-dan-nap-the" style="color: red !important;">Hướng dẫn nạp thẻ</a></h2>
                                <div class="box_doiss">
                                    <form name="payment" method="post" action="/nap-the">
                                        
                                        <div style="border-bottom:none; margin-top:0px;" class="line_bs">
                                        <div class="box_line_bs ma">
                                        <div class="line_box_L">
                                        <span class="span_textss ali">Mã bí mật trên thẻ</span>
                                        </div>
                                        <div class="line_box_R">
                                        <input type="text" value="" name="number" id="number" class="text_id2">
                                        <span class="ali">(Chỉ gồm các chữ số 0-9)</span>
                                        </div>
                                        </div>
                                        <div style="clear:both"></div>
                                        <div class="box_line_bs ma">
                                        <div class="line_box_L">
                                        <span class="span_textss ali">Số thẻ (Sê ri)</span>
                                        </div>
                                        <div class="line_box_R">
                                        <input type="text" value="" name="serial" id="serial" class="text_id2">
                                        </div>
                                        </div>
                                        <div style="clear:both"></div>
                                        <div class="box_line_bs ma">
                                        <div class="line_box_L">
                                        <span class="span_textss ali"></span>
                                        </div>
                                        <div class="line_box_R">
                                            <div class="pm_box">
                                                <div class="div_boxcheck codiv wi">
                                                    <label for="vina_1">
                                                        <input type="radio" value="VINA" name="provider" class="radio_ch via" id="vina_1">
                                                        <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);"  src="<%=request.getContextPath()%>/images/icon_vina.png">
                                                    </label>
                                                </div>
                                                <div class="div_boxcheck codiv wi">
                                                    <label for="mobi_1">
                                                        <input type="radio" value="MOBI" name="provider" class="radio_ch via" id="mobi_1"> 
                                                        <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);" src="/images/icon_mobi.png">
                                                    </label>
                                                </div>
                                                <div class="div_boxcheck codiv wi disble">
                                                    <label for="vt_1">
                                                        <input type="radio" value="VT" name="provider" class="radio_ch via" id="vt_1"> 
                                                        <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);"  src="/images/icon_vt.png">
                                                    </label>
                                                </div>
                                            </div>

                                            <div style="clear:both"></div>
                                        </div>
                                        </div>
                                        <div style="clear:both"></div>
                                        <div class="box_line_bs ma">
                                        <div class="line_box_L">
                                        <span class="span_textss ali">Nhập mã kiểm tra</span>
                                        </div>
                                        <div class="line_box_R">
                                            <div>
                                                <input type="input" style="width:50px;float:left;" name="captcha" maxlength="5" id="captcha" class="text_id2" autocomplete="off">
                                                <img onload="pagespeed.CriticalImages.checkImageForCriticality(this);"  src="/captcha/image.htm" style="border:1px solid #ccc;">
                                            </div>
                                            <br>
                                        </div>
                                        </div>
                                        <div style="clear:both"></div>
                                        <div style="padding-bottom:25px; padding-top:5px;" class="box_line_bs ma">
                                        <div class="line_box_L"><br> </div>
                                        <div class="line_box_R">
                                        <input type="submit" value="Đồng ý" style="width:90px; z-index: 40;" class="bt_gradent btweb" disabled>
                                        <input type="reset" value="Nhập lại" style="width:90px; z-index: 40;" class="bt_gradent btweb">
                                        <br>
                                        <span>Chưa có chức năng nạp car</span>
                                        </div>
                                        </div>
                                        <div style="clear:both"></div>
                                        </div>
                                    </form>
                                </div>
                                <div style="clear:both"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="conten_R">
            <div class="box_login">
                <div class="box_con_r">
                    <h3 class="doiss">Tài khoản</h3>
                    <div class="div_text_hd">
                        <div class="line_box">
                        <span>Chào</span><a href="/tai-khoan/thong-tin-tai-khoan.htm"><b><%= session.getAttribute("cAccName") %></b></a><span>|</span><a href="/tai-khoan/dang-xuat.htm">Thoát</a>
                        </div>
                    </div>
                </div>
            </div>
            <div style="clear: both"></div>
       
        </div>
        </div>
        <div style="clear:both"></div>
    </div>
</div>