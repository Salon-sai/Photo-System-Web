<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#blogin').click(function(e){
				var id = $('#idNum').val();
				var password = $('#password').val();
				$.post('${pageContext.request.contextPath }/sso/checklogin.action',
						{idNum: id,password: password},
						function(returnData,status){
							if(returnData.user != null)
								window.location.href="${pageContext.request.contextPath }/sso/loginUser.action";
							else
								alert("password invaild");
						});
			});
		});
	</script>
</head>
<body>
	
	<form action="">
		<label for="idNum">ID</label>
		<input type="text" id="idNum" required="required"/><br>
		<label for="password">Password</label>
		<input type="password" id="password"><br>
		<input type="button" id="blogin" value="login">
	</form>
</body>
</html>