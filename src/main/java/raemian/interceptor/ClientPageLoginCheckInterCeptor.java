package raemian.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import raemian.consts.SessionConst;

public class ClientPageLoginCheckInterCeptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) { 
            // 클라이언트 측에서 경고창을 띄우기 위해 JavaScript를 사용하여 출력
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.println("<script>alert('사전방문예약은 로그인 후 신청할 수 있습니다.');"
            		+ "window.location.href='/raemian/client/login';"
            		+ "</script>");
            pw.flush();
            return false; // false를 반환하여 요청을 중단 
        } 
		
		return true;
	}
}
