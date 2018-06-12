package com.imooc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.bean.User;
import com.imooc.bean.UserQueryCondition;

@RestController
public class UserController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query(UserQueryCondition condition,  Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getSort());
		
		User u1 = new User();
		u1.setUsername("u1");
		User u2 = new User();
		u2.setUsername("u2");
		User u3 = new User();
		u3.setUsername("u3");
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}

}
