package com.appserver.common.network;

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
	
}
