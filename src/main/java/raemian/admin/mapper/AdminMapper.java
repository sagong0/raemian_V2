package raemian.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;
import raemian.common.dto.SearchDto;

@Mapper
public interface AdminMapper {
	List<AdminMember> findAllAdmins();
	
	List<AdminMember> findBySearchDto(SearchDto searchDto);
	
	List<AdminMember> findAdminsByCurrentPageAndSearchDto(Map<String, Object> maps);
	
	List<AdminMember> findAdminsByArea(String aarea);
	
	List<AdminMember> findAdminsByAreaAndPage(Map<String, Object> maps);
	
	AdminMember findOne(String adminId);
	
	int saveAdmin(JoinAdminDto joinAdminDto);
	
	AdminMember isUser(AdminLoginDto loginDto);
	
	int updateTryCount(String aid);
	
	int updateAuse(String aid);
	
	int update_status(Map<String, String> maps);
}
