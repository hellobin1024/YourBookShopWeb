
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- 主页面头顶部 -->

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    <%--本来前端引入文件的地方 --%>
    
  </head>
  
 <%	
 	//前端获取Seesion登录标志的值；用于验证，并且自动登录	
	String SessionPWDSTATE="";
	String SessionUSERNAME="";
	String SessionISMG="";
	  	if(session.getAttribute("PWDSTATE")!=null){
	  		SessionUSERNAME = session.getAttribute("USERNAME").toString();
	  		SessionPWDSTATE = session.getAttribute("PWDSTATE").toString();
	  		SessionISMG = session.getAttribute("ISMG").toString();
	  	}
   	%>
  	<%--因为不考虑多个终端，所以不用响应式布局 --%>
    <div class="container-fluid">
    	
<body>
	
	<div id="container-fluid" >
		<!-- 头部布局 -->
		<%--H5的布局 &Bootstrap的颜色--%>
		<div id="header" >
			<h3 class="text-white">Your Book Shop</h3>
			<div class="HeaderSearch">
				<form class="form-inline" id="SearchBookNameForm">
 				 	<div class="form-group mx-sm-1 mb-2">
   					 	<input type="text" class="form-control form-control-sm" id="SearchBookName" name="SearchBookName" placeholder="请输入书名">
 				 	</div>
  					<button type="submit" class="btn btn-primary btn-sm mb-2">
  					 	搜索图书
  					</button>
				</form>
			</div>
			
			<%--获取到Session的值，因为JS和JSP分离，所以采用此种方式传参 --%>
			
			<input type="hidden" id="SessionUSERNAME" value="<%=SessionUSERNAME%>"/>
			<input type="hidden" id="SessionPWDSTATE" value="<%=SessionPWDSTATE%>"/>
			<input type="hidden" id="SessionISMG" value="<%=SessionISMG%>"/>
			
			<%--登录,注册按钮 --%>
			<div class="btn-group" id="MyUserNameBtn" role="group" aria-label="Button group with nested dropdown">
				<div class="btn-group"  role="group">
   				 	<button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle btn-sm"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      					我是用户
    				</button>
    				<div class="dropdown-menu" id="dropdown-menu-header" aria-labelledby="btnGroupDrop1">
      					<a class="dropdown-item" data-toggle="modal" data-target="#exampleModal">登录</a>
      					<a class="dropdown-item" href="Register.jsp">注册</a>
    				</div>
  				</div>
			</div>
			
			<%--成功后进入的我的主页 --%>
			
			<div class="btn-toolbar " id="MyHomeDiv" role="toolbar" aria-label="Toolbar with button groups">
  				<small class="text-white" id="MyHomeText"></small>
   				
   				<a href="#" id="exitLogin"  class="badge badge-pill badge-primary">
   					退出登录!
   				</a>
   				
			</div>
			
			<%--modal模态框 --%>
			
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  				<div class="modal-dialog" role="document">
   					<div class="modal-content">
      					<div class="modal-header">
        					<h5 class="modal-title" id="exampleModalLabel">登录</h5>
        					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          						<span aria-hidden="true">&times;</span>
        					</button>
      					</div>
      					<div class="modal-body">
      					
      					<%--用户登录表单，并采用H5 --%>
      					<%--label for 是用于点击文字时,聚焦对应id的Input上 --%>
      					
        					<form  class="LoginInputForm" method="post" id="LoginInputForm"    >
        					
  								<div class="form-group">
    								<label for="loginInputUserName">用户名/账户</label>
    								<input type="text" class="form-control" id="loginInputUserName" name="loginInputUserName" placeholder="EnterUserName..." >
    								<small class="form-text text-muted" id="loginInputUserNameInfo"></small>
  								</div>
  								
  								<div class="form-group">
    								<label for="loginInputPassword">密码</label>
    								<input type="password" class="form-control" id="loginInputPassword" name="loginInputPassword" placeholder="Password" >
    								<small class="form-text text-muted" id="loginInputPasswordInfo">请注意输入大小写</small>
  								</div>
  								
  								<div class="form-group">
    								<div class="form-check">
      									<input class="form-check-input" type="checkbox" id="loginInputCheck" name="loginInputCheck" >
      									<label >
        									<a href="">遵守本站用户协议</a>
      									</label>
    								</div>
    								<a href="FindPassword.jsp">忘记密码了</a>
  								</div>
  								
  								<button type="button" id="loginbutton" class="btn btn-primary">确认登录</button>
  								
							</form>
      					</div>
    				</div>
  				</div>
			</div>
		</div>
	</div>
</body>
</html>
