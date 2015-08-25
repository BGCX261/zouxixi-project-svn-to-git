<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="JavaScript/upload.js"></script>
		<script type="text/javascript" src="JavaScript/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="JavaScript/common.js"></script>
		<title>上传文件</title>
	</head>
	<body>
		<h2>
			多个文件上传与国际化
		</h2>
		<hr />
		<table>
			<!-- 上传文件表单定义 -->
			<s:form action="upload" namespace="/" method="post"
				enctype="multipart/form-data">
				<tr>
					<!-- 上传文件标签定义 -->
					<td>
						<s:property value="%{getText('TheFirstFile')}"></s:property>
						<s:file id="file1" name="file"></s:file>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<s:property value="%{getText('TheSecondFile')}"></s:property>
						<s:file id="file2" name="file"></s:file>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td align="left">
						<s:submit name="submit" value="%{getText('UploadButtonLable')}" onclick="return validate();"></s:submit>
					</td>
					<td>
						<s:property value="fieldErrors.file[0]"></s:property>
					</td>
				</tr>
			</s:form>
		</table>
		<%@include file="footer.jsp"%>
		<s:debug></s:debug>
	</body>
</html>