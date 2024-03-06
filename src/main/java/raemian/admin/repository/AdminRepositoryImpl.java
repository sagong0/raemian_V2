package raemian.admin.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;
import raemian.admin.mapper.AdminMapper;


@Repository
@RequiredArgsConstructor
public class AdminRepositoryImpl implements AdminRepository{
	
	private final AdminMapper adminMapper;

	@Override
	public List<AdminMember> findAllAdmins() {
		return adminMapper.findAllAdmins();
	}

	@Override
	public Optional<AdminMember> findOne(String aid) {
		AdminMember admin = adminMapper.findOne(aid);
		if(admin != null){
			return Optional.of(admin);
		} 
		
		return Optional.empty();
	}

	@Override
	public int saveAdmin(JoinAdminDto jodinAdminDto) {
		return adminMapper.saveAdmin(jodinAdminDto);
	}

	@Override
	public Optional<AdminMember> isUser(AdminLoginDto loginDto) {
		AdminMember admin = adminMapper.isUser(loginDto);
		
		if(admin != null){
			return Optional.of(admin);
		}
		
		return Optional.empty();
	}

	// Login fail =>>  try_count +1 !!!!
	@Override
	public int update_tryCount(String aid) {
		return adminMapper.updateTryCount(aid);
	}

	/**
	 * Login fail 의 ID => try_count = 5 일경우
	 * ause "N" 변경 처리
	 */
	@Override
	public int update_Ause(String aid) {
		return adminMapper.updateAuse(aid);
	}

	@Override
	public int update_status(Map<String, String> maps) {
		return adminMapper.update_status(maps);
	}
	
	@Override
	public List<AdminMember> findAdminsByArea(String aarea) {
		return adminMapper.findAdminsByArea(aarea);
	}

	@Override
	public List<AdminMember> findAdminsByAreaAndPage(Map<String, Object> maps) {
		return adminMapper.findAdminsByAreaAndPage(maps);
	}

	@Override
	public List<AdminMember> findAdminsByCurrentPage(int currentPage) {
		return adminMapper.findAdminsByCurrentPage(currentPage);
	}

}
