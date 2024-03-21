package raemian.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.AdminMember;
import raemian.admin.dto.AdminLoginDto;
import raemian.admin.dto.JoinAdminDto;
import raemian.admin.dto.StatusDto;
import raemian.admin.repository.AdminRepository;
import raemian.common.dto.SearchDto;

@Service
@RequiredArgsConstructor
public class AdminService {

	private final AdminRepository adminRepository;

	public List<AdminMember> findAllAdmins() {
		return adminRepository.findAllAdmins();
	}
	
	/**
	 * currentPage -> (currentPage-1) * 5
	 */
	public List<AdminMember> findAdminListByCurrentPageAndSearchDto(int currentPage, SearchDto searchDto){
		int pNo = (currentPage - 1) * 5;
		Map<String, Object> maps = new HashMap<String, Object>(); 
		maps.put("pNo", pNo);
		maps.put("searchDto", searchDto);
		
		return adminRepository.findAdminsByCurrentPageAndSearchDto(maps);
	}
	
	// 소속 지역에 해당하는 관리자 찾기
	public List<AdminMember> findAdminsByAreaAndPage(String aarea, int currentPage){
		Map<String, Object> maps = new HashMap<String, Object>(); 
		int pNo = (currentPage-1) * 5;
//		if(aarea.isEmpty()) {}
		maps.put("aarea", aarea);
		maps.put("pNo", pNo);
		
		return adminRepository.findAdminsByAreaAndPage(maps);
	}

	/**
	 ** 아이디 중복체크
	 */
	public String findAdmin(String adminId) {
		Optional<AdminMember> optionalMember = adminRepository.findOne(adminId);

		if (optionalMember.isPresent()) {
			return "no_use";
		} else {
			return "canuse";
		}
	}

	/**
	 * 관리자 등록
	 */
	public String joinAdmin(JoinAdminDto joinAdminDto, RedirectAttributes redirectAttributes) {

		int resultSign = adminRepository.saveAdmin(joinAdminDto);

		if (resultSign > 0) {
			redirectAttributes.addFlashAttribute("msg", "관리자 등록에 성공하였습니다.");
		} else {
			redirectAttributes.addFlashAttribute("msg", "관리자 등록에 실패하였습니다.");
		}
		return "redirect:/admin/";
	}

	/**
	 * Login PART
	 */
	public Optional<AdminMember> admin_login(AdminLoginDto loginDto) {
		return adminRepository.isUser(loginDto);
	}

	/**
	 * 로그인 실패시 아이디만 맞앚을 경우 해당 아이디 try_count+1 처리 위해 해당 아이디 불러오기
	 **/
	public Optional<AdminMember> findAdminById(String aid) {
		return adminRepository.findOne(aid);
	}

	/**
	 * 로그인 시도 실패시 try_count + 1 처리 로직
	 */
	public String updateTryCount(String aid) {
		int sign = adminRepository.update_tryCount(aid);
		return "";
	}
	
	/**
	 * 로그인 시도 ID try_count 가 5 일
	 * Ause => "N" 변경.
	 */
	public void updateAuse(String aid) {
		adminRepository.update_Ause(aid);
	}

	
	// 근무중 , 퇴직중 => ause 상태변경하기.
	public int modifyStatus(StatusDto statusDto) {
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("aidx", String.valueOf(statusDto.getAidx()));
		
		if(statusDto.getStatus().equals("근무중")) {
			maps.put("status", "1");			
		} else if (statusDto.getStatus().equals("퇴직중")) {
			maps.put("status", "2");
		}
		
		return adminRepository.update_status(maps);
	};

	
	
	
	public int count_admins(String aarea,SearchDto searchDto) {
		
		int total = 0;
		List<AdminMember> admins = null;
		
		// 소속 지역이 전체 일때
		if(aarea == null || aarea.intern() == "" || aarea.isEmpty()) {
			if(searchDto == null || searchDto.getSearchVal()==null || searchDto.getSearchVal().isEmpty()) {
				total = adminRepository.findAllAdmins().size();				
			} else {
				total = adminRepository.findBySearchDto(searchDto).size();
			}
		} 
		else {
			// 소속 지역을 선택 하였을 때
			admins = adminRepository.findAdminsByArea(aarea);
			total = admins.size();
		}
		
		return total;
	}
}
