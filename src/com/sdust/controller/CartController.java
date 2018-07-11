package com.sdust.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sdust.entity.Book;
import com.sdust.service.ICartService;
import com.sdust.vo.JsonBean;

@Controller
public class CartController {

	@Autowired
	private ICartService cartService;
	
	//���ﳵ������ݣ���������ݴ���cookie
	@RequestMapping(value="/carts",method=RequestMethod.POST)
	//@CookieValue��ָ����Cookie
	public @ResponseBody JsonBean addCart(String[] bookIds, HttpServletResponse response, @CookieValue(value="cartids", defaultValue="") String cartId){
		JsonBean bean=new JsonBean();
		try {
			String info = cartService.addCart(bookIds, cartId);
			Cookie cookie=new Cookie("cartids",info);
			cookie.setMaxAge(30*24*3600);
			response.addCookie(cookie);

			bean.setCode(1);
		} catch (Exception e) {
			// TODO: handle exception
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	
	@RequestMapping(value="/carts",method=RequestMethod.GET)
	public @ResponseBody JsonBean carts(@CookieValue(value="cartids", defaultValue="") String cartId){
		JsonBean bean=new JsonBean();
		try {
			List<Book> infos=cartService.findCartInfo(cartId);
			bean.setCode(1);
			bean.setMsg(infos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}

    //���¹��ﳵ��Ϣ
	@RequestMapping(value="/carts", method = RequestMethod.PUT)
    public @ResponseBody JsonBean updateCarts(String[] ids, HttpServletResponse response, @CookieValue(value="cartids", defaultValue="") String cartId){
	    JsonBean bean=new JsonBean();
        try {
            String info = cartService.updateCart(ids);
            Cookie cookie=new Cookie("cartids",info);
            cookie.setPath("/");        //put������urlΪ"carts/?"����ʱ������cookie·��Ϊ"/carts"���޷����Ǿ�cookie����Ҫ��������·��
            cookie.setMaxAge(30*24*3600);
            response.addCookie(cookie);

            bean.setCode(1);
        } catch (Exception e) {
            // TODO: handle exception
            bean.setCode(0);
            bean.setMsg(e.getMessage());
        }
        return bean;
    }
}
