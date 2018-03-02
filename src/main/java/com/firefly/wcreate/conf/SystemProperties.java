package com.firefly.wcreate.conf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * firefly system parameter configuration...
 * 
 * @author zhengchenglei
 *
 */
public class SystemProperties {
	
	
	private final static Map<String,Object> setting = new ConcurrentHashMap<String, Object>();
	
	
	
	public static void put(String k,Object v){
		setting.put(k, v);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String k,Class<T> clazz){
		
		return (T)setting.get(k);
	}
	
	
	public static enum resource{
		
		PORT("port","The port of application"),
		VIRDIR("vir.dir","the directory of virtual application"),
		APPDIR("app.dir","the directory of application"),
		AJP("AJP","AJP protocol"),
		HTTP("HTTP","HTTP protocol");
		
		private String value;
		
		private String comment;
		
		resource(String value,String comment){
			this.value = value;
			this.comment = comment;
		}

		public String getValue() {
			return value;
		}

		public String getComment() {
			return comment;
		}
		
		
	}

}
