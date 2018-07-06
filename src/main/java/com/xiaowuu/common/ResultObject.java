package com.xiaowuu.common;

/**
 * <p>Description: 传输JSON对象</p>
 */
public class ResultObject<T> {
	
	/**
	 * 成功标志
	 */
	private boolean success;
	
	/**
	 * 失败消息
	 */
	private String message;
	
	/**
	 * 时间撮
	 */
	private long dateline = System.currentTimeMillis();
	
	/**
	 * 结果对象
	 */
	private T result;

	private Integer code;
	
	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getDateline() {
		return dateline;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public void setDateline(long dateline) {
		this.dateline = dateline;
	}
}
