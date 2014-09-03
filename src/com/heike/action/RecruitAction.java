package com.heike.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("recruitAction")
@Scope("prototype")
public class RecruitAction extends ActionSupport {
	private static final long serialVersionUID = 6350175517297697212L;

	public String details() throws Exception {
		
		
		return SUCCESS;
	}

}
