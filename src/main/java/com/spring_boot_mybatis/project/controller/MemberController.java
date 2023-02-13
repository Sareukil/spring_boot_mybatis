package com.spring_boot_mybatis.project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis.project.service.MemberService;

@Controller
public class MemberController {
    
    @Autowired
    MemberService service;

    @RequestMapping("/loginForm")
    public String loginForm(){
        return "member/loginForm";
    }

    @ResponseBody
	@RequestMapping("/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param,
												HttpSession session) {
		// 로그인 체크 결과 
		String memId = service.loginCheck(param);
		String result = "fail";
		
		// 아이디와 비밀번호 일치하면 (로그인 성공하면)
		if(memId != null) {
			//로그인 성공하면 세션 변수 지정
			session.setAttribute("sid", memId);
			result = "success";
		}
		
		return result;
	}

	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}
}
