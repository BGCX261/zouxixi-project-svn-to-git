<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//设置age的下拉列表选项。
	java.util.List<Integer> ages = new java.util.ArrayList<Integer>();
	for (int i = 10; i <= 80; i++) {
		ages.add(i);
	}
	request.setAttribute("map", ages);
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		<script type="text/javascript" src="JavaScript/common.js"></script>
		<script type="text/javascript" src="JavaScript/jquery-1.6.2.min.js"></script>
		<sx:head />
		<base href="<%=basePath%>" />
	</head>
	<body>
		<h2>
			注册页面
		</h2>
		<hr />
		<s:form action="user-register" namespace="/" method="post">
			<table>
				<tr>
					<td>
						姓名:*
					</td>
					<td>
						<s:textfield id="name" name="name"></s:textfield>
					</td>
					<td>
						<s:property value="fieldErrors.name[0]"></s:property>
					</td>
				</tr>
				<tr>
					<td>
						年龄:*
					</td>
					<td>
						<s:select name="age" list="#request.map" headerKey="-1"
							headerValue="---- 请选择 ----" />
					</td>
					<td>
						<s:property value="fieldErrors.age[0]"></s:property>
					</td>
				</tr>
				<tr>
					<td>
						生日:*
					</td>
					<td>
						<sx:datetimepicker id="birthday" name="birthday"
							displayFormat="yyyy-MM-dd"></sx:datetimepicker>
					</td>
					<td>
						<s:property value="fieldErrors.birthday[0]"></s:property>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit></s:submit>
					</td>
					<td>
						<s:reset></s:reset>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>
					</td>
					<td></td>
				</tr>
			</table>
		</s:form>
		<%@include file="footer.jsp"%>
		<s:debug></s:debug>
	</body>
</html>