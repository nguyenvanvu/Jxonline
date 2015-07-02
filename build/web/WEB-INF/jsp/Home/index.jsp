<%-- 
    Document   : index
    Created on : Jun 2, 2014, 12:09:25 PM
    Author     : VuNguyen
--%>

<%@page contentType="text/html " pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
        <meta name="google-site-verification" content="BaDthnmIadL5DwcJfmKtIKeJVR1dcGt4u2wFBdzrFGM" />
        <title>Võ Lâm Huyết Sử</title>
        <link href="<%=request.getContextPath()%>/images/favicon.ico" type="image/ico" rel="icon">
        
        
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/A.style_main.css,qr=3.pagespeed.cf.pzBsadJWR4.css">
        <!--
        <style>.flex-container a:active,.flexslider a:active{outline:none}.slides,.flex-control-nav,.flex-direction-nav{margin:0;padding:0;list-style:none}.flexslider{width:243px;margin:0px 0 0 4px;padding:0px 0 0 0;height:187px;overflow:hidden}.flexslider .slides>li{display:none}.flexslider .slides img{width:243px;height:187px;display:block}.flex-pauseplay span{text-transform:capitalize}.slides:after{content:".";display:block;clear:both;visibility:hidden;line-height:0;height:0}html[xmlns] .slides{display:block}* html .slides{height:1%}.no-js .slides>li:first-child{display:block}.flexslider{position:relative;padding:1px 0px 0px 1px}.flexslider .slides{}.flexslider .slides>li{position:relative}.flex-container{zoom:1;position:relative}.flex-control-nav{width:100%;position:absolute;bottom:5px;text-align:right;right:10px}.flex-control-nav li{margin:0 0 0 5px;display:inline-block;zoom:1;*display: inline}.flex-control-nav li:first-child{margin:0}.flex-control-nav li a{width:16px;height:16px;display:block;background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -58px;cursor:pointer;text-indent:0px;position:relative;text-align:center;color:#fff;font-size:11px;font-weight:bold;line-height:16px}.flex-control-nav li a:hover,.flex-control-nav li a.active{background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -36px}.warp_laucher .flexslider{margin:0px 0 0 0px}</style>
        -->
        <style>.flex-container a:active,.flexslider a:active{outline:none}.slides,.flex-control-nav,.flex-direction-nav{margin:0;padding:0;list-style:none}.flexslider{width:243px;margin:0px 0 0 4px;padding:0px 0 0 0;height:187px;overflow:hidden}.flexslider .slides>li{display:none}.flexslider .slides img{width:243px;height:187px;display:block}.flex-pauseplay span{text-transform:capitalize}.slides:after{content:".";display:block;clear:both;visibility:hidden;line-height:0;height:0}html[xmlns] .slides{display:block}* html .slides{height:1%}.no-js .slides>li:first-child{display:block}.flexslider{position:relative;padding:1px 0px 0px 1px}.flexslider .slides{}.flexslider .slides>li{position:relative}.flex-container{zoom:1;position:relative}.flex-control-nav{width:100%;position:absolute;bottom:5px;text-align:right;right:10px}.flex-control-nav li{margin:0 0 0 5px;display:inline-block;zoom:1;*display: inline}.flex-control-nav li:first-child{margin:0}.flex-control-nav li a{width:16px;height:16px;display:block;background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -58px;cursor:pointer;text-indent:0px;position:relative;text-align:center;color:#fff;font-size:11px;font-weight:bold;line-height:16px}.flex-control-nav li a:hover,.flex-control-nav li a.active{background:url(http://static1.hoiucmotthoi.com/static/images/images/iconweb.png.pagespeed.ce.WMxVbwLIVZ.png) no-repeat -2px -36px}.warp_laucher .flexslider{margin:0px 0 0 0px}</style>
        <link href="<%=request.getContextPath()%>/css/A.style_menu.css,qr=3.pagespeed.cf.tTV-E9F-w9.css" type="text/css" rel="stylesheet">
     
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js.pagespeed.jm.hJPIhFzu5k.js"></script>
        <script charset="utf-8" type="text/javascript">
            $(document).ready(function(){
                $("#nav li").hover(function(){
                    $(this).find('ul:first').css({visibility:"visible",display:"none"}).show(400);
                },function(){
                    $(this).find('ul:first').css({visibility:"hidden"});});});
         </script>
        <script src="<%=request.getContextPath()%>/js/jquery.flexslider-min.js.pagespeed.jm.J0Amlx6KVj.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.fancybox.js,qv=2.1.5.3.pagespeed.jm.vHnh4V6z-m.js"></script>
        <link media="screen" href="<%=request.getContextPath()%>/css/A.jquery.fancybox.css,qv=2.1.5.pagespeed.cf.Ss3oHODHFS.css" type="text/css" rel="stylesheet">
        <script>
            $(document).ready(function(){
                $('a.tab').click(function(e){
                    e.preventDefault();
                    $('a.tab').removeClass('active');
                    $(this).addClass('active');
                    $('div.boxnews_masite').removeClass('active');
                    tab=$(this).data('tab');
                    $(tab).addClass('active');})});
        </script>
        <script type="text/javascript">
            $(window).load(function(){
                $('.flexslider').flexslider();});
         </script>
        <style type="text/css">
            .fancybox-margin{margin-right:17px;}
        </style>
        
    </head>
    <body id ="bodymainsite">
     <jsp:include page="header.jsp"/>  
      <jsp:include page="content.jsp"/>  
       <jsp:include page="footer.jsp"/>  
    </body>
</html>
