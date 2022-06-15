
package com.dmh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmh.dao.CommtentDao;
import com.dmh.entity.Comment;
import com.dmh.service.CommtentService;

/**

 * @author 作者:Lambert-Shi

 * @version 创建时间：2019年10月4日 下午5:15:18

 * 类说明 :

 */
@Service
public class CommtentServiceImpl implements CommtentService {
	@Autowired
	private CommtentDao commtentDao;
	/**
	 * 分页查询所有
	 */
	@Override
	public Page<Comment> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return commtentDao.findAll(pageable);
	}

}
