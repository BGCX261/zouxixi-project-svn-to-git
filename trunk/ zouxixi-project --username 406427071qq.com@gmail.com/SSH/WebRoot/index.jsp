<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>SSH</title>
	</head>

	<body>
		<%@ include file="navigation.jsp"%>
		<h2>
			功能示例
		</h2>
		<hr />
		<ol>
			<li>
				<a href="upload.jsp" target="_blank">使用Strust2实现请求分发，文件上传及国际化的功能</a>
			</li>
			<li>
				<a href="user-register.jsp" target="_blank">Hibernate对数据库中User表的增删改查，记录分页、排序功能</a>
			</li>
			<li>
				<a>使用Spring实现依赖注入，数据库事务管理的功能</a>
			</li>
			<li>
				<a href="ajaxDemo.jsp" target="_blank">使用JQuery从客户端发送Ajax请求，服务器端响应的功能</a>
			</li>
			<li>
				<a href="user-gotoFirstPage" target="_blank">使用ehcache缓存实体对象的功能</a>
			</li>
			<li>
				<a>使用dbcp连接池连接oracle或Mysql数据库功能</a>
			</li>
			<li>
				<a>使用JUnit实现项目单元测试的功能</a>
			</li>
		</ol>
		<%@include file="footer.jsp"%>
	</body>
</html>
