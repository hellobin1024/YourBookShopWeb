<%--	所！	有！	书！	籍！	页！	面!	无!	判!	断! 	--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
	
    <title></title>
	<%--引入Bootstrap框架 --%>
	
	<%--兼容手机端 --%>
	<meta name="viewpor" content="width=device-width,initial-scale=1.0">
	<%--分别css/js --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrap.min.css">
	<%--调用vootstrapvalidator.css插件 --%>
	<link rel="stylesheet" href="ImportCSSorJS/CSS/bootstrapValidator.min.css">
	<%--jQuery文件。务必在bootstrap.min.js 之前引入 --%>
	<script src="ImportCSSorJS/JS/jquery-1.9.1.min.js"></script>
	<%-- popper.min.js 用于弹窗、提示、下拉菜单 --%>
	<script src="ImportCSSorJS/JS/popper.min.js"></script> 
	<%-- 最新的 Bootstrap4 核心 JavaScript 文件 --%>
	<script src="ImportCSSorJS/JS/bootstrap.min.js"></script>
	<%--调用Angualr.JS文件 --%>
	<script src="ImportCSSorJS/JS/angular.min.js"></script>
	
	<%--调用自身ALLBOOK.css样式 --%>
	<link rel="stylesheet" href="CSSorJS/CSS/ALLBOOK.css">
	<%--调用自身ALLBOOK.js文件 --%>
	<script src="CSSorJS/JS/ALLBOOK.js"></script>
	
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
   
 
	
  </head>
  
  <body>
 	 <div id="container-fluid" >
     	<%--头 --%>
		<div id="header" >
				<h3 class="text-white"><a href="MainPart.jsp">Your Book Shop</a></h3>
				<input type="hidden" id="SessionUSERNAME" value="<%=SessionUSERNAME%>"/>
				<input type="hidden" id="SessionPWDSTATE" value="<%=SessionPWDSTATE%>"/>
				<input type="hidden" id="SessionISMG" value="<%=SessionISMG%>"/>
		</div>
		<%--主体 --%>
		
		<%--图书分类导航栏 --%>
		<div class="jumbotron">
			<div class="container">
				<ul class="nav">
  					<li class="nav-item">
  		   				<a class="nav-link active" href='javascript:void(0)' id="fenlei" >所有分类</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei" >AngularJS</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">BootStrap</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">CSS</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">HTML5</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">IOS</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">java</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">Javascript</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">Jquery</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">linux</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">NoSql</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">php</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">python</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">SEO</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">thinkphp</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">web</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">Database</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">Computer</a>
  					</li>			
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">science</a>
  					</li>
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">Design pattern</a>
  					</li>	
  					<li class="nav-item">
    					<a class="nav-link" href='javascript:void(0)' id="fenlei">C</a>
  					</li>			
				</ul>
			</div>
			<%--用于清除浮动，让父元素高度可以自适应 --%>
			<div class="clear"></div>
		</div>
		
		<%--展示图书内容 --%>
		<div class="contain">
			<table class="table table-striped">
  				<thead>
   					 <tr>
      					<th scope="col"></th>
      					<th scope="col"></th>
    				</tr>
  				</thead>
  				<%--存放图书数据 --%>
  				<tbody id="BookContainShow">
    				
  				</tbody>
			</table>
			
		<%--翻页的部分 --%>
		<div id="pagination">
			<nav aria-label="Page navigation example">
  				<ul class="pagination">
    				<li class="page-item">
      					<a class="page-link" id="PreviousPage" href="javascript:void(0)"  aria-label="Previous">
        					<span aria-hidden="true">&laquo;</span>
        					<span class="sr-only">Previous</span>
      					</a>
    				</li>
    				<p id="PageCenterStr"><span id="whatbook"></span>共有<span id="booksum"></span>本,当前 第 
    					<span id="current">1</span> 页/共 <span id="total"></span> 页  </p>				
    				<li class="page-item">
      					<a class="page-link" id="NextPage" href="javascript:void(0)" aria-label="Next">
        					<span aria-hidden="true">&raquo;</span>
        					<span class="sr-only">Next</span>
      					</a>
    				</li>
  				</ul>
			</nav>
		</div>
		</div>
		<%--以上主体 --%>
	
	</div>
	
  </body>
</html>
