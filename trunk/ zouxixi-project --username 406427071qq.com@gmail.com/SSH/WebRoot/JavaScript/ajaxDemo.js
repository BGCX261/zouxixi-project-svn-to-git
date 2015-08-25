$(document).ready(function() {
	
	$("#ajax_getText").bind("click", function() {
		$.ajax( {
			type : "post",
			url : "ajax-getText.action",
			data : {
				name : "邹喜喜",
			},
			success : function(data) {
				alert(data);
			},
			dataType : "text"
		})
	})
	
	$("#ajax_getJson").bind("click", function() {
		$.ajax( {
			type : "post",
			url : "ajax-getJson.action",
			data : {
				name : "邹喜喜",
			},
			success : function(data) {
				alert("服务器发来的Json格式数据:"+data.name);
			},
			dataType : "json"
		})
	})
	
	$("#main").bind("change", function() {
		$.ajax( {
			type : "post",
			url : "ajax-getHtml.action",
			data : {
				mainValue : this.value,
			},
			success : function(data) {
				$("#sub").html(data);
			},
			dataType : "html"
		})
	})

});