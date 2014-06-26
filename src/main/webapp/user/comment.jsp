<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/comment.css">
<link rel="stylesheet" type="text/css" href="../home_ui/css/homecss.css">
<!-- <link href="../home_ui/css/pt_lib_macro.css" type="text/css" rel="stylesheet"> -->
<script type="text/javascript" src="../home_ui/js/ga.js"></script>
<script type="text/javascript">
	$(function(){
		$('#publish_comment').click(function(e){
			var content = $('#send_content').val();
			$.post("${pageContext.request.contextPath }/comment/saveComment.action",
					{content : content,postId : $("#postId").val()},
					function(returnData,status){
						
					});
		});
	});
</script>
</head>
<body>
<div class="isaymin">
	<div class="isayi add">
		<div class="w-inputxt xtag noshortkey" contenteditable="true" maxlength="200">
			<input type="hidden" id="postId">
			<input type="text" id="send_content">
		</div>
		<button class="w-bbtn xtag w-bbtn-0" id="publish_comment">发　布</button>
	</div>
	<div class="m-cmt">
		<div class="a-show a-show-cmtul a-show-do" style="height: 180px;">
			<ul class="xtag">
				<c:forEach items="${comments }" var="comment">
				<li class="a-slide a-slide-do">
					<div class="cmti slide xtag" style="margin-top: 0px;">
						<div class="w-img2 w-img2-2 noshortkey">
							<a target="_blank" href="" title="">
								<img class="xtag" src='<s:url action="../photo/photoAction!viewImage.action?photo_id=%{#attr.comment.poster_headphotoId}"></s:url>'>
							</a>
						</div>
						<div class="cmtcnt">
							<div class="cmthot">
								<span class="cmtusr">
									<a class="s-fc4 xtag" target="_blank" href="" title="${comment.posterName } - ${comment.postdate}">${post.posterName }</a>
									<span class="xtag">
									  回复了
									<a class="s-fc4 xtag" target="_blank" href="">${comment.recipientName }</a>
									</span>
								</span>
								<span class="xtag">${comment.content }</span>
							</div>
							<div class="cmtopt">
								<a class="cmtj s-fc4 xtag" href="#">加黑</a>
								<a class="s-fc4 xtag" href="#">回复</a>
							</div>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
		

</body>
</html>