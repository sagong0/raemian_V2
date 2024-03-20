package raemian.common.repository;

import java.util.List;

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
}
