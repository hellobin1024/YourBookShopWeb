<%--    注！！册！！页！！面！！        --%>

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
	<%--调用自己的css样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/TopPart.css">
	<%--调用底部CSS样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/ButtomPart.css">
	<%--调入区域主体布局css --%>
	<link rel="stylesheet" href="CSSorJS/CSS/EveryPartCSS.css">
	<%--调用入AngularJS文件 --%>
	<script src="ImportCSSorJS/JS/angular.min.js"></script>
 	<%-- jQuery文件。务必在bootstrap.min.js 之前引入 --%>
	<script src="ImportCSSorJS/JS/jquery-1.9.1.min.js"></script>
	<%-- popper.min.js 用于弹窗、提示、下拉菜单 --%>
	<script src="ImportCSSorJS/JS/popper.min.js"></script> 
	<%-- 最新的 Bootstrap4 核心 JavaScript 文件 --%>
	<script src="ImportCSSorJS/JS/bootstrap.min.js"></script>
	<%--调用入Angular route JS文件 --%>
	<script src="ImportCSSorJS/JS/angular-route.min.js"></script>
	
	
	
	
	
</head>
<body ng-app="app">
	
	<div id="container-fluid" >
		 	<%--头 --%>
		<div id="header" >
				<h3 class="text-white">Your Book Shop</h3>
		</div>
		<%--主体 --%>
		
		<div id="RegisterForm" >
			<%--submitForm传了表单正确与否的验证boolean值给后台进行验证 --%>
			<form name="RegisterForm1" id="RegisterForm1" ng-submit="submitForm(RegisterForm1.$valid)"
				 ng-controller="RegisterFormInputCtrl"   novalidate >
				
				<div class="form-group row">
    				<label for="inputUserName" class="col-sm-2 col-form-label">用户名</label>
    				<div class="col-sm-6">
    				
      					<input type="text"  class="form-control" id="inputUserName" name="inputUserName" 
      					ng-model="inputUserName" placeholder="用户名" ng-maxlength="20" required>
      					
    				</div>
    				<small id="inputUserNameInfo" class="text-muted" 
    					ng-show="RegisterForm1.inputUserName.$error.required
    					||RegisterForm1.inputUserName.$error.maxlength" >
      					请您输入20位以内的非空用户名!
    				</small>
  				</div>
  				
  				<div class="form-group row">
    				<label for="inputUserPassword1" class="col-sm-2 col-form-label">密码</label>
    				<div class="col-sm-6">
    				
      					<input type="password" class="form-control" id="inputUserPassword1" name="inputUserPassword1" 
      					ng-model="inputUserPassword1" placeholder="密码" ng-maxlength="20" required>
      					
    				</div>
    				<small id="inputPassword1Info" class="text-muted" 
    					ng-show="RegisterForm1.inputUserPassword1.$error.required||RegisterForm1.inputUserPassword1.$error.maxlength" >
    					请您输入20位以内的非空密码!
    				</small>
  				</div>
  				
  				<div class="form-group row">
    				<label for="inputUserPassword2" class="col-sm-2 col-form-label">确认密码</label>
    				<div class="col-sm-6">
    				
      					<input type="password" class="form-control" id="inputUserPassword2" name="inputUserPassword2" 
      					ng-model="inputUserPassword2" placeholder="确认密码" ng-maxlength="20" required >
      					
    				</div>
    				<small id="inputUserPassword2Info" class="text-muted" 
    					ng-show="RegisterForm1.inputUserPassword2.$error.required
    					||RegisterForm1.inputUserPassword2.$error.maxlength">
    					请您输入一致的密码!
    				</small>
    				<small class="text-muted text-danger" >{{samepassword}}</small>
  				</div>
  				
  				<div class="form-group row">
    				<label for="inputUserEmail" class="col-sm-2 col-form-label">Email</label>
   					<div class="col-sm-6">
   					
      					<input type="email" class="form-control" id="inputUserEmail" name="inputUserEmail"  
      					ng-model="inputUserEmail" placeholder="Email" ng-maxlength="50" required >
      					
    				</div>
    				<small id="inputUserEmailInfo" class="text-muted"
    					ng-show="RegisterForm1.inputUserEmail.$error.required
    					||RegisterForm1.inputUserEmail.$error.maxlength||RegisterForm1.inputUserEmail.$error.email">
    					请您输入合法的邮箱形式!
    				</small>
  				</div>
  				
  				<div class="form-group row">
    				<label for="inputUserRealName" class="col-sm-2 col-form-label">真实姓名</label>
    				<div class="col-sm-6">
    				
      					<input type="text" class="form-control" id="inputUserRealName" name="inputUserRealName" 
      					ng-model="inputUserRealName" placeholder="姓名" ng-maxlength="10" required>
      					
    				</div>
    				<small id="inputUserRealNameInfo" class="text-muted"
    					ng-show="RegisterForm1.inputUserRealName.$error.required||RegisterForm1.inputUserRealName.$error.maxlength">
    					请您输入您的真实姓名!
    				</small>
  				</div>
  				<%--下拉框的选择;密保 --%>
  				<div class="form-group row">
  					<select class="custom-select col-sm-4" id="inputUserProblem">
  						<option selected>请选择您的密保问题:</option>
  						<option value="您的手机号码后四位">您的手机号码后四位</option>
  						<option value="您的家乡城市名称">您的家乡城市名称</option>
  						<option value="您最喜欢的歌手">您最喜欢的歌手</option>
  					</select>
  					<div class="col-sm-6">
      					<input type="text" class="form-control" id="inputUserAnswer" name="inputUserAnswer" 
      					ng-model="inputUserAnswer"  ng-maxlength="200" required>
    				</div>
    				<small id="inputUserAnswerInfo" class="text-muted"
    					ng-show="RegisterForm1.inputUserAnswer.$error.required||RegisterForm1.inputUserRealName.$error.maxlength">
    					请您输入您的密保问题,这将是您找回密码的关键信息,请牢记!
    				</small>
  				</div>
  				
  				<div class="form-group row">
    				<div class="col-sm-10">
      					<button type="submit"  class="btn btn-primary" >提交注册!</button>
      					<p class="text-danger" id="alertinfo"></p>
    				</div>
  				</div>
  				
  				
			</form>
		</div>
		
		<%--底部 --%>
		<footer class="footer">
			<p class="text-white">联系：Jayant89@163.com	</p>
		</footer>
		 						
	</div>
	
	<%--调用入验证文件 --%>
	<script src="CSSorJS/JS/RegisterInput.js"></script>
	
	
	
</body>
</html>