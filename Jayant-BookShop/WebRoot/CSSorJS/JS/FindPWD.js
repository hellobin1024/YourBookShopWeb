/**
 * 
 */

$(document).ready(function() {
	//定义一个全局变量
	var IsUserName;
	
	//点击修改时的提交
	$("#FindPwdFormBtn").click(function(){
		$("#FindPwdFormInput").data("bootstrapValidator").validate();
		var flag = $("#FindPwdFormInput").data("bootstrapValidator").isValid();
		if(IsUserName==true){
			//如果用户名存在，那么ajax提交表单，验证密保以及写入新密码
			$.ajax({
				url:"ChangePwd.action",
				method:"post",
				data:{
					formUserName:$("#FindFormUserName").val(),
					formAnswer:$("#FindFormAnswer").val(),
					formNewPwd:$("#FindFormPassWord1").val(),
				},
				success:function(backa){
					var ddddd = backa;
					if(ddddd=="eRanswer"){
						 
						$("#FindFormAnswerinfo").html("密保问题答案错误，亲，再思考一下吧~");
						$("#FindFormUserNameinfo").html("亲~请再次检查一下");
					}
					if(ddddd=="Suanswer"){
						$("#FindFormQuestion").html("" +
								"修改成功！请点击返回<b><a href='MainPart.jsp'>登录页面</a></b>进行登录吧~");
					}
				}
			});
		}
		else{
			$("#FindPwdFormBtninfo").html("错误，亲，再仔细审核一下吧~");
		}
	});
	//用户名失去焦点时 ajax 去获取密保问题
	$("#FindFormUserName").blur(function(){
		var a = $("#FindFormUserName").val();
		$.ajax({
			url:"FindPwd.action",
			method:"post",
			data:{
				findUserName:a,
			},
			success:function(backdata){
				if(backdata=="nonono"){
					$("#FindFormUserNameinfo").html("用户名不存在，请再次检查一下");
					//利用全局变量记录下来，等到提交按钮的时候，可以确保一下是否合理
					IsUserName = false;
				}
				else{
					//记录下来，等到提交按钮的时候，可以确保一下是否合理
					IsUserName = true;
					$("#FindFormQuestion").html(backdata);
				}
			},
		})
	});
	
	
	//修改密码表单的验证
	//要注意bootstrapValidator验证是依靠表单上的name属性的
	$('#FindPwdFormInput').bootstrapValidator({
		live: 'disabled',
        message: '未验证值',
        fields: {/*验证：规则*/
        	FindFormUserName: {//验证input项：验证规则
                message: 'The username is not valid',
               
                validators: {
                    notEmpty: {//非空验证：提示消息
                       message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 20,
                        message: '用户名长度必须在6到20之间'
                    }
                }
            },
            //密保----Jayant.xu
            FindFormAnswer: {
                message:'密保不能为空',
                validators: {
                    notEmpty: {
                        message: '密保不能为空'
                    },
                    stringLength: {
                        max: 200,
                        message: '密保长度保持在200以内'
                    },
                }
            },
            //第一次输入的密码
            FindFormPassWord1: {
                message:'密码不能为空',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 20,
                        message: '用户名长度必须在6到20之间'
                    },
                }
            },
            //确认密码
            FindFormPassWord2: {
                message:'密码不能为空',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 20,
                        message: '用户名长度必须在6到20之间'
                    },
                    identical: {//两次密码输入要相同
                        field: 'FindFormPassWord1',//需要进行比较的input name值
                        message: '两次密码输入要相同'
                    }
                }
            },
        }
    });
	
	
});