
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--H5声明 --%>
<!DOCTYPE html>
<html>
<head>
	
    <title></title>
	<%--引入Bootstrap框架 --%>
	
	<%--兼容手机端 --%>
	<meta name="viewpor" content="width=device-width,initial-scale=1.0">
	<%--分别css/js --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrap.min.css">
	<%--调用vootstrapvalidator.css插件 --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrapValidator.min.css">
	<%--调用EveryPart.css包含了顶部，左部区域的样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/EveryPartCSS.css">
	<%--调用自己的TopPart.css样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/TopPart.css">
	<%--调用右边公告css，以显示编辑按钮 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/RightPart.css">
 	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="ImportCSSorJS/JS/jquery-1.9.1.min.js"></script>
	<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
	<script src="ImportCSSorJS/JS/popper.min.js"></script> 
	<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
	<script src="ImportCSSorJS/JS/bootstrap.min.js"></script>
	<%--调用相应bootstrapValiator插件 --%>
	<script src="ImportCSSorJS/JS/bootstrapValidator.js"></script>
	
	<!-- 引入登录验证JS文件 -->
	<script src="CSSorJS/JS/LoginInput.js"></script>
	
	<%--查询session是否有记录 --%>
	
	<%--调用HomePage.js --%>
	<script src="CSSorJS/JS/HomePage.js"></script>
	
</head>
 
<body>
	<!-- 进入布局 -->
   	<div id="container-fluid" >
   		<%--顶部位置 --%>
   		<jsp:include page="MainTopPart.jsp" flush="true"></jsp:include>	
   		
   		<!--右边区域广告部分  -->
		<jsp:include page="MainRightPart.jsp"></jsp:include>
		
		
		<!-- 左边内容区域 -->	
		<div class="Leftcontent">
				<%--查看所有图书 --%>
				<div class="AllBook" id="AllBookDiv">
					<img  src="Pic/HomeBook.png"/>			
				</div>
				<%--消息论坛--%>
				<div class="messagecomm">
					<img src="Pic/HomeTalk.png"/>
				</div>
				<%--游戏区域/娱乐版块 --%>
				<div class="enjoyself">
					<img src="Pic/HomePlay.png"/>
				</div>
				<%--个人信息设置 --%>
				<div class="InfoSetting">
					<img src="Pic/HomeUser.png"/>
				</div>
				<%--管理员管理版块 --%>
				<div class="mgcontrol">
					<img src="Pic/HomeControl.png"/>
				</div>
		</div>
   		
		<%--内含入底部部分 User--%>
		<jsp:include page="MainButtomPart.jsp"></jsp:include>
		<!-- 以上布局 -->
		
   		
   		
	</div>	
</body>
</html>