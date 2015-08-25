function validate(){
	return true;
	var file1=$("#file1")[0];
	var filePath1=$.trim(file1.value);
	
	var file2=$("#file2")[0];
	var filePath2=$.trim(file2.value);
	
	if(filePath1=="" && filePath2==""){
		alert("请先选择要上传的文件，至少要选择一个文件！");
		file1.focus();
		return false;
	}
	return true;
}