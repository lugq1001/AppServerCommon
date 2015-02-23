package com.appserver.common.network;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 接口响应类
 * @author Luguangqing
 *
 */
public class BaseResponse {

	public int reqid = -1;
	
	public int retCode = -1;
	
	public String retMsg = "";
	
	public BaseResponse(int retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	
	public static String errorResp(int retCode, String retMsg) {
		String result = "";
		BaseResponse resp = new BaseResponse(retCode, retMsg);
		ObjectMapper mapper = new ObjectMapper();
		try {
			result = mapper.writeValueAsString(resp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
