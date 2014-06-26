<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
	<link href="../home_ui/css/pt_lib_macro.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	
	<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap-filestyle.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$(":file").filestyle();
    		
			$('#search_user_text').blur(function(e){
    			var value = $(this).val();
    			var url = "${pageContext.request.contextPath }" + "/search/searchUser.action?userKey=" + value;
    			$("#search_user_url").attr("href",url);
    		});
		});
	</script>
	
	<style type="text/css">
		.form{
		    border:dashed 0px #000000;
		    -moz-border-radius: 11px;
		    -webkit-border-radius: 11px;
		    border-radius: 11px;
		    -moz-box-shadow: 1px 3px 7px #000000;
		    -webkit-box-shadow: 1px 3px 7px #000000;
		    box-shadow: 1px 3px 7px #000000;
		    width: 350px;
		    height: 300px;
		}
	</style>
</head>
<body>
	<div id="lofterheadbar" class="g-hd">
	    <h1 class="m-logo"><a href="LOFTER.html"></a></h1>
	    <div class="m-nav" id="topbar">
		        <ul class="nav1 tbtag">
		            <li class="j-crt"><a rel="nofollow" href="${pageContext.request.contextPath }/user/index.action">首页</a><a href="../home_ui/LOFTER.html" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc tbtag">5</span></a></li>
					<li class=""><a href="#">设置</a></li>
					<li style="display:none;" id="arturl"><a target="_blank" rel="nofollow" href="http://www.lofter.com/art?act=qbart_20140403_09">ART</a><a target="_blank" href="http://www.lofter.com/art?act=qbart_20140403_09" class="w-tip w-tip-1" style="font-size: 12px; color: white; text-shadow: none; display: none;"><span class="tipc">绘画</span></a></li>
		            <li>
		            	<a href="#" class="tbtag">更多<span class="more tbtag">&nbsp;&nbsp;&nbsp;</span></a>
		            	<a href="" class="w-tip f-dn" id="uapptip1"><span class="tipc">新</span></a>
		            	<div class="a-w-sel a-w-sel-4 tbtag">
			            	<div class="w-sel w-sel-4" style="margin-top: -258px;">
			                	<div class="selc">
			                    	<div class="selcc tbtag">
			                            <div class="seli"><a class="nx-1" href="">帐号设置</a></div>
			                            <div class="seli"><a class="nx-2" href="">寻找好友</a></div>
			                            <div class="seli"><a class="nx-6" href="">导入导出</a></div>
			                            <div class="seli"><a class="nx-3" href="">移动客户端</a></div>
			                            <div style="_display:block;_position:static;_zoom:1;_visibility:hidden;_overflow:hidden;_height:0;_border:none;" class="seli f-dn" id="uapptip2"><a class="nx-7" href="http://www.lofter.com/uappsetting">UAPP-创建个人应用</a><span class="newicn"></span></div>
			                            <div class="seli"><a class="nx-4" href="">帮助及反馈</a></div>
			                            <div class="seli"><a class="nx-5" href="">退出</a></div>
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
	
	<div class="g-bd">
		<div class="g-bdc">
			<div class="g-mn form" id="main">
			<form action="${pageContext.request.contextPath }/profile/updateProfile.action" method="post" enctype="multipart/form-data">	
				<div class="input-group" style="width: 300px">
					<span class="input-group-addon glyphicon glyphicon-file"></span>
					<input type="file" class="form-control filestyle" placeholder="Name" name="headphoto">
				</div><br>
				<div class="input-group" style="width: 300px">
					<span class="input-group-addon glyphicon glyphicon-user"></span>
					<input type="text" class="form-control" placeholder="Name" name="updateName">
				</div><br>
				<div class="input-group" style="width: 300px">
					<span class="input-group-addon glyphicon glyphicon-briefcase"></span>
					<input type="text" class="form-control" placeholder="Company" name="updateCompany">
				</div><br>
				<div class="input-group" style="width: 300px">
					<span class="input-group-addon glyphicon glyphicon-envelope"></span>
					<input type="email" class="form-control" placeholder="E-mail" name="updateemail">
				</div><br>
				<div class="input-group" style="width: 300px">
					<span class="input-group-addon glyphicon glyphicon-globe"></span>
					<input type="text" class="form-control" placeholder="location" name="updatelocation">
				</div>
				
				<button type="submit" class="btn btn-default navbar-btn">Update</button>
				
			</form>
			</div>
		</div>
	</div>
</body>
</html>