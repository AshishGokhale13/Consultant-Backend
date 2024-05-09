package com.mbpatil.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import com.mbpatil.validators.IsValidValue;

import jakarta.validation.ConstraintValidator;

public class CustomConstraintValidatorFactory extends SpringConstraintValidatorFactory {
    
    public CustomConstraintValidatorFactory(AutowireCapableBeanFactory beanFactory) {
		super(beanFactory);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        if (key == IsValidValue.class) {
            return (T) new IsValidValue();
        }
        return super.getInstance(key);
    }
}
