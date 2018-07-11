package com.sdust.service;

import com.sdust.entity.Order;
import com.sdust.entity.OrderItem;
import com.sdust.vo.PageBean;

public interface IOrderService {
	//��Ӷ�����Ϣ
	public Order addOrderInfo(String[] ids, String[] nums, Double price, String name);
	//��Ӷ�����ϸ
	public void addOrderItems(String[] ids, String[] nums, Order order);
	//����ҳ���ѯ������ϸ(���������ݷ�ҳ)
	public PageBean<OrderItem> findItemByIndex(String name, int page);
}
