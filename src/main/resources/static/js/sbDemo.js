//页面加载时，同步执行
$(document).ready(function(){
	//页面加载时候调用的代码块
	//alert("欢迎来到权限管理系统");
	//页面加载时候调用的js方法
	//test();
	
	//绑定idlogin里的按钮
	$("#loginButton").bind("click",function(){
		var userName=$("[name=userName]").val();
		var password=$("[name=password]").val();
		if(userName==""||password==""){
			alert("Please input name and password")
		}
		alert("你好");
	})
})

function test(){
	alert("12138")
}