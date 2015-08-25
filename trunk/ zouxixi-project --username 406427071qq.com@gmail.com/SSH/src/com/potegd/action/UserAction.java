package com.potegd.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.potegd.model.User;
import com.potegd.service.impl.UserService;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User user = new User();

	private String orderBy;
	private String order;

	private int pageSize = 10;// 每页多少条记录。
	private int pageCount;// 一共多少页。
	private Long rowCount;// 一共多少条记录。
	private int currentPageNo;// 当前第几页。

	private int userId;// 当前要处理的用户ID。
	private List<User> users = new ArrayList<User>();

	public UserAction() {

	}

	public String register() throws Exception {
		userService.add(user);
		this.gotoFirstPage();
		return SUCCESS;
	}

	public String delete() throws Exception {
		userService.deleteById(userId);
		this.gotoNthPage(currentPageNo);
		return SUCCESS;
	}

	public String update() throws Exception {
		userService.update(user);
		this.gotoFirstPage();
		return SUCCESS;
	}

	public String updateInput() throws Exception {
		this.user = userService.getById(userId);
		System.out.println(2);
		return "updateInput";
	}

	public String listByPage() throws Exception {
		this.rowCount = this.userService.getRowCount();
		if (this.rowCount % this.pageSize == 0) {
			this.pageCount = (int) (this.rowCount / pageSize);
		} else {
			this.pageCount = (int) (this.rowCount / pageSize) + 1;
		}
		int offset = pageSize * (currentPageNo - 1);
		if (orderBy == null) {
			this.users = userService.listByPage(offset, pageSize);
		} else {
			this.users = userService.listByPageSort(orderBy, order, offset,
					pageSize);
		}
		return SUCCESS;
	}

	public String listAll() throws Exception {
		this.users = userService.listAll();
		return "listAll";
	}

	public String gotoFirstPage() throws Exception {
		this.currentPageNo = 1;
		this.listByPage();
		return SUCCESS;
	}

	public String gotoLastPage() throws Exception {
		this.currentPageNo = this.pageCount;
		this.listByPage();
		return SUCCESS;
	}

	public String gotoNextPage() throws Exception {
		if (this.currentPageNo < pageCount) {
			this.currentPageNo = this.currentPageNo + 1;
		}
		this.listByPage();
		return SUCCESS;
	}

	public String gotoPrePage() throws Exception {
		if (this.currentPageNo > 1) {
			this.currentPageNo = this.currentPageNo - 1;
		}
		this.listByPage();
		return SUCCESS;
	}

	public String gotoNthPage(int pageNo) throws Exception {
		this.currentPageNo = pageNo;
		this.listByPage();
		return SUCCESS;
	}

	public void validateRegister() {
		if ("".equals(user.getName().trim())) {
			addFieldError("name", "姓名不能为空！");
		}
		if (user.getAge() < 0) {
			addFieldError("age", "请先选择一个年龄！");
		}
		if(user.getBirthday()==null){
			addFieldError("birthday", "请先选择一个出生日期！");
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getModel() {
		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public int getId() {
		return userId;
	}

	public Long getRowCount() {
		return rowCount;
	}

	public void setRowCount(Long rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getOrderyBy() {
		return orderBy;
	}

	public void setOrdery(String ordery) {
		this.order = ordery;
	}

	public String getOrdery() {
		return order;
	}

	public void setOrderyBy(String orderyBy) {
		this.orderBy = orderyBy;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) throws Exception {
		this.currentPageNo = currentPageNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
