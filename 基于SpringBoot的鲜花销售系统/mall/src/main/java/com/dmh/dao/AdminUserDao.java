package com.dmh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmh.entity.AdminUser;
/**
 * 管理员数据层
 * @author dmh
 * @2019年10月7日下午10:22:21
 */
public interface AdminUserDao extends JpaRepository<AdminUser, Integer> {
	AdminUser findByUsernameAndPassword(String username, String pwd);
}
