package org.jg.demo;

import org.apache.ibatis.session.SqlSession;
import org.jg.demo.dao.TestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Value("${version}")
	private String version;
	
	@Autowired
	private SqlSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		// logger.info("Welcome home! The client locale is {}.", locale);
		
		TestDao tdao = session.getMapper(TestDao.class); 
		
		System.out.println(version);
		System.out.println(tdao.test());
		
		return "home";
	}
	
}
