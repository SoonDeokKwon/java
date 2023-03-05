package com.yedam.exe;

import java.util.Scanner;

import com.yedam.directmessage.DirectMessageService;
import com.yedam.notiboard.NoticeBoardService;
import com.yedam.service.ChargingService;
import com.yedam.service.MemberService;
import com.yedam.sugboard.SugCommentService;
import com.yedam.sugboard.SuggestionBoardService;

public class ExeApp {
	
	MemberService ms = new MemberService();
	ChargingService cs = new ChargingService();
	SuggestionBoardService sb = new SuggestionBoardService();
	SugCommentService scom = new SugCommentService();
	NoticeBoardService nb = new NoticeBoardService();
	DirectMessageService dm = new DirectMessageService();
	Scanner sc = new Scanner(System.in);
	
	String menu = "";
	boolean run = true;
	
	public ExeApp() { 
		run();
	}
	
	
	private void run() {

		while(run) {
			if(MemberService.memberInfo != null) {
				//로그인 메뉴
				if(MemberService.host == 1) {
					adminmenu();
				}else if(MemberService.host == 2) {
					loginMenu();		
				}
			}else if(MemberService.memberInfo == null) {
				//로그아웃 메뉴
				logoutMenu();
			}
		}
	}
	
	//로그인 이후 화면(회원)
	public void loginMenu() {
		//내 정보 전체 조회 | 게시판 점수 조회 | 비밀번호 수정 | 차량번호 수정
		System.out.println();
		System.out.println();
		System.out.println("==============================================================================");
		System.out.println();
		System.out.println("| 1. 회원 정보 | 2. 전기차 충전(회원) | 3. 게시판 | 4. 쪽지함 | 5. 로그아웃 |");
		System.out.println();
		System.out.println("==============================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보
			memberInfo();
			break;
		case "2":
			//전기차 충전(회원)
			memberChargingMenu();
			loginMenu();
			break;
		case "3":
			//게시판
			boardMenu();
			break;
		case "4":
			//쪽지함
			memMessageMenu();
			break;
		case "5":
			//로그아웃
			logoutMenu();
			break;
		}
		
	}
	
