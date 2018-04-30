/**
 * 右半部分集结了的JS操作!
 */
$(document).ready(function() {
//页面加载的时候*---*公告加载的时候就去从数据库获取！
	$("#RightTopcontent").ready(function() {
		$.ajax({
			url:"Announ.action",
			method:"post",
			datatype:'text',
			date:{
				Boool:"trUUE"
			},
			success:function(backdata){
				$("#RightTopcontent-TextScroll").html(backdata);
			
			},
			error:function(backdate){
				$("#RightTopcontent-TextScroll").html("公告还未更新,敬请留意 ! 谢谢");
			}
		});
	});

	//点击查阅所有书籍~
	$("#AllBookDiv").click(function(){
		  window.location.href="ALLBOOK.jsp";
	});
	
//保存公告按钮时点击的时候做判断!
	$("#Annosavebtn").click(function(){
		var a = $("#Annotextarea").val();
		if(a.length==0){
			$("#Annosaveinfo").html("新公告不能为空!");
		}
		else{
			//ajax上传新公告!!
			$.ajax({
				url:'AddAnno.action',
				method:"post",
				datatype:"text",
				data:{
					newanno:a
				},
				success:function(backdate){
					if(backdate=="1"){
						
						$("#exampleModalAnno").modal('hide');
						$("#RightTopcontent-TextScroll").html(a);
						
					}
					else{
						$("#Annosaveinfo").html("失败,未知错误,请重试!");
					}
				},
			})
		}
	});


});
