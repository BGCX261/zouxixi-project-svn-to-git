package com.potegd.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.junit.Test;

public class UserActionTest extends StrutsSpringTestCase {

	@Test
	public void testGetActionMapping() throws Exception {
		ActionMapping mapping = getActionMapping("/userAction.action");
		assertNotNull(mapping);
		assertEquals("/", mapping.getNamespace());
		assertEquals("userAction", mapping.getName());
	}

	@Test
	public void testGotoPrePage() throws Exception {
		request.setParameter("currentPageNo", "2");
		request.setParameter("pageCount", "4");
		String result = executeAction("/user-gotoPrePage");
		System.out.println("result=" + result);
		assertEquals(1, findValueAfterExecute("currentPageNo"));
	}
	
}
