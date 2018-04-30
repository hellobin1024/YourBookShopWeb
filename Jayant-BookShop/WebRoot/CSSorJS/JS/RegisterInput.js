/**
 * 验证注册信息!
 */

	var app = angular.module('app',[]);
	
	
	
	app.controller('RegisterFormInputCtrl',['$scope','$http',function($scope,$http,$timeout) {
		
		
		
		$scope.submitForm=function(isvalid){
			
			if(isvalid){
				if($scope.inputUserPassword2==$scope.inputUserPassword1){
					//密码一致提交ajax请求,Angular封装了Ajax请求
					
					var date ={
							registerUserName:$("#RegisterForm1").find("#inputUserName").val(),
							registerPassWord:$("#RegisterForm1").find("#inputUserPassword1").val(),
							registerUserEmail:$("#RegisterForm1").find("#inputUserEmail").val(),
							registerUserRealName:$("#RegisterForm1").find("#inputUserRealName").val(),
							registerUserProblem:$("#RegisterForm1").find("#inputUserProblem").val(),
							registerUserAnswer:$("#RegisterForm1").find("#inputUserAnswer").val(),
					}
					$.ajax({
						url:"Register.action",
						method:'post',
						datatype:'text',
						data:date,
						success:function(backdata){
							if(backdata=="1"){
								$("#alertinfo").html("注册成功,或请点击" +
										"返回<a href='MainPart.jsp'><b>登录页面</b></a>进行登录!");
								
							}
							else{
								$("#alertinfo").html("用户名已经存在请更换!");
							}
						},
						error:function(backdata){
							alert("错误了,请稍后重试!");
						}
					})
					
				}
				else{
					$scope.samepassword="密码不一致,请修改!";
				}
			}
			else{
				alert("信息填写不全,请重试!");
			}
		}
		
			
	 }]);



