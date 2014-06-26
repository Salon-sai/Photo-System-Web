<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
<link href="../home_ui/css/pt_lib_macro.css" type="text/css" rel="stylesheet">
<link href="../css/pt_page_user_blognameSearch.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#search_user_text').blur(function(e){
			var value = $(this).val();
			var url = "${pageContext.request.contextPath }" + "/search/searchUser.action?userKey=" + value;
			$("#search_user_url").attr("href",url);
		});
		
		$("[name='add_follow']").click(function(e){
			$.post("${pageContext.request.contextPath }/relationship/addfollowing.action",
				{IdNumber: $(this).prev().val()},
				function(returnData,status){
					alert(returnData.addflag);			
				}
			);
		});
		
		$("[name='remove_follow']").click(function(e){
			$.post("${pageContext.request.contextPath }/relationship/removefollowing.action",
				{IdNumber: $(this).prev().val()},
				function(returnData,status){
					alert(returnData.removeflag);
				}
			);
		});
	});
</script>
</head>
<body>
	<div id="lofterheadbar" class="g-hd">
    <h1 class="m-logo"><a href="#">LOFTER</a></h1>
    <div class="m-nav" id="topbar">
	        <ul class="nav1 tbtag">
	            <li class="j-crt"><a rel="nofollow" href="${pageContext.request.contextPath }/user/index.action">首页</a><a href="../home_ui/LOFTER.html" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc tbtag">5</span></a></li>
				<li class=""><a href="${pageContext.request.contextPath }/user/profile.jsp">设置</a></li>
				<li style="display:none;" id="arturl"><a target="_blank" rel="nofollow" href="http://www.lofter.com/art?act=qbart_20140403_09">ART</a><a target="_blank" href="http://www.lofter.com/art?act=qbart_20140403_09" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc">绘画</span></a></li>
	            <li>
	            	<a href="${pageContext.request.contextPath }/sso/logout.action" class="tbtag">登出<span class="more tbtag">&nbsp;&nbsp;&nbsp;</span></a>
	            	<a href="http://www.lofter.com/#" class="w-tip f-dn" id="uapptip1"><span class="tipc">新</span></a>
	            	<div class="a-w-sel a-w-sel-4 tbtag">
		            	<div class="w-sel w-sel-4" style="margin-top: -258px;">
		                	<div class="selc">
		                    	<div class="selcc tbtag">
		                            <div class="seli"><a class="nx-1" href="http://www.lofter.com/setting">帐号设置</a></div>
		                            <div class="seli"><a class="nx-2" href="http://www.lofter.com/inviteelist#siteIndex=0&typeIndex=0">寻找好友</a></div>
		                            <div class="seli"><a class="nx-6" href="http://www.lofter.com/export">导入导出</a></div>
		                            <div class="seli"><a class="nx-3" href="http://www.lofter.com/app?act=qbappentry_20140303_01">移动客户端</a></div>
		                            <div style="_display:block;_position:static;_zoom:1;_visibility:hidden;_overflow:hidden;_height:0;_border:none;" class="seli f-dn" id="uapptip2"><a class="nx-7" href="http://www.lofter.com/uappsetting">UAPP-创建个人应用</a><span class="newicn"></span></div>
		                            <div class="seli"><a class="nx-4" href="http://www.lofter.com/help">帮助及反馈</a></div>
		                            <div class="seli"><a class="nx-5" href="http://www.lofter.com/logout">退出</a></div>
		                        </div>
		                    </div>
		                </div>
		            </div>
	            </li>
	        </ul>

	        <div class="nav2 m-ssch-act" id="schtagbox">
	        	<div class="ssch tbtag">
	                <form class="xtag">
	                	<a id="search_user_url" href="${pageContext.request.contextPath }/user/home.jsp" class="btn xtag"></a>
	                	<label class="xtag" style="display:none;">搜索标签、博客</label>
	                    <input id="search_user_text" type="text" placeholder="搜索标签、博客" class="xtag" onfocus="this.isfocus = true;">
	                    <div class="xtag a-show-mask f-op0">
		                    <div class="new" style="display:none;" id="nav2flnew"></div>
	                    </div>
                	</form>
	            </div>
	            <div class="m-ssch2  m-ssch-act" style="position:absolute;top:100%;">
	            	<div class="suggest">
                    	<div class="sugbox xtag" style="visibility: hidden;">
                        </div>
                    </div>
                    <div class="a-w-sel a-w-sel-5 a-w-sel-do" style="display:none;">
	                    <div id="taglist" class="w-sel w-sel-5 tbtag" style="margin-top: 0px;">
			            	<div class="selc">
				            	<div id="favtagcnew" class="selcc tags">
				            	</div>
			            	</div>
		            	</div>
	            	</div>
	            </div>
	        </div>
		</div>
	</div>
	<div class="g-bd3">
		<div class="g-bdc">
	        <div class="g-mn">
	            <div class="g-box3">
	            	<h2 class="w-fttl">搜索到<span id="gblogcount">${fn:length(userbeans) }</span>个博客</h2>
	            </div>
	            <div class="m-glist">
	            	<ul class="f-cb ztag" style="background-color: transparent;">
	            		<c:forEach items="${userbeans }" var="user">
		            		<li>
								<div class="w-img2 w-img2-1">
								<a target="_blank" href="">
									<img class="xtag" src='<s:url 
									action="../photo/photoAction!viewImage?photo_id=%{#attr.user.head_photoId}"></s:url>'>
								</a>
								</div>
								<div class="cnt">
								<h4>
								<em>
								<a class="xtag" target="_blank" href="">${user.name }</a>
								</em>
								</h4>
								</div>
								<input type="hidden" value="${user.idNumber }">
								<c:choose>
									<c:when test="${user.followingBewteenYour }">
										<button name="remove_follow">删除关注</button>
									</c:when>
									<c:otherwise>
										<button name="add_follow">添加关注</button>
									</c:otherwise>
								</c:choose>
							</li>
	            		</c:forEach>
	            	</ul>
	            </div>
			</div>
		</div>
	</div>
	
	
		
</body>
</html>