	//로그인 이후 화면(회원) -> 회원 정보
	public void memberInfo() {
		System.out.println();
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println();
		System.out.println("| 1. 회원 정보 조회 |  2. 비밀번호 수정 | 3. 차량번호 수정 | 4. 회원 탈퇴 | 5. 로그인 메인 메뉴  |");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보 조회
			ms.getMember();
			memberInfo();
			break;
		case "2":
			//비밀번호 수정
			ms.modifyMember1();
			memberInfo();
			break;
		case "3":
			//차량정보 수정
			ms.modifyMember2();
			memberInfo();
			break;
		case "4":
			//회원 탈퇴
			ms.deleteMember();
			memberInfo();
			break;
		case "5":
			//로그인 메인 메뉴
			loginMenu();
			break;
		}
		
	}
	
	
	//로그인 이후 화면(관리자)
	public void adminmenu() {
		System.out.println();
		System.out.println();
		System.out.println("===========================================================================================================================");
		System.out.println();
		System.out.println("| 1. 전체 회원 조회 | 2. 게시판 점수 조회 | 3. 할인 제외 회원 조회 | 4. 쪽지함 | 5. 회원 강제 탈퇴  | 6. 게시판 | 7. 로그아웃 |  ");
		System.out.println();
		System.out.println("===========================================================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//전체 회원 조회
			ms.getMemberList();
			adminmenu();
			break;
		case "2":
			//전체 회원 게시판 점수 조회
			ms.getNoticeScore();
			adminmenu();
			break;
		case "3":
			//할인 제외 회원 조회
			ms.exceptDiscount();
			adminmenu();
			break;
		case "4":
			//쪽지함
			adminMessageMenu();
			break;
		case "5":
			//회원 강제 탈퇴
			ms.deleteMember();
			adminmenu();
			break;
		case "6":
			//게시판(관리자용)
			adminBoardMenu();
			break;
		case "7":
			//로그아웃
			logoutMenu();
			break;
		}
		
	}
	
	
	//쪽지함(회원)
	public void memMessageMenu() {
		System.out.println();
		System.out.println();
		System.out.println("====================================================================");
		System.out.println();
		System.out.println("| 1. 쪽지 보내기 | 2. 받은 쪽지함  | 3. 보낸 쪽지함 | 4. 뒤로가기 |");
		System.out.println();
		System.out.println("====================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 아이디·이름 목록 보여주기
			//쪽지 보내기
			ms.getMemberIdNameList();
			dm.sendDM();
			memMessageMenu();
			break;
		case "2":
			//받은 쪽지함 
			dm.reciveDMlist();
			System.out.println();
			System.out.println("=============================================");
			System.out.println();
			System.out.println("| 1. 받은 쪽지함 비우기 | 2. 뒤로 가기 |");
			System.out.println();
			System.out.println("=============================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			switch(menu) {
			case "1":
				//받은 쪽지함 비우기
				dm.receiveDelete();
				memMessageMenu();
				break;
			case "2":
				//뒤로가기 
				memMessageMenu();
				break;
			}
			
			break;
		case "3":
			//보낸 쪽지함
			dm.sendDMlist();
			System.out.println();
			System.out.println("=============================================");
			System.out.println();
			System.out.println("| 1. 보낸 쪽지함 비우기 | 2. 뒤로 가기 |");
			System.out.println();
			System.out.println("=============================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			switch(menu) {
			case "1":
				//받은 쪽지함 비우기
				dm.sendDelete();
				memMessageMenu();
				break;
			case "2":
				//뒤로가기 
				memMessageMenu();
				break;
			}
			
			break;
		case "4":
			//뒤로가기
			loginMenu();
			break;
		}
	}
	
	
	//쪽지함(관리자)
		public void adminMessageMenu() {
			System.out.println();
			System.out.println();
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("| 1. 쪽지 보내기 | 2. 받은 쪽지함  | 3. 보낸 쪽지함 | 4. 뒤로가기 |");
			System.out.println();
			System.out.println("==========================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//회원 아이디·이름 목록 보여주기
				//쪽지 보내기
				ms.getMemberIdNameList();
				dm.sendDM();
				adminMessageMenu();
				break;
			case "2":
				//받은 쪽지함 
				dm.reciveDMlist();
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("| 1. 받은 쪽지함 비우기 | 2. 뒤로 가기 |");
				System.out.println();
				System.out.println("===================================");
				System.out.println("입력>");
				menu = sc.nextLine();
				switch(menu) {
				case "1":
					//받은 쪽지함 비우기
					dm.receiveDelete();
					adminMessageMenu();
					break;
				case "2":
					//뒤로가기 
					adminMessageMenu();
					break;
				}
				
				break;
			case "3":
				//보낸 쪽지함
				dm.sendDMlist();
				System.out.println();
				System.out.println("==============================================");
				System.out.println();
				System.out.println("| 1. 보낸 쪽지함 비우기 | 2. 뒤로 가기 |");
				System.out.println();
				System.out.println("==============================================");
				System.out.println("입력>");
				menu = sc.nextLine();
				switch(menu) {
				case "1":
					//받은 쪽지함 비우기
					dm.sendDelete();
					adminMessageMenu();
					break;
				case "2":
					//뒤로가기 
					adminMessageMenu();
					break;
				}
				
				break;
			case "4":
				//뒤로가기
				adminmenu();
				break;
			}
		}
	
		//회원용 공지 게시판 메뉴
				public void memNoticeBoardMenu() {
					System.out.println();
					System.out.println("========================================================================================");
					System.out.println();
					System.out.println("| 1. 게시글 선택 | 2. 이전 페이지 | 3. 다음 페이지 | 4. 전체 게시판 메뉴  |");
					System.out.println();
					System.out.println("========================================================================================");
					System.out.println("입력>");
					menu = sc.nextLine();
					
					switch(menu) {
					case "1":
						//게시글 선택
						nb.viewNotiBoard() ;
						nb.listNoticeBoard();
						memNoticeBoardMenu();
						break;
					case "2":
						//이전 페이지
						if(sb.page != 1) {
							sb.page--;
						}else {
							System.out.println("첫 페이지입니다.");
						}
						nb.listNoticeBoard();
						memNoticeBoardMenu();
						break;
					case "3":
						//다음 페이지
						if(sb.page != sb.totalpage) {
							sb.page++;
						}else {
							System.out.println("마지막 페이지입니다.");
						}
						nb.listNoticeBoard();
						memNoticeBoardMenu();
						break;
					case "4":
						//뒤로 가기
						boardMenu();
						break;
					}
				}
							
	
	//관리자용 게시판 메뉴
	public void adminBoardMenu() {
		System.out.println();
		System.out.println("========================================================================");
		System.out.println();
		System.out.println("| 1. 공지사항 게시판 | 2. 건의 게시판  | 3. 뒤로가기 |");
		System.out.println();
		System.out.println("========================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//공지사항 게시판(제목 리스트 페이지)
			adminNoticeBoardMenu();
			break;
		case "2":
			//건의 게시판 메뉴로 이동
			adminSugBoardMenu();
			break;
		case "3":
			//뒤로가기
			adminmenu();
			break;
		}
	}
	
	//관리자용 공지 게시판 메뉴
		public void adminNoticeBoardMenu() {
			System.out.println();
			System.out.println();
			System.out.println("===================================================================");
			System.out.println();
			System.out.println("| 1. 글쓰기  | 2. 공지사항 게시글  목록  | 3. 전체 게시판 메뉴  |");
			System.out.println();
			System.out.println("===================================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//공지사항 글쓰기
				nb.insertNotiBoard();;
				adminNoticeBoardMenu();
				break;
			case "2":
				//공지사항 게시글 목록
				nb.listNoticeBoard();
				viewNoticeBoard();
				break;
			case "3":
				//뒤로 가기
				adminBoardMenu();
				break;
			}
		}
		
		//관리자용 건의 게시판
		//건의 게시판 메뉴
		public void adminSugBoardMenu() {
			System.out.println();
			System.out.println();
			System.out.println("====================================================================");
			System.out.println();
			System.out.println("| 1. 글쓰기  | 2. 건의 게시글  목록  | 3. 게시판 메뉴(뒤로 가기)  |");
			System.out.println();
			System.out.println("====================================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//글쓰기
				sb.insertSuggestion();
				adminSugBoardMenu();
				break;
			case "2":
				//건의 게시글 목록
				sb.listSuggestBoard();
				adminViewSuggestBoard();
				break;
			case "3":
				//뒤로 가기
				adminBoardMenu();
				break;
			}
		}
		
		
		//관리자용 건의 게시글 보기
		public void adminViewSuggestBoard() {
			System.out.println();
			System.out.println();
			System.out.println("=====================================================================");
			System.out.println();
			System.out.println("| 1. 게시글 선택  | 2. 건의 게시판 메뉴 | 3. 이전 페이지 | 4. 다음 페이지 |");
			System.out.println();
			System.out.println("=====================================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//게시글 선택
				sb.viewSuggestBoard();
				scom.listSugComment();
				adminSuggestCommentMenu();			
				break;
			case "2":
				//뒤로가기
				adminSugBoardMenu();
				break;
			case "3":
				//이전 페이지
				//뒤로
				if(sb.page != 1) {
					sb.page--;
				}else {
					System.out.println("첫 페이지입니다.");
				}
				sb.listSuggestBoard();
				adminViewSuggestBoard();
				break;
			case "4":
				//다음 페이지
				if(sb.page != sb.totalpage) {
					sb.page++;
				}else {
					System.out.println("마지막 페이지입니다.");
				}
				sb.listSuggestBoard();
				adminViewSuggestBoard();
				break;
			}
		}
		
		public void adminSuggestCommentMenu() {
			System.out.println();
			System.out.println();
			System.out.println("================================================================");
			System.out.println();
			System.out.println("| 1. 댓글 입력 | 2. 댓글 삭제 | 3. 게시글 삭제  | 6. 뒤로 가기 |");
			System.out.println();
			System.out.println("================================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//댓글 입력
				scom.insertSugComment();
				sb.viewSuggestBoard2();
				scom.listSugComment();
				adminSuggestCommentMenu();
				break;
			case "2":
				//댓글 삭제
				scom.adminDeleteSugComment();
				scom.SugComReordering2();
				sb.viewSuggestBoard2();
				scom.listSugComment();
				SuggestCommentMenu();
				break;
			case "3":
				//게시글 삭제
				sb.adminDeleteSuggest();
				sb.reordering();
				scom.listSugComment();
				SuggestCommentMenu();
				break;
			case "4":
				//뒤로가기
				sb.listSuggestBoard();
				viewSuggestBoard();
				break;
			}
		}
		
		//관리자용 건의 게시글 보기
		public void viewNoticeBoard() {
			System.out.println();
			System.out.println();
			System.out.println("=============================================================================================================");
			System.out.println();
			System.out.println("| 1. 게시글 선택 | 2. 게시글 수정  | 3. 게시글 삭제 | 4. 이전 페이지 | 5. 다음 페이지 | 6. 공지사항 게시글 목록으로 돌아가기 |");
			System.out.println();
			System.out.println("=============================================================================================================");
			System.out.println("입력>");
			menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				//게시글 선택
				nb.viewNotiBoard();	
				viewNoticeBoard();
				break;
			case "2":
				//게시글 수정
				nb.modifyNoticeBoard();
				nb.viewNotiBoard2();
				viewNoticeBoard();
				break;
			case "3":
				//게시글 삭제
				nb.deleteNotiBoard();
				nb.viewNotiBoard2();
				viewNoticeBoard();
				break;
			case "4":
				//이전 페이지
				if(sb.page != 1) {
					sb.page--;
				}else {
					System.out.println("첫 페이지입니다.");
				}
				nb.listNoticeBoard();
				viewNoticeBoard() ;
				break;
			case "5":
				//다음 페이지
				if(sb.page != sb.totalpage) {
					sb.page++;
				}else {
					System.out.println("마지막 페이지입니다.");
				}
				nb.listNoticeBoard();
				viewNoticeBoard() ;
				break;
			case "6":
				//뒤로가기
				adminNoticeBoardMenu();
				break;
			}
		}
		
	
	public void logoutMenu() {
		//| 1. 로그인 | 2.회원가입 | 3.전기차 충전 |
		System.out.println();
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println();
		System.out.println("| 1. 로그인 | 2.회원가입 | 3.전기차 충전(비회원) | 4. 프로그램 종료 |");
		System.out.println();
		System.out.println("=====================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보 조회
			ms.loginAdmin();
			break;
		case "2":
			//회원 가입
			ms.insertMember();
			break;
		case "3":
			//충전
			chargingMenu();
			break;
		case "4":
			//종료
			run = false;
			System.out.println("프로그램 종료");
			break;
		}
	}
	
	//비회원 전기차 충전
	public void chargingMenu() {
		System.out.println();
		System.out.println();
		System.out.println("======================================================================");
		System.out.println();
		System.out.println("| 1. 빈자리 조회 | 2. 충전 등록 | 3. 결제 및 등록해제 | 4. 초기화면 |");
		System.out.println();
		System.out.println("======================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//빈자리 조회
			cs.emptyCheck();
			chargingMenu();
			break;
		case "2":
			//충전 등록
			cs.regisCharging();
			chargingMenu();
			break;
		case "3":
			//결제
			cs.payCharging();
			cs.deletCharging();
			chargingMenu();
			break;
		case "4":
			//초기화면
			logoutMenu();
			break;
		}
	}
	
	
	//로그인 이후 화면(회원) -> 전기차 충전
	public void memberChargingMenu() {
		System.out.println();
		System.out.println();
		System.out.println("======================================================================");
		System.out.println();
		System.out.println("| 1. 빈자리 조회 | 2. 충전 등록 | 3. 결제 및 등록해제 | 4. 초기화면 |");
		System.out.println();
		System.out.println("======================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//빈자리 조회
			cs.emptyCheck();
			memberChargingMenu();
			break;
		case "2":
			//회원용 충전 등록
			cs.memRegisCharging();
			memberChargingMenu();
			break;
		case "3":
			//회원용 결제 및 등록해제
			cs.memPayCharging();
			cs.deletCharging();
			memberChargingMenu();
			break;
		case "4":
			//초기화면
			loginMenu();
			break;
		}
	}
	
	//로그인 이후 화면(회원) -> 게시판 선택 메뉴
	public void boardMenu() {
		System.out.println();
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.println("| 1. 공지사항 게시판 | 2. 건의 게시판  | 3. 빌런 저격하러 가기 | 4. 뒤로가기 |");
		System.out.println();
		System.out.println("============================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//공지사항 게시판
			nb.listNoticeBoard();
			memNoticeBoardMenu();
			break;
		case "2":
			//건의 게시판 메뉴로 이동
			sugBoardMenu();
			boardMenu();
			break;
		case "3":
			//빌런 저격하러 가기
			ms.snipeVillein();
			boardMenu();
			break;
		case "4":
			//뒤로가기
			loginMenu();
			break;
		}
	}
	
	//건의 게시판 메뉴
	public void sugBoardMenu() {
		System.out.println();
		System.out.println();
		System.out.println("====================================================================");
		System.out.println();
		System.out.println("| 1. 글쓰기  | 2. 건의 게시글  목록  | 3. 게시판 메뉴(뒤로 가기)  |");
		System.out.println();
		System.out.println("====================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//글쓰기
			sb.insertSuggestion();
			sugBoardMenu();
			break;
		case "2":
			//건의 게시글 목록
			sb.listSuggestBoard();
			viewSuggestBoard();
			break;
		case "3":
			//뒤로 가기
			boardMenu();
			break;
		}
	}
	
	
	//건의 게시글 보기
	public void viewSuggestBoard() {
		System.out.println();
		System.out.println();
		System.out.println("==========================================================================");
		System.out.println();
		System.out.println("| 1. 게시글 선택  | 2. 건의 게시글 목록으로 돌아가기 | 3. 이전 페이지 | 4. 다음 페이지 |");
		System.out.println();
		System.out.println("==========================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//게시글 선택
			sb.viewSuggestBoard();
			scom.listSugComment();
			SuggestCommentMenu();			
			break;
		case "2":
			//뒤로가기
			sugBoardMenu();
			break;
		case "3":
			//이전 페이지
			if(sb.page != 1) {
				sb.page--;
			}else {
				System.out.println("첫 페이지입니다.");
			}
			sb.listSuggestBoard();
			viewSuggestBoard();
			break;
		case "4":
			//다음 페이지
			if(sb.page != sb.totalpage) {
				sb.page++;
			}else {
				System.out.println("마지막 페이지입니다.");
			}
			sb.listSuggestBoard();
			viewSuggestBoard();
			break;
		}
	}
	
	
	//page++;
	//listSuggestBoard();
	//댓글 (회원)
	public void SuggestCommentMenu() {
		System.out.println();
		System.out.println();
		System.out.println("================================================================================================");
		System.out.println();
		System.out.println("| 1. 댓글 입력  | 2. 댓글 수정  | 3. 댓글 삭제 | 4. 게시글 수정  | 5. 게시글 삭제  | 6. 뒤로 가기 |");
		System.out.println();
		System.out.println("================================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//댓글 입력
			scom.insertSugComment();
			sb.viewSuggestBoard2();
			scom.listSugComment();
			SuggestCommentMenu();
			break;
		case "2":
			//댓글 수정
			scom.modifySugComment();
			sb.viewSuggestBoard2();
			scom.listSugComment();
			SuggestCommentMenu();
			break;
		case "3":
			//댓글 삭제
			scom.deleteSugComment();
			scom.SugComReordering();
			sb.viewSuggestBoard2();
			scom.listSugComment();
			SuggestCommentMenu();
			break;
		case "4":
			//게시글 수정
			sb.memUpdateSuggest();
			sb.viewSuggestBoard2();
			scom.listSugComment();
			SuggestCommentMenu();
			break;
		case "5":
			//게시글 삭제
			sb.memDeleteSuggest();
			sb.reordering();
			scom.listSugComment();
			SuggestCommentMenu();
			break;
		case "6":
			//뒤로가기
			sb.listSuggestBoard();
			viewSuggestBoard();
			break;
		}
	}
	
	
}
