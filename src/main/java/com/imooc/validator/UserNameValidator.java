package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 注意：该类可以注入spring初始化的bean，而不需要在类上注明@Component注解
 * spring看到这个类实现了ConstraintValidator会自动的注入bean
 * @author xiangwj
 *
 */
public class UserNameValidator implements ConstraintValidator<UserNameConstraint, Object> {

	@Override
	public void initialize(UserNameConstraint constraintAnnotation) {
		System.out.println("UserName validate initialize");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("开始校验username:"+value);
		return false;
	}

}
