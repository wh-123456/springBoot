/**
 * 
 */
/**
 * 
 */
function pushData() {
	var sellId = $("input[name=sellId]").val();
	var sellDate = $("input[name=sellDate]").val();
	var productName = $("input[name=productName]").val();
	var customerName = $("input[name=customerName]").val();
	var sellNumber = $("input[name=sellNumber]").val();
	var totalMoney = $("input[name=totalMoney]").val();
	var orderId = $("input[name=orderId]").val();
	var settlementWay = $("[name=settlementWay]").val();
	var label = document.getElementById("sellStatus");
	var sellStatus = label.innerText.trim();
	var handlerName = $("input[name=handlerName]").val();
	var Operator = $("input[name=Operator]").val();
	$.ajax({
		url : "http://localhost:8080/crm/PSell/sellAdd",
		type : "get",
		data : {
			sellId : sellId,
			sellDate : sellDate,
			productName : productName,
			customerName : customerName,
			sellNumber : sellNumber,
			orderId : orderId,
			totalMoney : totalMoney,
			settlementWay : settlementWay,
			handlerName : handlerName,
			Operator : Operator,
			sellStatus : sellStatus
		},
		success : function(data) {
			window.location.href = "http://localhost:8080/crm/PSell/sellList";
		},
		error : function(data) {

		}
	})
}

$(function() {
	// $("[name=add]").bind("click", function() {
	//
	// /* $("h4").text("修改客户信息"); */
	// $("[name=userId]").val("");
	// $("[name=username]").val("");
	// $("[name=account]").val("");
	// $("[name=password]").val("");
	// $("[name=roleId]").val("");
	//			
	// })

	$("[name=update]").bind("click", function() {
		// 爬取所需要的数据
		var sellId = $(this).parents("tr").find("#sellId").text();
		var productName = $(this).parents("tr").find("#productName").text();
		var customerName = $(this).parents("tr").find("#customerName").text();
		var sellNumber = $(this).parents("tr").find("#sellNumber").text();
		var sellDate = $(this).parents("tr").find("#sellDate").text();
		var sellStatus = $(this).parents("tr").find("#sellStatus").text();
		var status = $(this).parents("tr").find("#status").text();
		alert("getid" + sellId)
		$.ajax({
			url : "http://localhost:8080/crm/PSell/sellInfoDetail",
			type : "GET",
			// contentType:'application/json;charset=utf-8',
			data : {
				sellId : sellId
			},
			success : function(sellInfo) {
				// var jsonData = JSON.parse(sellInfo);
				var jsonData = sellInfo;
				var orderId = jsonData.orderId;
				alert(orderId);
			},
			error : function(data) {

			}
		});

		$("h4").text("修改客户信息");
		$("input[name=sellId2]").val(sellId);
		$("input[name=productName2]").val(productName);
		$("input[name=customerName2]").val(customerName);
		$("input[name=sellNumber2]").val(sellNumber);
		$("input[name=sellDate2]").val(sellDate);
		$("input[name=sellStatus2]").val(sellStatus);
		$("input[name=status2]").val(status);
	})

})
