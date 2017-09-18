package com.cn.lp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.lp.dao.IUserDao;
import com.cn.lp.pageModel.BaseResult;
import com.cn.lp.pojo.User;
import com.cn.lp.util.JsonHelper;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserDao userDao;
	
	@ResponseBody
	@RequestMapping("/showUser")
	public Object showUser(HttpServletRequest request,Model model){
		
		BaseResult br=new BaseResult();
		
		int userId=Integer.parseInt(request.getParameter("id"));
		User user =userDao.selectByPrimaryKey(1);
		br.writeSuccess(user);
		Object result=JsonHelper.toJSON(br);
		return result;
	}
}
