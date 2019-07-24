package com.example.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.member.dto.MemberDTO;
import com.example.spring02.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	@RequestMapping("list.do")
	public ModelAndView listAll(ModelAndView mav) {
		List<MemberDTO> list = memberService.listAll();
		mav.setViewName("member/member_list");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping("create.do")
	public ModelAndView create(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/member_create");
		mav.addObject("session", session);
		return mav;
	}

	@RequestMapping("detail.do")
	public String detail(@RequestParam String userid,Model model) throws Exception {
		MemberDTO dto = memberService.detail(userid);
		model.addAttribute("dto", dto);
		return "member/member_detail";
	}

@RequestMapping("delete.do")
	public String delete(@RequestParam String userid,@RequestParam String passwd, Model model) throws Exception {
		boolean result = memberService.checkPw(userid,passwd);
		logger.info("로그인 : "+result);
		if(result) {
			memberService.delete(userid);
			return "redirect:/member/list.do";
		}else {
			model.addAttribute("dto", memberService.detail(userid));
			model.addAttribute("message", "비밀번호 틀렸습니다~");
			return "member/member_detail";
		}
}

@RequestMapping("insert.do")
	public String insert(MemberDTO dto) {
		memberService.insert(dto);
		return "redirect:/member/list.do";
	
	}

@RequestMapping("login.do")
	public String login() {
		logger.info("음...로그인");
		return "member/login";
		}

@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String name= memberService.login_check(dto, session);
		if(name != null) {
			mav.setViewName("home");
		}else {
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}

@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session,ModelAndView mav) {
		memberService.logout(session);
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
}

}
