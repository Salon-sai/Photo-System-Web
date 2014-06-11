<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%--  	<div>
		<img alt="" src='<s:url action="../photo/photoAction!viewImage?photo_id=%{photos[0].id}"></s:url>'/>
	</div>  --%>
	
<%--  	<c:forEach items="${photos }" var="photo">
		<img alt="" src='<s:url action="../photo/photoAction!viewImage?photo_id=%{#attr.photo.id}"></s:url>'>
	</c:forEach> --%>
	<br>
	<c:out value="${image.id }"></c:out> 
	<br><br>
	<c:forEach items="${posts }" var="post">
		<s:property value="#attr.post.photo_id[0]"/><br>
		<%-- <c:forEach items="${post.photo_id }" var="id">
			<s:property value="#attr.id"/><br>
		</c:forEach><br> --%>
		<%-- ${post.photo_id.size }  --%>
	</c:forEach>
</body>
</html>