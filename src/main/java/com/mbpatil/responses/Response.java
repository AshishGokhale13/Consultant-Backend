package com.mbpatil.responses;

import java.util.HashMap;


public class Response implements ResponseConstant {

	
	
	public static HashMap<String, Object> success(int statusObj,String messageObj,Object obj)
	{
	
		HashMap<String, Object> successObj=new HashMap<>();
		successObj.put(statusCode, statusObj);
		successObj.put(data, obj);
		successObj.put(Status,Success);
		successObj.put(message, messageObj);
		return successObj;
	
	}
	public static HashMap<String, Object> error(int statusObj,String messageObj,Object obj)
	{
		
		HashMap<String, Object> successObj=new HashMap<>();
		successObj.put(error, statusObj);
		successObj.put(data, obj);
		successObj.put(Status,error);
		successObj.put(message, messageObj);
		return successObj;
		
	}
}
