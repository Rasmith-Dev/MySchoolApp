package com.example.minischool.exceptionHandling;

public class CourseNotFoundException extends Exception {
	
	public CourseNotFoundException() {  
	    super();  
	    }

	public CourseNotFoundException(String message) {  
	    super(message);  
	    }

	public CourseNotFoundException(String message, Throwable cause) {  
	    super(message, cause);  
	    }

	public CourseNotFoundException(Throwable cause) {  
	    super(cause);  
	    }

	protected CourseNotFoundException(String Message, Throwable cause,boolean enableSuppression ,boolean writableStackTrace ) {  
	    super(Message, cause, enableSuppression, writableStackTrace);  
	    }
}
