package com.hcl.project.careerguidance.exception;

/*
 * This exception class is used for the Career Guidance user input data validation.
 */
public class InvalidInputDataException extends RuntimeException {

	/**
	 * Unique serial Version UID
	 */
	private static final long serialVersionUID = -8116887393263793600L;

	public InvalidInputDataException(String msg) {
		super(msg);
	}

}
