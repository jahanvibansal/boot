/*package com.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


//web.xml is not needed. To load spring context loader automatically
public class MyWebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MySpringConfig.class);
		// Manage the lifecycle of the root application context
		context.addListener(new ContextLoaderListener(ctx));
	//	ctx.setServletContext(context);
		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}

}
*/