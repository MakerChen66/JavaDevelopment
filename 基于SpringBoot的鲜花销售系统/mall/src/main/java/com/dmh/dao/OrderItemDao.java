package com.dmh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmh.entity.OrderItem;

import java.util.List;
/**
 * 订单数据层
 * @author dmh
 * @2019年10月7日下午10:21:31
 */
public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
	/**
	 * 根据订单Id查询
	 * @param orderId
	 * @return
	 */
	List<OrderItem> findByOrderId(int orderId);
}
