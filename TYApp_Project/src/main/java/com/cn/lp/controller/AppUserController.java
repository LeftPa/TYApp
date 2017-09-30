package com.cn.lp.controller;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.lp.pageModel.AppLoginModel;
import com.cn.lp.pageModel.BaseResult;
import com.cn.lp.pageModel.TokenModel;
import com.cn.lp.pojo.AppUser;
import com.cn.lp.service.IAppUserService;
import com.cn.lp.util.JsonHelper;
import com.cn.lp.util.TokenHelper;

@Controller
@RequestMapping("/appuser")
public class AppUserController {

	private Logger logger=Logger.getLogger(AppUserController.class);
	
	@Resource
	private IAppUserService appUserService;

	@ResponseBody
	@RequestMapping("/regist")
	public Object regist(HttpServletRequest request, Model model) {

		BaseResult br = new BaseResult();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			br.writeFaile("�û��������벻��Ϊ�գ�");
		} else {
			int r = appUserService.addAppUser(userName, password);
			if (r == 1) {
				br.writeSuccess();
			} else if (r == 2) {
				br.setRspCode("201");
				br.setRspDesc("����ע�ᣬ��ֱ�ӵ�¼��");
			} else {
				br.writeFaile("ע��ʧ��");
			}
		}
		return JsonHelper.toJSON(br);
	}

	@ResponseBody
	@RequestMapping("/login")
	public Object login(HttpServletRequest request, Model model) {
		BaseResult br =new BaseResult();
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			br.writeFaile("�û��������벻��Ϊ�գ�");
		} else {
			try{
				AppUser appUser = appUserService.loginAppUser(userName, password);
				if (appUser !=null ) {
					AppLoginModel m=new AppLoginModel();
					BeanUtils.copyProperties(appUser, m);
					String token=TokenHelper.createToken(new TokenModel(appUser.getAppId()));
					token=URLEncoder.encode(token,"UTF-8");
					m.setToken(token);
					br.writeSuccess(m);
				} else {
					br.writeFaile("��¼ʧ�ܣ��û��������벻��ȷ");
				}
			}
			
			catch(Exception ee){
				//logger.error("�����쳣!"+ee.getMessage()+";"+ee.getStackTrace());
				br.writeFaile("�����쳣!"+ee.getMessage()+";"+ee.getStackTrace());
			}
		}
		return JsonHelper.toJSON(br);
	}
}
