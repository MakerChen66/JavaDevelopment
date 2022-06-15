
package com.dmh.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dmh.entity.Comment;
/**
 * 评论数据层
 * @author dmh
 * @2019年10月7日下午10:23:20
 */
public interface CommtentDao extends JpaRepository<Comment, Integer> {
	/**
	 * 根据商品查询评论
	 * @param mallId
	 * @return
	 */
	@Override
	Page<Comment> findAll(Pageable pageable);
}
