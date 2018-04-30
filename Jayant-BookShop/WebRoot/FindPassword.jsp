<%--   找！！   	回！！   	密！！	码！！	页！！	面！！    --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%--引入Bootstrap框架 --%>
	
	<%--兼容手机端 --%>
	<meta name="viewpor" content="width=device-width,initial-scale=1.0">
	<%--分别css/js --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrap.min.css">
	<%--调用vootstrapvalidator.css插件 --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrapValidator.min.css">
	<%--调用Topheader.css --%>
	<link rel="stylesheet" href="CSSorJS/CSS/EveryPartCSS.css">
	<%--调用自己的css样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/TopPart.css">
	<%--调用自己的css样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/ButtomPart.css">
 	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="ImportCSSorJS/JS/jquery-1.9.1.min.js"></script>
	<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
	<script src="ImportCSSorJS/JS/popper.min.js"></script> 
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="ImportCSSorJS/JS/bootstrap.min.js"></script>
	<%--调用相应bootstrapValiator插件 --%>
	<script src="ImportCSSorJS/JS/bootstrapValidator.js"></script>
	
	
	<%--调用找回密码的JS文件 --%>
   	<script src="CSSorJS/JS/FindPWD.js"></script>
   	
   	
  </head>
  
  <body>
	<div id="container-fluid" >
		 <%--头 --%>
		<div id="header" >
				<h3 class="text-white">Your Book Shop</h3>
		</div>
		
		<%--主体表单 --%>
		<div id="FindPwdForm">
		
			<form class="FindPwdFormInput" id="FindPwdFormInput" method="post"  >
  				
  				<div class="form-group">
    				<label for="FindFormUserName">请输入您的用户名</label>
    				<%--要注意bootstrapValidator验证是依靠表单上的name属性的;所以记得写name属性 --%>
    				<input type="text" class="form-control" id="FindFormUserName" name="FindFormUserName" >
    				<small id="FindFormUserNameinfo"  class="form-text text-muted"></small>
  				</div>
	  			
	  			<div class="form-group">
    				<label for="FindFormAnswer">请填写您的密保答案</label>
    				<p class="font-weight-bold text-danger" id="FindFormQuestion"></p>
    				<input type="text" class="form-control" id="FindFormAnswer" name="FindFormAnswer" >
    				<small id="FindFormAnswerinfo"  class="form-text text-muted"></small>
  				</div>
  				
  				<div class="form-group">
    				<label for="FindFormPassWord1">请输入您的密码</label>
    				<input type="password" class="form-control" id="FindFormPassWord1" name="FindFormPassWord1" >
    				<small id="FindFormPassWord1info"  class="form-text text-muted"></small>
  				</div>
  				
  				<div class="form-group">
    				<label for=""FindFormPassWord2"">请再次输入您的密码</label>
    				<input type="password" class="form-control" id="FindFormPassWord2" name="FindFormPassWord2" >
    				<small id="FindFormPassWord2info"  class="form-text text-muted"></small>
  				</div>
  				
  				<button type="button" id="FindPwdFormBtn"  class="btn btn-primary" >确认修改!</button>
  				<small id="FindPwdFormBtninfo"  class="form-text text-muted"></small>
			</form>
		
		
		</div>
		
		<%--底部 --%>
		<footer class="footer">
			<p class="text-white">联系：Jayant89@163.com	</p>
		</footer>
	</div>
  </body>
</html>
