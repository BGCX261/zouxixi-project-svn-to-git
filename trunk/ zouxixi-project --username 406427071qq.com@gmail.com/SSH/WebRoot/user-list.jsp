<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.potegd.util.*"%>
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
		<title>ListUser</title>
		<link rel="stylesheet" type="text/css" href="CSS/style.css" />
		<link rel="stylesheet" type="text/css" href="CSS/user-list.css" />
		<script type="text/javascript" src="JavaScript/common.js"></script>
		<script type="text/javascript" src="JavaScript/jquery-1.6.2.min.js"></script>
		<sx:head />
		<base href="<%=basePath%>" />
	</head>
	<body>
		<h2>
			用户表记录分页排序
		</h2>
		<hr />
		<table>
			<thead>
				<tr>
					<td>
						<s:url id="url_Sort" value="user-listByPage" >
							<s:param name="currentPageNo" value="currentPageNo"></s:param>
							<s:param name="pageCount" value="pageCount"></s:param>
						</s:url>
						姓名<a style="<s:if test="orderyBy=='name'&&ordery=='ASC'">color:red</s:if>" href="${url_Sort}&orderyBy=name&ordery=ASC">∧</a><a style="<s:if test="orderyBy=='name'&&ordery=='DESC'">color:red</s:if>" href="${url_Sort}&orderyBy=name&ordery=DESC">∨</a>
					</td>
					<td>
						年龄<a style="<s:if test="orderyBy=='age'&&ordery=='ASC'">color:red</s:if>" href="${url_Sort}&orderyBy=age&ordery=ASC">∧</a><a style="<s:if test="orderyBy=='age'&&ordery=='DESC'">color:red</s:if>" href="${url_Sort}&orderyBy=age&ordery=DESC">∨</a>
					</td>
					<td>
						出生日期<a style="<s:if test="orderyBy=='birthday'&&ordery=='ASC'">color:red</s:if>" href="${url_Sort}&orderyBy=birthday&ordery=ASC">∧</a><a style="<s:if test="orderyBy=='birthday'&&ordery=='DESC'">color:red</s:if>" href="${url_Sort}&orderyBy=birthday&ordery=DESC">∨</a>
					</td>
					<td>
						修改
					</td>
					<td>
						删除
					</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="u" value="users" status="status">
					<tr class="<s:if test="#status.odd==true">even</s:if><s:else>odd</s:else>">
						<td>
							<s:property value="name"></s:property>
						</td>
						<td>
							<s:property value="age"></s:property>
						</td>
						<td>
							<s:date name="birthday" format="yyyy-MM-dd HH:mm"/>
							<s:date name="birthday" nice="true"/>
						</td>
						<td>
							<a href="user-updateInput?userId=${id}">修改</a>
						</td>
						<td>
							<a
								href="user-delete?userId=${id}&currentPageNo=${currentPageNo}&pageCount=${pageCount}"
								onclick="return confirm('你确认要删除此条记录？')">删除</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<s:url id="url_page" value="">
							<s:param name="orderyBy" value="orderyBy"></s:param>
							<s:param name="ordery" value="ordery"></s:param>
							<s:param name="currentPageNo" value="currentPageNo"></s:param>
							<s:param name="pageCount" value="pageCount"></s:param>
						</s:url>
						<s:a href="user-gotoFirstPage%{url_page}">首页</s:a>|
						<s:a href="user-gotoPrePage%{url_page}">上一页</s:a>|
						<s:a href="user-gotoNextPage%{url_page}">下一页</s:a>|
						<s:a href="user-gotoLastPage%{url_page}">尾页</s:a>
						&nbsp;&nbsp;
						<s:property value="currentPageNo"></s:property>
						/
						<s:property value="pageCount"></s:property>
					</td>
				</tr>
			</tfoot>
		</table>
		<%@include file="footer.jsp"%>
		<s:debug></s:debug>
	</body>
</html>