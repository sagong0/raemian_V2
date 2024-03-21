package raemian.common.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import raemian.client.domain.Reserve;
import raemian.client.dto.ReserveForm;
import raemian.common.dto.SearchDto;
import raemian.common.repository.ReserveRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveService {
	
	private final ReserveRepository reserveRepository;
	
	public List<Reserve> findAll(){
		return reserveRepository.findAll();
	}
	
	public List<Reserve> findReserves(SearchDto searchDto){
		return reserveRepository.findReserves(searchDto);
	}
	
	public Reserve findBySessionInfo(Map<String, String> sessionInfoMap, HttpServletResponse response) throws IOException {
		return reserveRepository.findBySessionInfo(sessionInfoMap);
	}
	
	/**
	 * 수정 PART 
	 */
	public void modify_reserve(ReserveForm reserveForm,HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw = response.getWriter();
		
		int result= reserveRepository.modify_reserve(reserveForm);
		if(result <= 0) {
			pw.println("<script>alert('변경에 실패하였습니다.');"
	        		+ "window.location.href='/raemian/client/reserve/modify';"
	        		+ "</script>");
	        pw.flush();    
	        pw.close();
	        return;
		}
		
		pw.println("<script>"
				+ "alert('예약내용이 변경 되었습니다.');"
        		+ "window.location.href='/raemian/client/';"
        		+ "</script>");
        pw.flush();
        pw.close();
	}
	
	
	
	/**
	 * 취소 PART
	 */
	public int cancel_reserve(int ridx) {
		return reserveRepository.cancel_reserve(ridx);
	}
	
	public String insert_reserve(ReserveForm reserveForm,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		int result = reserveRepository.insert_reserve(reserveForm);
		if(result < 0) {
			return "client/view/reservation/reserve_in";
		}
		PrintWriter pw = response.getWriter();
        pw.println("<script>"
        		+ "alert('성공적으로 예약되었습니다.');"
        		+ "window.location.href='/raemian/client/';"
        		+ "</script>");
        pw.flush();
        pw.close();
		return null;
	}
}
