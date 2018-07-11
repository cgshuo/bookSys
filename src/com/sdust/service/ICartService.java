package com.sdust.service;

import java.util.List;

import com.sdust.entity.Book;

public interface ICartService {
	public String addCart(String[] bookIds,  String cartId);
	public List<Book> findCartInfo(String ids);	//��ѯ���ﳵ����ʾ������
	public String updateCart(String[] ids); //���¹��ﳵ
}
