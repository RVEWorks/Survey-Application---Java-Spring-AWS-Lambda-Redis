package com.sriniworks.survey.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.sriniworks.survey.config.AppConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestConfiguration {

    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void testJedisConnection() {
    	
    		assertNotNull(redisTemplate.opsForHash()) ;
    }
    
    
}
