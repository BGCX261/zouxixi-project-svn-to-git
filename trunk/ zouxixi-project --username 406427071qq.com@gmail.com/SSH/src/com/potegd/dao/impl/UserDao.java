package com.potegd.dao.impl;

import java.util.List;
import javax.annotation.Resource;

//import org.hibernate.Criteria;
//import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.potegd.dao.IUserDao;
import com.potegd.model.User;

@Component
public class UserDao implements IUserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	public void deleteByid(int id) {
		User user = new User();
		user.setId(id);
		hibernateTemplate.delete(user);
	}

	public void update(User user) {
		hibernateTemplate.update(user);
	}

	public Long getCount() {
		//System.out.println("N");
		final String sql = "select count(*) from User";
		return (Long) hibernateTemplate.find(sql).get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listByPage(int offset, int pageSize) {
		return (List<User>) hibernateTemplate.findByExample(new User(), offset,pageSize);
	}

	@SuppressWarnings("unchecked")
	public List<User> listByPageSort(String orderBy, String order,
			int offset, int pageSize) {
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		//dc.add(Restrictions.ge("age",2));//筛选条件。
		if("ASC".equals(order)){
			dc.addOrder(Order.asc(orderBy));
		}else{
			dc.addOrder(Order.desc(orderBy));
		}
		return (List<User>) hibernateTemplate.findByCriteria(dc,offset,pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listAll() {
		return (List<User>)hibernateTemplate.find("from User");
	}

	public User getUserById(int id) {
		return (User)hibernateTemplate.get(User.class, id);
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
		this.hibernateTemplate.setCacheQueries(false);
	}

}
