package raemian.admin.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;

public interface AdminRepository {
	List<AdminMember> findAllAdmins();
	
	List<AdminMember> findAdminsByCurrentPage(int currentPage);
	
	List<AdminMember> findAdminsByArea(String aarea);
	
	List<AdminMember> findAdminsByAreaAndPage(Map<String, Object> maps);
	
	Optional<AdminMember> findOne(String adminId);
	
	int saveAdmin(JoinAdminDto jodinAdminDto);
	
	// Login 시 아디,비번 확인
	Optional<AdminMember> isUser(AdminLoginDto loginDto);
	
	/**
	 *  Login 시도 실패시
	 *  try_count + 1 처리 
	 */
	int update_tryCount(String aid);
	
	/**
	 * Login 시도 아이디의 try_count = 5 일 경우
	 * 해당 AUSE => N 처
	 */
	int update_Ause(String aid);
	
	int update_status(Map<String, String> maps);
}
