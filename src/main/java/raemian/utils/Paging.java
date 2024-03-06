package raemian.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import raemian.admin.domain.AdminMember;

@Getter @ToString
public class Paging {
	
	// 전체 글의 행의 수
	private int total;
	// 현재 페이지 번호
	private int currentPage;
	// 전체 페이지 개수
	private int totalPages;
	// 시작 페이지 번호
	private int startPage;
	// 종료 페이지 번호
	private int endPage;
	// 페이징의 개수
	private int pagingCount;
	// 관리자 리스트 데이터
	private List<AdminMember> admins;
	
	
	// size 추가 : 한 화면에 보여질 행의 수.
	public Paging(int total, int currentPage, int size,int pagingCount, List<AdminMember> admins) {
		this.total = total;
		this.currentPage = currentPage;
		this.pagingCount = pagingCount;
		this.admins = admins;
		
		
		if(total == 0) { // select 결과가 없다면...
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { // select 결과가 있다면...
			// 전체 페이지 개수 구하기(전체 글의 수 / 한 화면에 보여질 행의 수)
			totalPages = total / size;
			// 보정해줘야 할 경우는? 나머지가 0보다 클 때
			if(total % size > 0) {
				// 전체페이지수를 1증가 처리
				totalPages++;
			}
			// 공식 : 현재페이지 / 페이징의 개수 * 페이징의 개수 + 1;
			startPage = currentPage / pagingCount * pagingCount + 1;
			// 보정해줘야 할 경우는? 5 / 5 * 5 + 1 => 6 경우처럼
			// 					현재페이지 % 5 == 0 일 때 
			if(currentPage % pagingCount == 0) {
				// startPage = startPage - 5(페이징의 개수)
				startPage -= pagingCount;
			}
			
			// endPage   : '이전 [1] [2] [3] [4] [5] 다음' 일때 5을 의미
			// totalPages < 4 일 경우 endPage = totalPages
			endPage = startPage + pagingCount - 1 ;
			// 보정해줘야 할 경우는? endPage > totalPages 일때
			//					endPage를 totalPages로 바꿔줘야 함 
			if(endPage > totalPages || totalPages < 4) {
				endPage = totalPages;
			}
		}
	}
	
		// select 결과가 없는가? 체킹 : true면 결과가 없다는 의미
		public boolean hasNoArticles() {
			return this.total == 0;
		}
		
		// select 결과가 있는가? 체킹 : true면 결과가 있다는 의미
		public boolean hasArticles() {
			return this.total > 0;
		}
}
