package com.potegd.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.potegd.model.User;

public interface IUserDao {

	public abstract void save(User user);

	public abstract void deleteByid(int id);

	public abstract void update(User user);

	public abstract Long getCount();

	public abstract List<User> listByPage(int offset, int pageSize);

	public abstract List<User> listByPageSort(String orderBy, String order,
			int offset, int pageSize);

	public abstract List<User> listAll();

	public abstract User getUserById(int id);

	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);

}