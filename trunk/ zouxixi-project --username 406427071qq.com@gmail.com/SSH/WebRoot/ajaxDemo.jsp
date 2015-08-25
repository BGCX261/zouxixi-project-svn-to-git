<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>AJAX</title>

		<script type="text/javascript" src="JavaScript/common.js"></script>
		<script type="text/javascript" src="JavaScript/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="JavaScript/ajaxDemo.js"></script>

		<base href="<%=basePath%>"/>
	</head>
	<body>
		<h2>
			JQuery Ajax功能
		</h2>
		<hr />
		<table>
			<tr>
				<td>
					<input type="button" id="ajax_getText" name="ajax_getText"
						value="getText"/>
				</td>
				<td>
					<input type="button" id="ajax_getJson" name="ajax_getJson"
						value="getJson"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<select id="main" name="name">
						<option value="-1">
							请选择主
						</option>
						<option value="a">
							a
						</option>
						<option value="b">
							b
						</option>
						<option value="c">
							c
						</option>
						<option value="d">
							d
						</option>
					</select>
				</td>
				<td>
					<select id="sub" name="sub">
						<option value="-1">
							请选择次
						</option>
					</select>
				</td>
				<td></td>
			</tr>
		</table>
		<%@include file="footer.jsp"%>
	</body>
</html>