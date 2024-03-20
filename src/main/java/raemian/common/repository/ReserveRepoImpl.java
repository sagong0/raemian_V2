package raemian.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.client.domain.Reserve;
import raemian.client.dto.ReserveForm;
import raemian.common.dto.SearchDto;
import raemian.common.mapper.ReserveMapper;

@Repository
@RequiredArgsConstructor
public class ReserveRepoImpl implements ReserveRepository{
	
	private final ReserveMapper reserveMapper;

	@Override
	public List<Reserve> findReserves(SearchDto searchDto) {
		return reserveMapper.findReserves(searchDto);
	}

	@Override
	public int cancel_reserve(int ridx) {
		return reserveMapper.cancelReserve(ridx);
	}

	@Override
	public int insert_reserve(ReserveForm reserveForm) {
		return reserveMapper.insert_reserve(reserveForm);
	}

	@Override
	public Reserve findBySessionInfo(Map<String, String> sessionInfoMap) {
		return reserveMapper.findBySessionInfo(sessionInfoMap);
	}

	@Override
	public int modify_reserve(ReserveForm reserveForm) {
		return reserveMapper.modify_reserve(reserveForm);
	}
}
