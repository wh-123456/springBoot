/**
 * 
 */
function pushData() {
			var userId = $("input[name=userId]").val();
			var username = $("input[name=username]").val();
			var account = $("input[name=account]").val();
			var password = $("input[name=password]").val();
			var roleId = $("[name=roleId]").val();
			$.ajax({
						url : "http://localhost:8080/crm/PSell/sellAdd",
						type : "get",
						data : {
							username : username,
							account : account,
							password : password,
							roleId : roleId
						},
						success : function(data) {
							window.location.href = "http://localhost:8080/crm/system/userList";
						},
						error : function(data) {

						}
					})

		}

function editData() {
	var userId = $("input[name=userId2]").val();
	var username = $("input[name=username2]").val();
	var account = $("input[name=account2]").val();
	var roleId = $("[name=roleId2]").val();
	$.ajax({
				url : "http://localhost:8080/crm/system/userEidt",
				type : "get",
				data : {
					userId :userId,
					username : username,
					account : account,
					roleId : roleId
				},
				success : function(data) {
					window.location.href = "http://localhost:8080/crm/system/userList";
				},
				error : function(data) {

				}
			})

}

//批量删除
function DelSelect() {
	var Checkbox = false;
	$("input[name=userId3]").each(function() {
		if (this.checked == true) {
			Checkbox = true;
		}
	});
	if (Checkbox) {
		var t = confirm("您确认要删除选中的内容吗？");
		if (t == false){ 
			return false;
		}
		//发送ajax请求，批量删除
		//取得选中的id
		//定义一个数组，用于接收选中行的id
		var userIdArray=new Array();
		
		$("input[name=userId3]").each(function(){
			
			if (this.checked) {
				//alert($(this).val());
				userIdArray.push($(this).val());
			} 
		});
	
		//发送ajax请求
		$.ajax({
		url:"http://localhost:8080/crm/system/userDeleBatch",
		type:"POST",
		traditional : true,
		data:{"userArry":userIdArray},
		dataType:"text",
		success:function(data){
			if(data=="1"){
				alert("删除成功！");
				$("input[name=userId3]").each(function(){
					if (this.checked) {
						$(this).parent().parent().remove();
					} 
				});
			}else{
				alert("删除失败！");
			} 
		},
		err:function(data){
			alert("请求失败，稍后再试");
		}
		});
		/* $("#listform").submit(); */
	} else {
		alert("请选择您要删除的内容!");
		return false;
	}
}

//全选
$("#checkall").click(function() {
	$("input[name='userId3']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
})



$(function(){
$("[name=add]").bind("click", function() {

		/* $("h4").text("修改客户信息"); */
		$("[name=userId]").val("");
		$("[name=username]").val("");
		$("[name=account]").val("");
		$("[name=password]").val("");
		$("[name=roleId]").val("");
		
	})

$("[name=update]").bind("click", function() {
		//爬取所需要的数据
		var userId = $(this).parents("tr").find("#userId").text();
		var username = $(this).parents("tr").find("#username").text();
		var account = $(this).parents("tr").find("#account").text();
//		$ajax({
//			url:"http://localhost:8080/crm/system/getRoleName",
//			type:"POST",
//			contentType:'application/json;charset=utf-8',
//			data:{userId:userId},
//			success:function(role_dbList){
//				//遍历role_dbList，如果input框的userI与遍历的相同，添加属性为已选择。条件为先删除再添加
//			},
//			error : function(data) {
//
//			}
//		});
		
		$("h4").text("修改订单信息");
		$("[name=username2]").val(username);
		$("[name=account2]").val(account);
		$("[name=roleId2]").val(roleId);
	})
	
	

})