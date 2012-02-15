// 超时则跳到登录页面
$(document).ajaxComplete(function(e, xhr, settings){
	var doc = $(xhr.responseText);
	var f_loginForm = doc.find("form[id='loginForm']");
	if(f_loginForm.length > 0){
		window.location.reload();
	} 
});

registerNamespace("bl_common");

bl_common.allCustomer = function(callback){
	$.ajax({
		url: APP_PATH + "/project/allCustomer.do",
		success: function(data){
			callback.call(window, $(data));
		},
		dataType: 'html'
	});
};

bl_common.projectOfCust = function(customerId, callback){	
	$.ajax({
		url: APP_PATH + "/report/projectToString.do",
		data: {'customerId' : customerId},
		success: function(data){
			callback.call(window, $(data));
		},
		dataType: 'html'
	});
};

