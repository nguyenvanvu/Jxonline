<%-- 
    Document   : content-right
    Created on : Jun 25, 2014, 3:00:38 AM
    Author     : VuNguyen
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        
<div class="warpright warprightcon">
    <div class="boxwarpright">
        <div class="boxwarpcon_top"></div>
        <div class="boxwarp_md">
            <div class="boxwarp_md_leftcon">
                <div class="boxwarp_md_rightcon">
                    <div style="width:97%; padding:5px 0;" class="warpboxcon">
                        <div class="box_titel">
                            <h1 class="titel_h1"></h1>
                            <div class="line_titel">
                                <a href="#" >
                                    <span>${type}</span>
                                </a>
                              
                            </div>
                            <div style="clear:both"></div>
                        </div>

                        <div class="boxsubcontent">
                           <div class="page_conten">
                                <div class="p1">
                                    <div class="p2">
                                        <div class="p3">
                                            <div class="box_text_page">

                                                <div id="pagination-demo" class="pagination">
                                                 </div>
                                                <div style="clear:both"></div>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            <div style="clear:both"></div>
                            </div>
                            
                            <div id ="list_conten" class="list_conten">
                               
                            </div>
                        </div>
                        <span class="bgboxright_top_left"></span>
                        <span style="top:-11px; right:-16px;" class="bgboxright_top_right"></span>
                        <div style="clear:both"></div>
                    </div>
            
                </div>
            
            </div>
            <div class="boxwarpcon_bt"></div>
        </div>
    </div>
    <!--end warpbox_right-->
</div>