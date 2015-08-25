package com.potegd.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.potegd.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private Log log = LogFactory.getLog(UserServiceTest.class);
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	@Rollback(true)
	public void getRowCountTest() {
		try {
			User u=new User("name44",22,new Date());
			userService.add(u);
			
			log.info("getCountTest测试方法开始。");
			Long count= userService.getRowCount();
			assertTrue("userService类的getRowCount方法执行不正确。", count>0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListByPage() {
		try{
			List<User> users=userService.listByPage(1,10);
			System.out.println(users.size());
			Iterator<User> it=users.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().getId());
			}
			assertEquals(users.size(),10);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
