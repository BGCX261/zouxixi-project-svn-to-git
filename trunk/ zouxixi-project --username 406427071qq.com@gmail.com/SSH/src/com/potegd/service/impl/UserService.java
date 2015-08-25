package com.potegd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.potegd.dao.IUserDao;
import com.potegd.model.User;

@Component
public class UserService {

	private IUserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void add(User user) {
		userDao.save(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(int userId) {
		userDao.deleteByid(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(User user) {
		userDao.update(user);
	}

	public User getById(int userId) {
		return userDao.getUserById(userId);
	}

	public List<User> listByPage(int offset, int pageSize) {
		return userDao.listByPage(offset, pageSize);
	}
	
	/*
	 * param:orderyBy,User类要排序某个的属性名称，ordery升序时为ASC，降序为DESC。
	 * 对数据库中User记录进行分页排序。
	 */
	public List<User> listByPageSort(String orderBy, String order,
			int offset, int pageSize) {
		return userDao.listByPageSort(orderBy,order,offset, pageSize);
	}
	
	public List<User> listAll() {
		return userDao.listAll();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource(name="userDaoUseCache")
	//@Resource(name="userDao")
	public void setUserDAO(IUserDao userDao) {
		this.userDao = userDao;
	}

	public Long getRowCount() {
		return userDao.getCount();
	}

}
