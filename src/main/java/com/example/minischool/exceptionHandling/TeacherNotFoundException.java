package com.example.minischool.exceptionHandling;

public class TeacherNotFoundException extends Exception {

	public TeacherNotFoundException() {  
	    super();  
	    }  
	
	public TeacherNotFoundException(String message) {  
	    super(message);  
	    }  
	
	public TeacherNotFoundException(String message, Throwable cause) {  
	    super(message, cause);  
	    }  
	
	public TeacherNotFoundException(Throwable cause) {  
	    super(cause);  
	    }  
	
	protected TeacherNotFoundException(String Message, Throwable cause,boolean enableSuppression ,boolean writableStackTrace ) {  
	    super(Message, cause, enableSuppression, writableStackTrace);  
	    }
	
}
