package raemian.common.repository;

import java.util.List;

import raemian.client.domain.Reserve;
import raemian.common.dto.SearchDto;

public interface ReserveRepository {
	
	List<Reserve> findReserves(SearchDto searchDto);
	
	int cancel_reserve(int ridx);
}
