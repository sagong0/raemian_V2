package raemian.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;
import raemian.common.UploadFile;
import raemian.common.repository.NoticeRepository;
import raemian.common.service.CdnService;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {
	
	Logger log = LoggerFactory.getLogger(AdminNoticeService.class);
	
	@Value("${cdn_url}")
	private String cdn_url;
	
	private final NoticeRepository noticeRepository;
	private final CdnService cdnService;
	
	public List<Notice> findAllNotices(){
		return noticeRepository.findAll();
	}
	
	public List<Notice> findNoticesByCurrentPage(int currentPage){
		/**
		 * 1 -> 0,5
		 * 2 -> 3,5
		 * 3 -> 6,5
		 * 4 -> 9,5
		 * n -> (n-1) * 3
		 */
		int pNo = (currentPage-1) * 3;
		return noticeRepository.findNoticeByCurrentPage(pNo);
	}
	
	
	// 검색어로 공지사항 가져오기
	public List<Notice> findBySearchWord(String searchWord){
		return noticeRepository.findBySearchWord(searchWord);
	}
	
	public List<Notice> findBySearchWordAndCurrentPage(String searchWord, int currentPage){
		Map<String, Object> maps = new HashMap<String, Object>();
		int pNo = (currentPage-1) * 3;
		
		maps.put("searchWord", searchWord);
		maps.put("pNo", pNo);
		
		return noticeRepository.findBySearchWordAndCurrentPage(maps);
	}
	
	
	public int count_notices(String searchWord) {
		int total = 0;
		if(searchWord == null || searchWord.isEmpty()) {
			total = noticeRepository.findAll().size();
		} else {
			total = noticeRepository.findBySearchWord(searchWord).size();
		}
		
		return total;
	}
	
	// 공지사항 저장
	public int saveNotice(NoticeForm noticeForm){
		int result = 0;
		
		// 첨부파일 없을때
		if(noticeForm.getNfile() == null || noticeForm.getNfile().isEmpty()) {
			result = noticeRepository.saveNotice(noticeForm);
		} else {
			// 첨부파일 있을 때 (notice save + CDN UPLOAD)
			UploadFile uploadFile = cdnService.uploadFile(noticeForm.getNfile());
			noticeForm.setStoreFileName(uploadFile.getStoreFileName());
			result = noticeRepository.saveNotice(noticeForm);
		}
		return result;
	}
	
	
	// nidx 로 찾기 
	public Notice findNoticeByNidx(int nidx) {
		return noticeRepository.findByNidx(nidx);
	};
	
	// 공지사항 삭제 
	public int delete_notice(int nidx) {
		return noticeRepository.delNotice(nidx);
	}
	
	// 조회수 카운트++;
	public int countUp(int nidx) {
		return noticeRepository.update_count(nidx);
	}
	
	
	
	
	
	
	
	
	/** 편의 메서드 **/
    public String getFullPath(String fileName){
        return cdn_url + fileName;
    }
    
}

