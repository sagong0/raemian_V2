package raemian.admin.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import raemian.admin.domain.Notice;
import raemian.admin.dto.NoticeForm;
import raemian.common.NoticeRepository;
import raemian.common.UploadFile;
import raemian.common.service.FileSaveService;

@Service
@RequiredArgsConstructor
public class AdminNoticeService {
	
	private final NoticeRepository noticeRepository;
	private final FileSaveService fileSaveService;
	
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
	public int saveNotice(NoticeForm noticeForm) {
		// 첨부파일 없을때
		if(noticeForm.getNfile() == null ) {
			noticeRepository.saveNotice(noticeForm);
		} else {
			// 첨부파일 있을 때
//			try {
////				UploadFile storedFile = fileSaveService.storeFile(noticeForm.getNfile());
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		return 0;
	}
}
