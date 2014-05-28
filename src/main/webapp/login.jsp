<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <link rel="stylesheet" type="text/css" href="login_files/css/login.css">

    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>

    <script type="text/javascript">

    checkLogin = function(){
	    var id = $('#ID').val() ;
	    var password = $('#password').val() ;
	    $.post('${pageContext.request.contextPath }/sso/checklogin.action',
	    	{idNum: id,password: password},
	        function(returnData, status){
	        if(returnData.returnMsg == null){
	            window.location.href="${pageContext.request.contextPath }/sso/loginUser.action" ;
	        }else{
	            updateValidate(returnData.returnMsg) ;
	        }
	    });
    };

    function updateValidate(text){
	    $('.validate').text(text)
	    .addClass("wrong");
	    setTimeout(function(){
	    $('.validate').removeClass("wrong",500);
	    },50);
    };

    function show_registerForm(){
        $('#login_form').slideUp("slow");
        $('#register_form').slideDown("slow");
    };

    function show_loginForm(){
        $('#login_form').slideDown("slow");
        $('#register_form').slideUp("slow");
    };

    function register_form(){
    	$.post("${pageContext.request.contextPath }/user/userAction!register.action",
    			{registerNumberId : $('#registerID').val(),
    			registerName : $('#registerName').val(),
    			registerPassword : $('#registerPassword').val()},
    			function(returnData,status){
    				
    			});
    };
    
    </script>	

  </head>
  
  <body class="center-background">
   <div >
    <div class="container">
     <div class="login">
     <h1>System</h1>
     <form id="login_form">
         <p><input type="text" id="ID" placeholder="StudentID or TeacherID" autofocus="autofocus"/></p>
         <p><input type="password" id="password" placeholder="Password"/></p>
         <p class="validate"></p>
         <p class="submit">
            <input type="button" value="register" id="register" onclick="show_registerForm();"/>
            <input type="button" name="commit" value="Login" onclick="checkLogin();"/>
         </p>
     </form>
     <form id="register_form" style="display:none">
         <p><input type="text" id="registerID" placeholder="ID"/></p>
         <p><input type="text" id="registerName" placeholder="Your name"/></p>
         <p><input type="password" id="registerpassword" placeholder="Password"/></p>
         <p><input type="password" id="registerrepassword" placeholder="password again"/></p>
         <p class="validate"></p>
         <p class="submit">
            <input type="button" value="To Login" onclick="show_loginForm();"/>
            <input type="button" value="Register" onclick="register_form();"/>
         </p>
     </form>
     </div>
    </div>
    </div>
  </body>
</html>