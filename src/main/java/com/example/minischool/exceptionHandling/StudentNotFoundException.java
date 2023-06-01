package com.example.minischool.exceptionHandling;

public class StudentNotFoundException extends Exception {

	public StudentNotFoundException() {  
	    super();  
	    }  
	
	public StudentNotFoundException(String message) {  
	    super(message);  
	    }  
	
	public StudentNotFoundException(String message, Throwable cause) {  
	    super(message, cause);  
	    }  
	
	public StudentNotFoundException(Throwable cause) {  
	    super(cause);  
	    }  
	
	protected StudentNotFoundException(String Message, Throwable cause,boolean enableSuppression ,boolean writableStackTrace ) {  
	    super(Message, cause, enableSuppression, writableStackTrace);  
	    }
}
