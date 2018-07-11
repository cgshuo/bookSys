package com.sdust.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdust.dao.IBookDao;
import com.sdust.entity.Book;
import com.sdust.service.IBookService;
import com.sdust.vo.PageBean;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private IBookDao bookDao;
	
	@Override
	public PageBean<Book> findByPage(Integer page) {
		// TODO Auto-generated method stub
		
		if(page==null||page<1)
			throw new RuntimeException("ҳ����������");
		PageBean<Book> pageBean=new PageBean<>();
		pageBean.setCurrentPage(page);
		
		//��ȡ���еļ�¼
		int count=0;
		try {
			count=bookDao.count();
			pageBean.setCount(count);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw e1;
		}
		
		//������ҳ��
		if(count%pageBean.getSize()==0){
			pageBean.setTotalPage(count/pageBean.getSize());
		}else{
			pageBean.setTotalPage(count/pageBean.getSize()+1);
		}
		
		Map<String, Object> map=new HashMap<>();
		map.put("size", pageBean.getSize());	//ÿҳ��ʾ�ļ�¼��
		int index=(page-1)*pageBean.getSize();	//����ҳ������ҳ
		map.put("index", index);				//���÷�ҳʱ�Ŀ�ʼ����
		
		try {
			List<Book> books=bookDao.findByIndex(map);
			pageBean.setPageInfos(books);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pageBean;
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		if(book==null)
			throw new RuntimeException("ͼ����Ϣ����Ϊ��");
		if(book.getStock()<1)
			throw new RuntimeException("��������ȷ�Ŀ��");
		if(book.getPrice()<0)
			throw new RuntimeException("��������ȷ�ļ۸�");
		try {
			bookDao.add(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
}
