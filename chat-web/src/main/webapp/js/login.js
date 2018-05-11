$(function(){
	$("#sss").click(function(){
		var datas = JSON.stringify('{}');
		$.ajax({
			type: "post",
			dataType: "json",
			url:"/test/hello",
			data:'{"data":"{ \\\"email\\\": \\\"'+$("#email").val()+'\\\", \\\"passwoed\\\": \\\"'+$("#password").val()+'\\\" } "}',
			contentType: "application/json;charset=utf-8",
			success: function (data) {
				console.log(JSON.stringify(data));
				window.location.href='index.html';
			},
			error:function(error){
				//出错时回调该函数
				console.log(error);
			}
		})
		//window.location.href='index.html';
	});
});