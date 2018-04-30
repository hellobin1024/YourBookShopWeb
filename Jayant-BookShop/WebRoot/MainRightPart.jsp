
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
	
	<link rel="stylesheet" href="CSSorJS/CSS/RightPart.css">
 	
	
  </head>
  
  <body>
  	<%--因为不考虑多个终端，所以不用响应式布局 --%>
    <div class="container-fluid">
    	
<body>
	<div id="container-fluid" >
		<div class="Rightcontent" >
			<!--右上公告部分-->
			<div class="RightTopcontent" id="RightTopcontent">
				<h1 class="text-info">公告</h1>
				<button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#exampleModalAnno"
					 id="RightTopcontent-edit">
					编辑
				</button>
				<%--滚动字幕,但已经被H5标准剔除了,英文字符不换行~ --%>
				<marquee direction="up" id="RightTopcontent-TextScroll" class="font-weight-bold">
					
				</marquee>
			</div>
			<!-- 右下轮播部分 -->
			<div class="RightButtomcontent" >
				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  					<%--小条列 --%>
  					<ol class="carousel-indicators">	
    					<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  					</ol>
  					<div class="carousel-inner">
    					<div class="carousel-item active">
      						<img class="d-block w-100" src="Pic/AD1.jpg" alt="第一张图">
    					</div>
    					<div class="carousel-item">
      						<img class="d-block w-100" src="Pic/AD2.jpg" alt="第二张图">
    					</div>
    					<div class="carousel-item">
      						<img class="d-block w-100" src="Pic/AD3.jpg" alt="第三张图">
    					</div>
  					</div>
  					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    					<span class="sr-only">Previous</span>
  					</a>
  					<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    					<span class="carousel-control-next-icon" aria-hidden="true"></span>
    					<span class="sr-only">Next</span>
  					</a>
				</div>
			</div>
		</div>
		
		<%-- 修改公告 的 模态框 --%>
		<div class="modal fade" id="exampleModalAnno" tabindex="-1" role="dialog" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
   				 <div class="modal-content">
      				<div class="modal-body" >	
      				<%--输入的修改公告的文字内容 --%>
        				<textarea class="form-control" id="Annotextarea" aria-label="With textarea" ></textarea>
     				</div>
      				<div class="modal-footer">
      					<p class="text-danger" id="Annosaveinfo"></p>
        				<button type="button" class="btn btn-primary" id="Annosavebtn">保存公告</button>
      				</div>
    			</div>
  			</div>
		</div>
		<%--End修改公告 --%>
		
		
	</div>
</body>
</html>
