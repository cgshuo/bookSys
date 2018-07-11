package com.sdust.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdust.dao.IUserDao;
import com.sdust.entity.User;
import com.sdust.service.ILoginService;
import com.sdust.util.StringUtil;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private IUserDao userDao; 
	
	@Override
	public void login(String name, String pwd) {
		// TODO Auto-generated method stub
		if(StringUtil.isNullOrEmpty(name))
			throw new RuntimeException("�û���Ϊ��");
		if(StringUtil.isNullOrEmpty(pwd))
			throw new RuntimeException("����Ϊ��");
		
		User user = null;
		try {
			user = userDao.findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user==null){
			throw new RuntimeException("�û�������");
		}else {
			if(!user.getPassword().equals(pwd)){
				throw new RuntimeException("�������");
			}
		}
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		if(user==null){
			throw new RuntimeException("�û���Ϣ����Ϊ��");
		}
		
		if(!user.getPassword().equals(user.getRePassword())){
			throw new RuntimeException("������������벻һ��");
		}
		
		try {
			userDao.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	@Override
	public boolean userIsExist(String name){
		try {
			User user = userDao.findByName(name);
			if(user==null)
				return false;
			else return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	@Override
	public boolean userIsLogin(String name){
        if(StringUtil.isNullOrEmpty(name)){
            if(this.userIsExist(name)){
                return true;
            }
        }else{
            return false;
        }
	    return true;
    }
}
