package com.potegd.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("ajaxAction")
@Scope("prototype")
public class AjaxAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response=ServletActionContext.getResponse();
	private HttpServletRequest request;

	public void getText() throws Exception {
		System.out.println("Ajax请求已执行!");
		System.out.println("客户端Jquery Ajax发来的参数name="+request.getParameter("name"));
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter=response.getWriter();
		printWriter.write("你好!这是向服务器端发送Ajax请求后服务器返回的信息。");
		printWriter.flush();
	}
	
	public void getHtml() throws Exception {
		System.out.println("客户端Jquery Ajax发来的参数mainValue1="+request.getParameter("mainValue"));
		response.setCharacterEncoding("UTF-8");
		String mainValue=request.getParameter("mainValue");
		PrintWriter printWriter=response.getWriter();
		StringBuilder html=new StringBuilder();
		html.append("<option value='-1'>请选择</option>");
		if("a".equals(mainValue)){
			html.append("<option value='");
			html.append("a");
			html.append("'>");
			html.append("aa");
			html.append("</option>");
		}else if("b".equals(mainValue)){
			html.append("<option value='");
			html.append("b");
			html.append("'>");
			html.append("bb");
			html.append("</option>");
		}
		printWriter.write(html.toString());
		printWriter.flush();
	}

	public void getJson() throws Exception {
		System.out.println("客户端Jquery Ajax发来的参数mainValue2="+request.getParameter("name"));
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter=response.getWriter();
		StringBuilder html=new StringBuilder();
		html.append("{\"name\":\"me\"}");
		printWriter.write(html.toString());
		printWriter.flush();
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
