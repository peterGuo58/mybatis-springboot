package com.zq.springboot.mybatisdemo.mapper;

import java.util.List;
import java.util.Map;

import com.zq.springboot.mybatisdemo.enums.UserSexEnum;
import com.zq.springboot.mybatisdemo.model.User;
import com.zq.springboot.mybatisdemo.param.UserParam;
import org.apache.ibatis.annotations.*;


public interface UserMapper {
	/*@Select 是查询类的注解，所有的查询均使用这个
	@Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
	@Insert 插入数据库使用，直接传入实体类会自动解析属性到对应的值
	@Update 负责修改，也可以直接传入对象
	@delete 负责删除*/
	@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	List<User> getAll();

	@SelectProvider(type = UserSql.class, method = "getList")
	List<User> getList(UserParam userParam);

	@Select("SELECT * FROM users WHERE user_sex = #{user_sex}")
	List<User> getListByUserSex(@Param("user_sex") String userSex);

	@Select("SELECT * FROM users WHERE username=#{username} AND user_sex = #{user_sex}")
	List<User> getListByNameAndSex(Map<String, Object> map);

	@SelectProvider(type = UserSql.class, method = "getCount")
	int getCount(UserParam userParam);
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Update({"<script> ",
			"update users " ,
			"<set>" ,
			" <if test='userName != null'>userName=#{userName},</if>" ,
			" <if test='nickName != null'>nick_name=#{nickName},</if>" ,
			" </set> ",
			"where id=#{id} " ,
			"</script>"})
	void updateUser(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}