package com.smxy.wechat.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smxy.wechat.pojo.WcUserAll;
import com.smxy.wechat.service.WcUserService;

/**
 * 
 * @Description :shiro权限控制
 * @author Bush罗
 * @date 2018年7月12日
 *
 */
@Controller
@RequestMapping("/shiro")
public class UserController {

	@Autowired
	WcUserService wcUserService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //记住我
            token.setRememberMe(true);
            try {
            	// 执行登录.
                currentUser.login(token);
            	System.out.println("登陆成功！");
            } 
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            }
        }
		return "redirect:/list.jsp";
	}
	@RequestMapping("test")
	@ResponseBody
	public WcUserAll test(){
		System.out.println(wcUserService.selectByPrimaryKey("admin1"));
		return wcUserService.selectRoleByPrimaryKey("admin1");
	}
	
}
