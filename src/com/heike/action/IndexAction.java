package com.heike.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理首页的Action
 * @author Geek_ymv
 *
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
	private static final long serialVersionUID = 3354263751848273843L;

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	
	
	

}
