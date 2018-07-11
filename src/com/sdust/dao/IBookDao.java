package com.sdust.dao;

import java.util.List;
import java.util.Map;

import com.sdust.base.IBaseDao;
import com.sdust.entity.Book;

public interface IBookDao extends IBaseDao<Book>{
	
	//���з�ҳ��ѯ��������������¼
	//public List<Book> findByIndex(Integer index, Integer size);
	public List<Book> findByIndex(Map<String, Object> pageInfo);
	
	// ������ص��鼮id���в�ѯ
	public List<Book> findByIds(List<String> ids);
	
	//����id��ѯ���
	public Integer findStockById(Integer id);
}
