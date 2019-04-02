package com.zxk1997.px.user.service.Impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements com.zxk1997.px.user.service.RedisService {

	private final Logger log=LoggerFactory.getLogger(RedisServiceImpl.class);
	
	@Autowired
	RedisTemplate<String, Object> redis;
	
	@Override
	public boolean expire(String key, long time) {
		try {
			redis.expire(key, time, TimeUnit.SECONDS);
			return true;
		}catch(Exception ex) {
			
			log.error("redis设置生存时间错误："+ex);
		}
		
		return false;
	}

	@Override
	public Object get(String key) {
		return redis.opsForValue().get(key);
	}

	@Override
	public boolean set(String key, Object value, long time) {
		try {
			if(time>0) {
				//有生存时间
				redis.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			}else {
				//不过期
				redis.opsForValue().set(key,value);
			}
			
			return true;
		}catch(Exception ex) {
			log.error("redis插入错误："+ex);
		}
		return false;
	}

	@Override
	public void del(String key) {
		redis.delete(key);
	}

}
