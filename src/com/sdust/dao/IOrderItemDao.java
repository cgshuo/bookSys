package com.sdust.dao;

import java.util.List;
import java.util.Map;

import com.sdust.base.IBaseDao;
import com.sdust.entity.OrderItem;

public interface IOrderItemDao extends IBaseDao<OrderItem> {
	//��ѯ������ϸ
	public List<OrderItem> findByIndex(Map<String, Object> info);
}
