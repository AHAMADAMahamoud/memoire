package com.kmsoft.memoire.restitution.web.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("com.kmsoft.memoire")
public class WebMvcAppConfig extends WebMvcConfigurerAdapter {

	private static final String MESSAGES_PATH = "classpath:messages";

	/**
	 * Constructor
	 *
	 */
	public WebMvcAppConfig() {
		super();
	}

	/**
	 * Enable the management of exceptions
	 * 
	 * @param dispatcherServlet
	 *            The Dispatcher servlet
	 */
	@Autowired
	public void configureDispatcher(final DispatcherServlet dispatcherServlet) {
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	}

	/**
	 * Load the I18n properties in UTF-8
	 * 
	 * @return The resource bundle bean
	 */
	@Bean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();

		bean.setBasename(MESSAGES_PATH);
		bean.setDefaultEncoding(StandardCharsets.UTF_8.name());

		return bean;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/ressources/**").addResourceLocations("/ressources/");
	}

	/**
	 * Load Swagger properties
	 * 
	 * @return The property placeholder configurer bean
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer loadProperties() {
		final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();

		return pspc;
	}

	/**
	 * The view resolver (for JSP) le resolveur des ressources JSP
	 * 
	 * @return view resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
