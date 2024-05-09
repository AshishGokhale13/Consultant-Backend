package com.mbpatil.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mbpatil.validators.IsValidValue;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy =IsValidValue.class )



public @interface IsValid {
	
		
	 	Class<?>[] groups() default {}; // Validation groups
	    
	 	Class<? extends Payload>[] payload() default {}; // Payload type for the constraint
	   
	 	Class<?> type();
	    
	 	double min() default -1;
	    
	 	double max() default -1;
	    
	 	double minLength() default -1;
	    
	 	double maxLength() default -1;
	    
	    String message() default "Invalid Field";
}
