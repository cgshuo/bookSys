package com.sdust.service;

import com.sdust.entity.User;

public interface ILoginService {
	public void login(String name,String pwd);		//��¼
	public void register(User user);				//ע��
	public boolean userIsExist(String name);
	public boolean userIsLogin(String name);
}
