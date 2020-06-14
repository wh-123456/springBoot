package com.springboot.springb.modules.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.springboot.springb.modules.user.entity.User;

@Repository
@Mapper
public interface UserDao {
	
	/*查询所有用户*/
	@Select("select * from user")
	@Results/*定义此结果集必须放在查询语句下面，其他方法才能获取*/(id="userResult", value={
			@Result(column="u_wnum", property="uWnum", jdbcType=JdbcType.VARCHAR),
			@Result(column="u_name", property="uName", jdbcType=JdbcType.VARCHAR),
			@Result(column="u_password", property="uPassword", jdbcType=JdbcType.CHAR)
			})
     List<User> getUserList();
	
	/*分页查询*/
	@Select("select * from user")
	@ResultMap("userResult")
	List<User> getUserListPage();
	
	/*根据用户ID查询用户*/
	@Select("select * from user where u_wnum=#{wNum}")
	@ResultMap("userResult")
	User getUserBywNum(String wNum);
	
	/*增加用户*/
	@Insert("insert into user(u_wnum,u_name,u_password,fk_role_id) values(#{uWnum},#{uName},#{uPassword},#{fkRoId})")
	int inserUser(User u);
	
	/*删除用户*/
	@Delete("delete from user where u_wnum=#{wNum}")
	int deleteUserBywNum(String wNum);
	
	/*修改用户*/
	@Update("update user set u_name=#{uName},u_password=#{uPassword} where u_wnum=#{uWnum}")
	int updateUser(User u);
}
