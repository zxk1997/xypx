package com.zxk1997.px.user.service;

public interface RedisService {
	
	//设置key的生存时间
	boolean expire(String key, long time);
	
	//根据key获取value
	Object get(String key);
	
	String getByString(String key);
	
	//插入一条kv数据,并设置生存时间
	boolean set(String key, Object value, long time);
	
	boolean set(String key, String value, long time);
	
	//根据key删除一条记录
	void del(String key); 
}
