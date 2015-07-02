<%-- 
    Document   : content-right
    Created on : Jun 23, 2014, 1:51:26 AM
    Author     : VuNguyen
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!--warpbox_right-->
            <div class="warpright">
                <div class="boxwarpright">
                    <div class="warpright_left">
                        <div class="divwarpleft">
                            <!--boxtab_news-->
                            <div class="boxtab_news">
                                <div class="bgtab1">
                                    <div class="tab2">
                                        <div class="tab3">
                                            <a class="tab taba active" data-tab="#tab1" href="<%=request.getContextPath()%>/tin-tuc-list.htm">Tin mới</a>
                                            <a class="tab tabb" data-tab="#tab2" href="<%=request.getContextPath()%>/cam-nang-list.htm">Cẩm nang</a>
                                            <a class="more" href="<%=request.getContextPath()%>/tin-tuc-list.htm">Xem thêm</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="boxnews_masite active" id="tab1">
                                    
                                    <c:forEach items="${lstPostTinTuc}" var="posttintuc">
                                        <div class="div_tin1">
					
                                            <a href="<%=request.getContextPath()%>/${posttintuc.getPost_link()}-post.htm">
                                                <c:out value="${posttintuc.getPost_subject()}" escapeXml="false" />
                                            </a>
                                            <span>[<fmt:formatDate pattern="dd-MM"  value="${posttintuc.getPost_time()}" />]</span>
                                            <div style="clear:both"></div>
                                        </div>
                                    </c:forEach>
                                       
                                    
                                </div>
                                <div class="boxnews_masite" id="tab2">
                                     <c:forEach items="${lstPostCamNang}" var="postcamnang">
                                        <div class="div_tin1">
                                            <a href="<%=request.getContextPath()%>/${postcamnang.getPost_link()}-post.htm">
                                                 <c:out value="${postcamnang.getPost_subject()}" escapeXml="false" />
                                            </a>
                                            <span>[<fmt:formatDate pattern="dd-MM"  value="${postcamnang.getPost_time()}" />]</span>
                                            <div style="clear:both"></div>
                                        </div>
                                     </c:forEach>
                                </div>
                            </div>
                            <!--endboxtab_news-->
                            <!--boxtab_su kien-->
                            <div class="boxtab_news">
                                <div class="bgtab2">
                                    <a class="tabsk" href="<%=request.getContextPath()%>/su-kien-list.htm"></a>
                                    <a class="more" href="<%=request.getContextPath()%>/su-kien-list.htm">Xem thêm</a>
                                </div>
                                <div class="boxnews_masite boxnewssk">
                                    <c:forEach items="${lstPostSuKien}" var="postsukien">
                                        <div class="div_tin1 divtin2">
                                            <a href="<%=request.getContextPath()%>/${postsukien.getPost_link()}-post.htm">
                                                <c:out value="${postsukien.getPost_subject()}" escapeXml="false" />
                                            </a>
                                            <span>[<fmt:formatDate pattern="dd-MM"  value="${postsukien.getPost_time()}" />]</span>
                                            <div style="clear:both"></div>
                                        </div>
                                    
                                     </c:forEach>    
                                    
                                </div>
                            </div>
                            <!--endboxtab_su kien-->
                        </div>
                    </div>
                    <div class="warpright_right">
                        <div class="boxwarpright_con">
                            <!--warp_slide -->
                            <div class="warpslide">
                                <div class="boxslide">
                                    <div class="flexslider">
                                        <ul class="slides">
                                            <c:forEach items="${lstSlide}" var="slide">
                                                <li style="width: 100%; float: left; margin-right: -100%; display: none;">
                                                    <a href="<c:out value="${slide.getSlide_link()}"/>" target="_blank">
                                                        <img width="243" height="187" src="/images/slide/<c:out value="${slide.getSlide_img()}"/>">
                                                    </a> 
                                                </li>
                                            </c:forEach>
                                           
                                        </ul>
                                        <ol class="flex-control-nav">
                                           
                                        </ol>
                                        
                                    </div>
                                </div>
                            </div>
                            <!--enfd warp_slide -->
                            <!--box tính năng -->
                            <div class="boxtinhnang">
                                <div class="bgtab1"><div class="tab2"><div class="tab3">
                                    <a class="tabtn" href="<%=request.getContextPath()%>/tinh-nang-list.htm"></a>
                                </div></div></div>
                                <div class="boxnews_masite boxtnmoi">
                                     <c:forEach items="${lstPostTinhNang}" var="posttinhnang">
                                        <div class="div_tin1 div_tin3">
                                            <a href="<%=request.getContextPath()%>/${posttinhnang.getPost_link()}-post.htm">
                                                 <c:out value="${posttinhnang.getPost_subject()}" escapeXml="false" />
                                            </a>
                                            <div style="clear:both"></div>
                                        </div>
                                     </c:forEach>
                                       
                                    
                                </div>
                            </div>
                            <!--end box tính năng -->
                        </div>
                    </div>
                    <div style="clear:both"></div>
                </div>
            </div>
            <!--end warpbox_right-->
