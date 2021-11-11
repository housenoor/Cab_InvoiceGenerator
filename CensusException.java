package com.bridgelabz;

public class CensusException extends Exception {

	Message messageValue;

	public enum Message {
		IMPROPER_FILE_NAME, IMPROPER_FILE_TYPE, IMPROPER_DELIMITER, IMPROPER_HEADER
	}

	public CensusException(String message, Message messageValue) {
		super(message);
		this.messageValue = messageValue;
	}
}