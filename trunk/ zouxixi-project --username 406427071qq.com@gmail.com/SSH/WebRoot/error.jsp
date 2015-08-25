<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>出错啦</title>
	</head>
	<body>
		系统出错啦，请联系系统管理员。<br>
		错误信息:
		<s:property value="exception"/>
		<%@include file="footer.jsp"%>
		<s:debug></s:debug>
	</body>
</html>