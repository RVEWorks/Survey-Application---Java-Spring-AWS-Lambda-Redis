package com.sriniworks.survey.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.sriniworks.survey.model.Survey;

@Configuration
@ComponentScan("com.sriniworks.survey.repository")
public class AppConfig {

	@Value("${redis.port}")
	private int redisPort;

	@Value("${redis.host}")
	private String redisHost;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ClassPathResource("app-config.yml"));
		propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
		return propertySourcesPlaceholderConfigurer;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		// jedisConFactory.setHostName("localhost");
		// jedisConFactory.setPort(6379);

		jedisConFactory.setHostName(redisHost);
		jedisConFactory.setPort(redisPort);

		return jedisConFactory;
	}


	@Bean(name = "surveyRedisTemplate")
	public RedisTemplate<Survey, Object> surveyRedisTemplate() {
		RedisTemplate<Survey, Object> template = new RedisTemplate<Survey, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}
