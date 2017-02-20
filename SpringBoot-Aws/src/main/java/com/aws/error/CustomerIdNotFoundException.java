package com.aws.error;


public class CustomerIdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1019486274998152366L;
	//private static String message = "cusomer id not found";
	public CustomerIdNotFoundException(String message)
	{
		super(message);
	}
}
