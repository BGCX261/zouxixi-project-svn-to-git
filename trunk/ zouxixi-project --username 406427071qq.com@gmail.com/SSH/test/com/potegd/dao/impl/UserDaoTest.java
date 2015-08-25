package com.potegd.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.potegd.dao.IUserDao;
import com.potegd.model.User;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4  
@ContextConfiguration(locations = {"classpath:/applicationContext.xml" })
public class UserDaoTest extends AbstractJUnit38SpringContextTests{

	private Log log = LogFactory.getLog(UserDaoTest.class);

	private IUserDao userDao;

	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Test
	public void getCountTest() {
		try {
			log.info("getCountTest测试方法开始。");
			Long count= userDao.getCount();
			assertTrue("UserDao类的getCount方法执行不正确。", count>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListByPageSort() {
		try {
			log.info("listByPageSortTest测试方法开始。");
			List<User> users = userDao.listByPageSort("name", "ASC", 20, 10);
			System.out.println("users包含对象个数："+users.size());
			Iterator<User> it = users.iterator();
			while (it.hasNext()) {
				User u = it.next();
				System.out.println("ID=" + u.getId() + "  name=" + u.getName());
			}
			assertEquals("userDao类的ListByPage方法执行不对！", users.size(), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Timed(millis=100)//要求此方法在n毫内执行完。若超过测试不通过。
	@Repeat(20)//重复执行此测试方法n次。
	public void testListByPage() {
		try {
			userDao.listByPage(20, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
