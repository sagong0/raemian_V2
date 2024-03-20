package raemian.common.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
	
	public List<Reserve> findReserves(SearchDto searchDto){
		return reserveRepository.findReserves(searchDto);
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
        pw.println("<script>alert('성공적으로 예약되었습니다.');"
        		+ "window.location.href='/raemian/client/';"
        		+ "</script>");
        pw.flush();
		return null;
	}
}
