package com.imooc.bean;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.UserNameConstraint;

import io.swagger.annotations.ApiModelProperty;

public class User {
	
	//标注ListView视图不返回password字段
	public interface BaseView{}

	//标注AllFields视图要返回的字段，有继承关系，会把password的字段也一并返回
	public interface DetailView extends BaseView{}

	@JsonView(BaseView.class)
	@NotBlank(message="id不能为空")
	private String id;

	@JsonView(BaseView.class)
	@UserNameConstraint(message = "这是一个测试")
	@ApiModelProperty(value="用户名")
	private String username;
	
	@JsonView(BaseView.class)
	@Past(message = "生日必须是过去的时间")
	private Date birthday;

	@JsonView(DetailView.class)
	private String password;

	@JsonView(BaseView.class)
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
