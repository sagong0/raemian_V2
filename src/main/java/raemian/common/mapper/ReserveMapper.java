package raemian.common.mapper;

import java.util.List;

import raemian.client.domain.Reserve;
import raemian.common.dto.SearchDto;

public interface ReserveMapper {
	List<Reserve> findReserves(SearchDto searchDto);
	
	int cancelReserve(int ridx);
}
