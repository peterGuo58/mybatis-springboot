package com.zq.springboot.mybatisdemo.web;

import java.util.List;

import com.zq.springboot.mybatisdemo.mapper.UserMapper;
import com.zq.springboot.mybatisdemo.model.User;
import com.zq.springboot.mybatisdemo.param.UserParam;
import com.zq.springboot.mybatisdemo.result.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class UserController {
	
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=userMapper.getAll();
		return users;
	}

    @RequestMapping("/getList")
    public Page<User> getList(UserParam userParam) {
        List<User> users=userMapper.getList(userParam);
        long count=userMapper.getCount(userParam);
        Page page = new Page(userParam,count,users);
        return page;
    }
	
    @RequestMapping("/getUser")
    public User getUser(Long id) {
    	User user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(User user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(User user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}