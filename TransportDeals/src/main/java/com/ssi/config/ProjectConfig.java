package com.ssi.config;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ssi")
public class ProjectConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Register resource handler for images
		registry.addResourceHandler("/images/**").addResourceLocations(
				"/WEB-INF/images/");

		registry.addResourceHandler("/css/**").addResourceLocations(
				"/WEB-INF/css/");


	}

	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	

	/*
	 * @Bean public InternalResourceViewResolver viewResolver() {
	 * InternalResourceViewResolver viewResolver=new
	 * InternalResourceViewResolver(); viewResolver.setSuffix(".jsp");
	 * viewResolver.setPrefix("/WEB-INF/views/"); return viewResolver; }
	 */

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.ssi.entities");
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
	}

	@Bean
	public ComboPooledDataSource myDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/trdata");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		} catch (Exception e) {
		}
		return dataSource;
	}

}
