/**
 * 头部登录时表单验证
 */
//参考文档：https://www.cnblogs.com/v-weiwang/p/4834672.html?ptvd



	
$(document).ready(function() {
	
	var SessUSERNAME = $("#SessionUSERNAME").val();
	var SessPWDSTATE = $("#SessionPWDSTATE").val();
	var SessISMG = $("#SessionISMG").val();
	//判断验证用户性质，进行自动登录
	if(SessPWDSTATE=="0"){
		if(SessISMG=="1"){
			//隐藏登录按钮
			$("#MyUserNameBtn").hide();
			$("#MyHomeDiv").show();
			//显示编辑按钮
			$("#RightTopcontent-edit").show();
			$("#MyHomeText").html("欢迎管理员 : " + SessUSERNAME);
		}
		else{
			$("#MyUserNameBtn").hide();
			$("#MyHomeDiv").show();
			$("#MyHomeText").html("欢迎您, 用户 : " + SessUSERNAME);
		}
	}
	
	
	//手动触发表单，并且若成功Ajax提交到 登录  action
	$("#loginbutton").click(function(){
		$("#LoginInputForm").data("bootstrapValidator").validate();
		var flag = $("#LoginInputForm").data("bootstrapValidator").isValid();
		if(flag==true){
			$.ajax({
				url:"Login.action",
				method:'post',
				datatype:'text',
				data:{
					loginInputUserName:$("#LoginInputForm").find("#loginInputUserName").val(),
					loginInputPassword:$("#LoginInputForm").find("#loginInputPassword").val(),
				},
				success:function(json){
					/*根据后台
					 * return 0:成功-用户名也存在/return 1:用户名不存在/return 2:密码错误 /return -1:异常情况/
					 * 数据库IsMG: 1是管理员---0不是管理员
					*/
					var jsonObj = JSON.parse(json);
					var UserName = jsonObj.UserName;//用户名
					var pwdstate = jsonObj.pwdstate;//密码状态
					var IsMG = jsonObj.IsMG;//是否管理员
					var Userstate = jsonObj.Userstate;//用户账号状态*异常?
					if(Userstate==-1){
						$("#loginInputUserNameInfo").html("账户状态异常!");
					}
					if(Userstate==1){
						$("#loginInputUserNameInfo").html("用户账号不存在!");
					}
					if(Userstate==0){
						if(pwdstate==2){
							$("#loginInputPasswordInfo").html("用户密码错误!");
						}
						if(pwdstate==0){
							if(IsMG==1){
								$("#exampleModal").modal('hide');
								$("#MyUserNameBtn").hide();
								$("#MyHomeDiv").show();
								//显示编辑按钮
								$("#RightTopcontent-edit").show();
								$("#MyHomeText").html("欢迎管理员 : " + UserName);
							}
							else{
								$("#exampleModal").modal('hide');
								$("#MyUserNameBtn").hide();
								$("#MyHomeDiv").show();
								$("#MyHomeText").html("欢迎您, 用户 : " + UserName);
							}
						}
					}
				},
			})
		}
		else{
			
		}
	});
	
	//表单的有效性验证！
	$('#LoginInputForm').bootstrapValidator({
		live: 'disabled',
        message: '未验证值',
        fields: {/*验证：规则*/
       	 loginInputUserName: {//验证input项：验证规则
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
            //键值名要用name属性/id亲测无效----Jayant.xu
            loginInputPassword: {
                message:'密码无效',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 20,
                        message: '用户名长度必须在6到20之间'
                    },
                    different: {//不能和用户名相同
                        field: 'loginInputUserName',//需要进行比较的input name值
                        message: '不能和用户名相同'
                    }
                }
            },
            loginInputCheck:{
           	 message:'请同意本站用户协议',
           	 validators:{
           		notEmpty:{
           			message:'请同意本站用户协议,详情可点击查看！'
           		}, 
           	 }
            },
        }
    });
	
	
	//退出登录的按钮***实现退出登录
	$("#exitLogin").click(function(){
		$.ajax({
			url:"exitLogin.action",
			success:function(backdate){
				if(backdate=="1"){
					location.reload(true);
				}
			}
		});
	});
		
});    
   





     
