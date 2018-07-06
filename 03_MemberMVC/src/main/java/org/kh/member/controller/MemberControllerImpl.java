package org.kh.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	@Qualifier(value="memberService")
	private MemberServiceImpl memberService;

	// 요건 안쓸거예요
	@Override
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		// 1. 인코딩 -> 이미 했어요
		
		// 2. 값 추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		
		return null;
	}

	@RequestMapping(value="/login.do")
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPw) {
		//  인코딩 -> 이미 했어요
		
		// 1. 값 추출
		Member vo = new Member();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		
		// 2. 비즈니스 로직 처리
		Member m = memberService.selectOneMember(vo);
		
		HttpSession session = request.getSession();
		
		// 3. viewName 리턴
		// viewName을 처리할 때 주의할 점
		// viewName을 DispatcherServlet에게 돌려주고 자동으로
		// 처리되도록 만들지만! DispatcherServlet에서는
		// 처리할 때 무조건 forward 방식만을 사용함
		// (sendRedirect는 사용하지 않음)
		if(m!=null) {
			session.setAttribute("member", m);
			return "member/loginSuccess";
		}else {
			return "member/loginFailed";
		}
		
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member")!=null) {
			session.invalidate();
			return "redirect:/index.jsp";	// viewResolver를 거치지 않고 직접 경로를 설정하는
											// 하지만 viewResolver를 거치지 않으면 WEB-INF 폴더안의 jsp페이지에 접근할 수 없음
		}else {
			return "member/wrongPath";
		}
	}
	
	@RequestMapping(value="/myInfo.do")
	public Object myInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("member")!=null) {
			Member vo = (Member)session.getAttribute("member");
			
			Member m = memberService.selectOneMember(vo);
			
			ModelAndView view = new ModelAndView();
			
			if(m!=null) {
				session.setAttribute("member", m);
				view.addObject("mem",m);
				view.setViewName("member/myInfo");
				//request.setAttribute("memberInfo", m);	// request로도 넘기고 받을수 있음
				return view;
			}else {
				return "member/wrongPath";
			}
		}else {
			return "member/wrongPath";
		}
		
	}
	
	@RequestMapping(value="/mUpdate.do")
	public String memberUpdate(Member vo, HttpSession session) {
		
		int result = memberService.updateMember(vo);
		
		if(result>0) {
			session.setAttribute("member", vo);
			return "member/mUpdateSuccess";
		}else {
			return "member/mUpdateFail";
		}
		
	}
	
	@RequestMapping(value="/enrollPage.do")
	public String loadEnrollPage() {
		return "member/enroll";
	}
	
	@RequestMapping(value="/enroll.do")
	public String enrollMember(Member m) {
		int result = memberService.enrollMember(m);
		if(result>0) {
			return "member/enrollSuccess";
		}else {
			return "member/enrollFail";
		}
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteMember(HttpSession session) {
		Member m = (Member)session.getAttribute("member");
		int result = memberService.deleteMember(m);
		if(result>0) {
			session.invalidate();
			return "member/deleteSuccess";
		}else {
			return "member/deleteFail";
		}
		
	}

	@RequestMapping(value="/showAll.do")
	public String showAll(HttpServletRequest request) {
		List<Member> list = memberService.showAll();
		
		request.setAttribute("list", list);
		return "member/showAll";
	}
}
