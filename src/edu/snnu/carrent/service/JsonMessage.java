package edu.snnu.carrent.service;

import org.json.simple.JSONObject;

/*
 * json类
 */
public class JsonMessage {

	/**
	 * 错误状态
	 */
	public static final int STATUS_ERROR = 0;
	/**
	 * 成功状态
	 */
	public static final int STATUS_OK = 200;

	/**
	 * 请求状态
	 */
	private int status;
	/**
	 * 状态原因
	 */
	private String message;
	/**
	 * 请求数据内容
	 */
	private String contents;

	public JsonMessage() {
		this.status = 0;
		this.message = null;
		this.contents = null;
	}

	/**
	 * @param status
	 *            状态位，请求成功/失败
	 * @param message
	 *            附带的消息。比如：失败时，失败的原因
	 * @param contents
	 *            请求的数据内容，也是一段json格式的字符串
	 */
	public JsonMessage(int status, String message, String contents) {
		super();
		this.status = status;
		this.message = message;
		this.contents = contents;
	}

	/**
	 * 重写后的toString方法,将返回成json格式的字符串
	 */
	public void toString1() {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", this.status == 200 ? "success" : "error");
		jsonObject.put("message", this.message == null ? "" : this.message);
		jsonObject.put("contents", this.contents == null ? "" : this.contents);
		// return jsonObject.toString();
		System.out.println(jsonObject.toJSONString());
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
