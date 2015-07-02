<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Võ Lâm Kỳ Hiệp</title>
<link href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,500,500italic' rel='stylesheet' type='text/css'>
<link href="<%=request.getContextPath()%>/css/pure-nr-min.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/style_main.css?v=12" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/css/jselect/jselect-theme.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/css/style_popup.css" rel="stylesheet" type="text/css"/>
<link rel="icon" type="image/ico" href="<%=request.getContextPath()%>/images/favicon.ico"/>
<script>var MAIN_DOMAIN="<%=request.getContextPath()%>";</script>
<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jselect/jselect.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tool_mover.js"></script>
<script type="text/javascript">$(document).ready(function()
{$("#firstpane p.menu_head").click(function()
{$(this).css({backgroundImage:""}).next("div.menu_body").slideToggle(500).siblings("div.menu_body").slideUp("fast");$(this).siblings().css({backgroundImage:""});});});</script>
<script type="text/javascript">$(document).ready(function(){$('a.login-window').click(function(){var loginBox=$(this).attr('href');$(loginBox).fadeIn(300);var popMargTop=($(loginBox).height()+24)/2;var popMargLeft=($(loginBox).width()+24)/2;$(loginBox).css({'margin-top':-popMargTop,'margin-left':-popMargLeft});$('body').append('<div id="mask"></div>');$('#mask').fadeIn(300);return false;});$('a.close, #mask').live('click',function(){$('#mask , .login-popup1').fadeOut(300,function(){$('#mask').remove();});return false;});});</script>
<script type="text/javascript">jQuery(document).ready(function(){if(jQuery(".SelectUI").length>0){jQuery(".SelectUI").addSelectUI({scrollbarWidth:10});}});</script>
<!--[if lt IE 9]>
        <script src="/static/js/html5.js"></script>
        <link rel="stylesheet" href="/static/css/ie.css">
    <![endif]-->
<!--[if gte IE 7]><style>.province {width:302px;}</style><![endif]-->
<!--[if gte IE 8]><style>.line_ql {padding-bottom:5px;}</style><![endif]-->
</head>
<body>
<jsp:include page="header.jsp"/> 

<jsp:include page="content.jsp"/>    

</body>
</html>