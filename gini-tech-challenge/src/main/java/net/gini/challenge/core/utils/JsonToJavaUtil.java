package net.gini.challenge.core.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class contains methods for json to java conversion.
 */
public class JsonToJavaUtil extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(JsonToJavaUtil.class);

	private static JsonToJavaUtil  jsonToJavaUtils;

	/**
	 * Private constructor
	 */
	private JsonToJavaUtil(){

	}

	public static JsonToJavaUtil getInstance(){
		if(null == jsonToJavaUtils){
			jsonToJavaUtils = new JsonToJavaUtil();
		}
		return jsonToJavaUtils;
	}

	/**
	 * Method to convert Json string into Java object
	 * @param jsonString
	 * @param cls
	 * @return
	 * @throws IOException
	 */
	public static <T> T jsonObjectToJavaObject(String jsonString, Class<T> cls) {
		try {
			return getInstance().readValue(jsonString, cls);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
