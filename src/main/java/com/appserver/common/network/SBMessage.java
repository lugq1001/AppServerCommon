package com.appserver.common.network;

import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 网络请求消息包装类
 * @author Luguangqing
 *
 */
public class SBMessage {

	private static Logger logger = LogManager.getLogger(SBMessage.class);
	
	/**
	 * MessageID
	 */
	private int req_id = 0;
	
	/**
	 * json格式参数
	 */
	private String req_data = "";
	
	/**
	 * 用户sid
	 */
	private String req_uid = "";
	
	/**
	 * 上传文件
	 */
	private ArrayList<SBMessageFile> files = new ArrayList<SBMessageFile>();
	
	private SBMessageType type = SBMessageType.Http;
	
	private HttpServletResponse resp;
	
	public SBMessage(HttpServletResponse resp) {
		this.resp = resp;
		this.type = SBMessageType.Http;
	}
	
	/*===================== Method =====================*/

	public void send(String result) {
		try {
			switch (type) {
			case Http:
				resp.getWriter().write(result);
				break;
			case WebSocket:
				break;
			}
			logger.debug("resp json:" + result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
		}
	}
	
	/*===================== GetterSetter =====================*/
	
	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public String getReq_data() {
		return req_data;
	}

	public void setReq_data(String req_data) {
		this.req_data = req_data;
	}

	public ArrayList<SBMessageFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<SBMessageFile> files) {
		this.files = files;
	}

	public String getReq_uid() {
		return req_uid;
	}

	public void setReq_uid(String req_uid) {
		this.req_uid = req_uid;
	}

	public SBMessageType getType() {
		return type;
	}

}
