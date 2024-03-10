package raemian.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import raemian.consts.SessionConst;

public class LoginCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		HttpSession session = request.getSession(false);
		
		System.out.println("interceptor start");
		
		if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
			// 미인증 사용자 감지 로직
			// login 으로 redirect 시킬 것
			response.sendRedirect("/raemian/admin/?redirectURL="+requestURI);
			return false;
		}

		return true;
	}
}
