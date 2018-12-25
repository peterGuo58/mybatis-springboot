package com.zq.springboot.mybatisdemo.mapper;

import com.zq.springboot.mybatisdemo.model.User;
import com.zq.springboot.mybatisdemo.param.UserParam;

import java.util.List;


public interface UserMapper {

	List<User> getAll();

	List<User> getList(UserParam userParam); //多条件分页查询

	int getCount(UserParam userParam);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int delete(Long id);

}