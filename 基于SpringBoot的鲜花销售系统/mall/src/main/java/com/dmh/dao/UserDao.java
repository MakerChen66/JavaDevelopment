package com.dmh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmh.entity.User;

import java.util.List;
/**
 * 用户数据层
 * @author dmh
 * @2019年10月7日下午10:20:44
 */
public interface UserDao extends JpaRepository<User, Integer> {
	/**
	 * 根据用户名，密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	List<User> findByUsername(String username);
}
