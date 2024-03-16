package raemian.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Reserve;
import raemian.common.dto.SearchDto;
import raemian.common.repository.ReserveRepository;

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
}
