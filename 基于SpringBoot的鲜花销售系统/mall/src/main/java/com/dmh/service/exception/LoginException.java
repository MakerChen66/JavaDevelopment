package com.dmh.service.exception;
/**
 * 登入异常设置
 * @author dmh
 * @2019年10月7日下午10:27:44
 */
public class LoginException extends RuntimeException {
	public LoginException() {
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
