package raemian.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;

@Mapper
public interface AdminMapper {
	List<AdminMember> findAllAdmins();
	
	List<AdminMember> findAdminsByCurrentPage(int currentPage);
	
	List<AdminMember> findAdminsByArea(String aarea);
	
	List<AdminMember> findAdminsByAreaAndPage(Map<String, Object> maps);
	
	AdminMember findOne(String adminId);
	
	int saveAdmin(JoinAdminDto joinAdminDto);
	
	AdminMember isUser(AdminLoginDto loginDto);
	
	int updateTryCount(String aid);
	
	int updateAuse(String aid);
	
	int update_status(Map<String, String> maps);
}
