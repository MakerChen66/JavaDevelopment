
package com.dmh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dmh.entity.Comment;
/**

 * @author 作者:Lambert-Shi

 * @version 创建时间：2019年10月4日 下午5:13:28

 * 类说明 :评论服务接口

 */

public interface CommtentService {
	/**
	 * 分页查询所有
	 *
	 * @param pageable
	 * @return
	 */
	Page<Comment> findAll(Pageable pageable);
}
