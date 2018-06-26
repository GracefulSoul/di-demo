package yongsik.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import yongsik.springframework.examplebeans.FakeDataSource;
import yongsik.springframework.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
/*@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
})*/
public class PropertyConfig {
	
//	@Autowired
//	Environment env;
	
	@Value("${yskim.username}")
	String user;
	
	@Value("${yskim.password}")
	String password;
	
	@Value("${yskim.dburl}")
	String url;

	@Value("${yskim.jms.username}")
	String jmsUsername;
	
	@Value("${yskim.jms.password}")
	String jmsPassword;
	
	@Value("${yskim.jms.dburl}")
	String jmsUrl;
	
	@Bean
	public FakeDataSource fakeDataSources() {
		FakeDataSource fakeDataSource = new FakeDataSource();
//		fakeDataSource.setUser(env.getProperty("USERNAME"));
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}
	
	@Bean
	public FakeJmsBroker fakeFmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(jmsUsername);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setUrl(jmsUrl);
		return fakeJmsBroker;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
	
}
