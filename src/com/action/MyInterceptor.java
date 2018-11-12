package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class MyInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ValueStack vs=ActionContext.getContext().getValueStack();
		String username=(String) vs.findValue("#session.username");
		System.out.println("获取用户名"+username);
		if(username!=null){
			System.out.println("登录成功");
			ai.invoke();
			return null;
		}else{
			System.out.println("登录失败");
			return "fail";
		}
		
	}

}
