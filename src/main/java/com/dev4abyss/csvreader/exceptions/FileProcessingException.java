package com.dev4abyss.csvreader.exceptions;

public class FileProcessingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileProcessingException(String msg) {
		super(msg);
	}

	public FileProcessingException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
