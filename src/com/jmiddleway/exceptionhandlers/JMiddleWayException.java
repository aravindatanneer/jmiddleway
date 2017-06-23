package com.jmiddleway.exceptionhandlers;

/*
 * Author  : Aravinda
 * Description :JMiddleWay specific application exception
 * Company :  
 */

public class JMiddleWayException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
	 * the developer does not have to look into the response headers. If null a default 
	 */
	Integer status;
	
	/** application specific error code */
	int code; 
		
	/** link documenting the exception */	
	String link;
	
	/** detailed error description for developers*/
	String developerMessage;	
	
	/**
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param developerMessage
	 * @param link
	 */
	public JMiddleWayException(int status, int code, String message,
			String developerMessage, String link) {
		super(message);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
		this.link = link;
	}
	
	public static JMiddleWayException build(int status, int code, String message,
			String developerMessage, String link) {
		
		JMiddleWayException ae = new JMiddleWayException(status,code,message,developerMessage,link);
		return ae;
	}
	
	public JMiddleWayException() { }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
