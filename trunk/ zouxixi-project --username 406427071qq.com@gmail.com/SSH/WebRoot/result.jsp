<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>上传结果</title>
	</head>
	<body>
		成功上传文件：
		<!-- 显示上传成功文件名 -->
		<s:property value="fileFileName" />
		<%@include file="footer.jsp"%>
	</body>
</html>