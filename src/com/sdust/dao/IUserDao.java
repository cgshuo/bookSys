package com.sdust.dao;

import com.sdust.base.IBaseDao;
import com.sdust.entity.User;

public interface IUserDao extends IBaseDao<User>{
	
	//�����û�����ѯ�û���Ϣ
	public User findByName(String name);
	
}
