<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    
    <head>
        <meta name="themename" content="99001">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=emulateie7">
        <title>
            ${sessionScope.user.name }
        </title>
        <!-- <link rel="shortcut icon" href="http://imgsize.ph.126.net/?imgurl=http://img1.ph.126.net/AdVum_joIsFJkf-oJTroBg==/143270763245961553.jpg_16x16x0x90.jpg"> -->
        <!-- <link rel="alternate" type="application/rss+xml" href="http://kaxiuptd.lofter.com/rss"> -->
        <meta name="Keywords" content="${sessionScope.user.name }">
        <meta name="Description" content="${sessionScope.user.name } - ">
        <meta name="color:主题" content="#09f">
        <meta name="image:Logo" content="">
        <link type="text/css" rel="stylesheet" href="../css/5629524822980563235.css">
        <style>
            .m-title a,.m-title a:hover{color:#8b8b8b;} .btn-close,.top,.m-post .layer,.m-pager
            a,.btn-newwin{background-color:#8b8b8b;}
        </style>

    </head>
    
    <body class="g-homepage">
        <iframe id="control_frame" allowtransparency="true" style="position:fixed;_position:absolute;clear:both; width: 390px; height: 32px; z-index:1337; top:0; right:15px;zoom:1; border:0px; background-color:transparent; overflow:hidden;"
        src="./control.jsp" frameborder="0" height="32px" scrolling="no" width="390px">
        </iframe>
        </iframe>
        <div class="g-doc">
            <div class="g-bd box">
                <div class="g-hd">
                    <div class="g-hdc">
                        <h1 class="m-title">
                            <a href="#">
                                ${sessionScope.user.name }
                            </a>
                        </h1>
                        <ul class="m-nav">
                            <li>
                                <a href="#" title="关于" id="lnk-about">
                                    关于
                                </a>
                            </li>
                            <li>
                                <a href="" rel="nofollow">
                                    私信
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    归档
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    RSS
                                </a>
                            </li>
                            <li>
                                <a class="sch-lnk" id="sch-lnk" href="#" title="搜索">
                                    搜索
                                </a>
                                <form class="sch-form" action="/search" method="get">
                                    <input class="sch-txt f-dn" id="sch-txt" name="q" type="text">
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="g-mn">
                    <div class="g-mnc">
                        <div class="m-postlst box">
                        	<c:forEach var="post" items="${posts }">
                        		<div class="m-post m-post-img">
	                                <a class="plink" href="#"
	                                title="点击进入详细页面">
	                                    <span class="pic">
	                                        <!-- <img src="../sample_picture/a_005.jpeg"> -->
	                                        <img alt="" src="<s:url action="../photo/photoAction!viewImage?photo_id=%{#attr.post.photo_id[0]}"></s:url>">
	                                    </span>
	                                    <span class="layer">
	                                    </span>
	                                    <span class="lnk">
	                                        <span class="date">
	                                            <span class="date-icn">
	                                            </span>
	                                            ${post.postdate }
	                                        </span>
	                                    </span>
	                                </a>
	                            </div>
                        	</c:forEach>
                            <div class="f-cb">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="m-top">
                    <a class="top" href="#">
                        &nbsp;
                    </a>
                </div>
                <div class="g-ft">
                    <p class="m-cprt">
                        ©&nbsp;
                        <a href="#">
                            ${sessionScope.user.name }
                        </a>
                        &nbsp;|&nbsp;Powered by
                        <a href="http://www.lofter.com/">
                            SAIWEI
                        </a>
                    </p>
                </div>
                <div style="display:none;">
                    <a href="http://kaxiuptd.lofter.com/?page=2" id="next_page_link">
                        &nbsp;
                    </a>
                </div>
            </div>
        </div>
        <script src="../control_data/ga.js" async="" type="text/javascript">
        </script>
        <script type="text/javascript">
            window.permalink = false;
        </script>
        <script type="text/javascript" src="../js/jquery-2.1.1.min.js">
        </script>
        <link media="screen" type="text/css" rel="stylesheet" href="../css/pagephotoshow.css">
        <script type="text/javascript" src="../js/pagephotoshow.js">
        </script>
        <script type="text/javascript">
            P('loft.w.g').initPagePhotoShow(document.body, {});
        </script>
        <script>
            window.Theme = {
                'ImageProtected': false,
                'CcType': 0,
                ContextValue: '版权保护'
            };
        </script>
        <script src="../js/themecommon.js" type="text/javascript">
        </script>
        <script src="../js/ntes.js" type="text/javascript">
        </script>
        <script>
            _ntes_nacc = 'lofter';
            try {
                neteaseTracker();
            } catch(e) {}
        </script>
        <script>
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-31007899-1'], ['_setLocalGifPath', '/UA-31007899-1/__utm.gif'], ['_setLocalRemoteServerMode']);
            _gaq.push(['_setDomainName', 'lofter.com']);
            _gaq.push(['_trackPageview']); (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = 'http://wr.da.netease.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
        </script>
    </body>

</html>