package raemian.common.mapper;

import java.util.List;

import raemian.client.domain.Reserve;
import raemian.client.dto.ReserveForm;
import raemian.common.dto.SearchDto;

public interface ReserveMapper {
	List<Reserve> findReserves(SearchDto searchDto);
	
	int insert_reserve(ReserveForm reserveForm);
	
	int cancelReserve(int ridx);
}
