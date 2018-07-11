package com.sdust.service;

import com.sdust.entity.Book;
import com.sdust.vo.PageBean;

public interface IBookService {
	//����ҳ����з�ҳ��ѯ
	public PageBean<Book> findByPage(Integer page);
	
	public void add(Book book);
}
