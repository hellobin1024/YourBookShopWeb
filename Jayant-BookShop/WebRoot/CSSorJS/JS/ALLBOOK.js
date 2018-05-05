/**
 * 
 */

$(document).ready(function(){
	//要注意的点;多个相同id绑定了点击事件，要加上前缀例如下面这个    $("a#fenlie")
	$("a#fenlei").click(function(){
		var c = $(this).html()
		//获取值和数据库交互
		//console.log("我是被监听的"+a+"标签");
		$.ajax({
			url:"FindBook.action",
			method:"post",
			datatype:'text',
			data:{
				chooseBook:c,
			},
			//返回json的数据，入表格
			success:function(backa){
			/*如果返回成功，要清除原本表格内容,因为都在同一个表格中显示*/
				var a = parseInt(backa);
				var aa = parseInt((a+5-1)/5);
				if(a>0){
					//把页码行列显示出来
					
					$("#pagination").show();
					$("#whatbook").html(c);
					$("#booksum").html(a);
					$("#total").html(aa);
					/*获得当前页面的数值,目前一定是第一页~*/
					var currentPage = parseInt($("#current").text());
					getPageInfo(currentPage,c);
				}
			},
			error:function(backa){
				
			},
		});
	});
	
	/*查每一页详情的方法*/
	function getPageInfo(currentPage,c){
		c = $("#whatbook").html();
		//用ajax去获取每一页
		$.ajax({
			url:"FindCurrentPage.action",
			method:"post",
			dataType:"json",
			//传递的数据是那一页,c是书的类别~
			data:{
				bookLeiBie:c,
				howPage:currentPage,
			},
			success:function(data){	
				//如果数据非空要用于清除表单原有的数据
				if(data!=null){
					//清除原有的表格数据，方便更新新的附上去~
					$("#BookContainShow").empty();
					//返回list对象~
					var list = data.pagebooklist;
					/*测试输出,以及是否有接收到~
					for(var i=0;i<list.length;i++){
						var news = list[i];
						console.log(news);	
					}
					*/
					//定义表格str语句，稍后赋给.html()
					var str=""
					for(var i=0;i<list.length;i++){
						var news = list[i];
						//分别给书本的各属性赋值
						var booktitle = news.title;
						var bookauthor = news.author;
						var bookbelongg = news.belongg;
						var booksummaryy = news.summaryy;
						var bookpicUrl = news.picUrl;
						str += "<tr >" +
									"<td><img class=\"BookPicSize\" src=\" "+bookpicUrl+" \" alt=\" "+booktitle+" \"/></td>" +
									"<td>" +
										"书名："+booktitle+"</br>"+
										"作者："+bookauthor+"</br>"+
										"出版信息"+bookbelongg+"</br>"+
										"书籍简介"+booksummaryy+"</br>"+
										//给一个超链接,并且可以预指定方法
										"<a href=\"checklogin.action\">下载本书籍</a>"
										/*一开始的时候想用ajax验证一下是否已经登录的，但是,结果不能先用ajax~所以直接用action的形式~那么用拦截器来验证登登录吧~
										
										"<a href=\"javascript:void(0)\"class=\"DLbook\" id=\""+booktitle+"\">下载本书籍" +
												"</a>"+
										 */
									"</td>" +
								"</tr>"	
					}
					//连接~
					str+=""
					$("#BookContainShow").html(str);
				}
				
			},
		});
	}
	//点击上一页时，计算一下是否超出总页数
	$("#PreviousPage").click(function(){
		if($("#current").text()=="1"){
			alert("不行，没有上一页了")
		}
		else{
			//parseInt将字符形式转为数字！
			var currentPage = parseInt($("#current").text())-1;
			$("#current").html(currentPage);
			getPageInfo(currentPage);
		}
		
	});
	//点击下一页时计算是否超出
	$("#NextPage").click(function(){
		//比较相应字符相不相同即可，无所谓转不转
		if($("#current").text()==$("#total").text()){
			alert("不行，没有下一页了")
		}
		else{
			var currentPage =parseInt($("#current").text())+1;
			$("#current").html(currentPage);
			getPageInfo(currentPage);
		}
	});
	
	//点击下载书籍时，映射到的方法;是动态生成的<a>标签,所以需要
	//给父元素委托一下事件;直接给onclick()方法是无效的~
	/*不用ajax不然信息回来不能被接受下载框
	$("#BookContainShow").on("click","a",function(){
		//获取到id(名字)去下载到相应的书籍~
		var DLbook = $(this).attr('id');
		//测试---alert(a);
		//判断是否登录过了？如果没有，出登录~
		//if($("#SessionPWDSTATE").val()=="0"){
			$.ajax({
				url:"checklogin.action",
				method:"post",
				datatype:'text',
				//这一步就先免了，没准备那么多文件
				data:{
					downloadbook:DLbook,
				},
				success:function(backa){
					alert(backa);
				},
				error:function(){
					
				}
			});
		//}
		//else{
		//	alert("请您先点击右上角图标回首页进行登录！")
		//}
	});
	*/
	
	
});
