package com.mbpatil.validators;

import org.springframework.stereotype.Service;

import com.mbpatil.annotations.IsValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



@Service
public class IsValidValue implements ConstraintValidator<IsValid, Object> {

    private Class<?> type;
    private double min;
    private double max;
    private double maxLength;
    private double minLength;

    @Override
    public void initialize(IsValid constraintAnnotation) {
        this.type = constraintAnnotation.type();
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.maxLength=constraintAnnotation.maxLength();
        this.minLength=constraintAnnotation.maxLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
    	   	
    	
    	System.out.println("Hello");
   
    	if (value == null)
            return false;

        if (!type.isInstance(value)) {
            return false;
        }

        if (type.equals(String.class)) {
            String userValue = (String) value;
            
            
           return  checkMinMaxLength(userValue.length());
        } else if (type.equals(Integer.class)) {
            Integer userValue = (Integer) value;
            return  checkMinMaxLength(Integer.toString(userValue).length());
        } else if (type.equals(Double.class)) {
            Double userValue = (Double) value;
            return checkMinMaxLength(Double.toString(userValue).length());
        } 
        else if (type.equals(Long.class)) {
            Long userValue = (Long) value;
            return checkMinMaxLength(Long.toString(userValue).length());
        }
        else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

   
    private boolean checkMinMaxLength(double obj) {
    	maxLength=maxLength==-1?obj:maxLength; 
    	minLength=minLength==-1?obj:minLength; 
    	
        return obj >= minLength && obj <= maxLength;
    }
}
