package com.xiaowuu;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//  测试提交代码
		return application.sources(MyBlogApplication.class);
		// return application.sources(MyBlogApplication.class);
	}

}
