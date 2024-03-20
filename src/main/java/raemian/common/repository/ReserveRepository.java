package raemian.common.repository;

import java.util.List;

import raemian.client.domain.Reserve;
import raemian.client.dto.ReserveForm;
import raemian.common.dto.SearchDto;

public interface ReserveRepository {
	
	List<Reserve> findReserves(SearchDto searchDto);
	
	int insert_reserve(ReserveForm reserveForm);
	
	int cancel_reserve(int ridx);
}
