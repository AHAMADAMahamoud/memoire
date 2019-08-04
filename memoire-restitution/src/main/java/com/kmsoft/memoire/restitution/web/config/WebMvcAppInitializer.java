package com.kmsoft.memoire.restitution.web.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WEB application initializer (replace web.xml)
 */
public class WebMvcAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Constructor
	 *
	 */
	public WebMvcAppInitializer() {
	}

	@Override
	protected void registerDispatcherServlet(final ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);

		servletContext.addListener(new RequestContextListener());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebMvcAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new CORSFilter() };
	}
}
