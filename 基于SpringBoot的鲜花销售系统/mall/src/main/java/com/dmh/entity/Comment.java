
package com.dmh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 评论实体类
 * @author dmh
 * @2019年10月7日下午10:26:42
 */
@Entity
@Table(name = "`comment`")
public class Comment implements Serializable {
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	@Column
	private Integer orderId;
	@Column
	private String content;
	@Column
	private Date createTime;

	private static final long serialVersionUID = 1L;


	public Comment(Integer id, Integer orderId, String content, Date createTime) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.content = content;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
