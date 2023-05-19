package kdgjava;

import java.util.*;

public class admin {
	public static Scanner in = new Scanner(System.in);
	public static ArrayList<member> member = new ArrayList<member>();
	public static List<cart> cart = new ArrayList<cart>();
	public static List<book> book = new ArrayList<book>(); // List ArrayList 가능! List List는 안됨 (사이즈)
	public static HashMap<Integer, Integer> bookIdmap = new HashMap<>();
	public static member logined = null;
	public static boolean login = false;
	public static boolean adminOn = false;
	
	//관리자 생성
	public void adminadd() {
	member.add(new member("admin", "admin", "admin","admin", "010-7281-2628", "admin", 0, true));	
	member.add(new member("blbl9857", "app1esata1", "김대건", "911010", "010-1234-5678", "경기도 화성시", 12345, false));
	member.add(new member("kus9857", "app1esata1", "김자바", "001010", "010-4321-1234", "경기도 수원시", 54321, false));
	}
	// 초기 상품 추가
	public void firstadd() {
		int bookid; String title; String writer; String compnay; int date; int price;
		bookid = 10001; title = "노인과바다"; writer = "허밍웨이"; compnay = "Y랩"; date = 20180322; price =20000;
		book.add(new book(bookid, title, writer, compnay, date, price));	
		bookid = 10002; title = "해리포터"; writer = "롤리롤링"; compnay = "C랩"; date=20180325; price =18000;
		book.add(new book(bookid, title, writer, compnay, date, price));	
		bookid = 10003; title = "반지의제왕"; writer = "도비이즈프리"; compnay = "D랩"; date=20190405; price =32000;
		book.add(new book(bookid, title, writer, compnay, date, price));	
	}
	
	public void admin() {
		boolean adminLogin = false;
		System.out.println("----------[관리자 로그인]-----------");
		System.out.print("ID : ");
		String tempAdminid = in.next();
		System.out.print("Password : ");
		String tempAdminPasswrod = in.next();
		for(int i=0; i < member.size(); i++) {
			if(tempAdminid.equals(member.get(i).getId())) {
				if(tempAdminPasswrod.equals(member.get(i).getPassword())) {
					if(member.get(i).isAdmin())
						adminOn = true; adminLogin = true;
						break;
				}else { adminLogin = false; }
			}else { adminLogin = false; }
		}
		if(adminLogin == false) {
			System.out.println("ID나 비밀번호가 틀리거나, 관리자계정이 아닙니다.");
		}
		while(adminOn) {
			System.out.println("--------------[관리자모드]--------------");
			System.out.println("1. 상품 추가하기\t 2. 상품 목록 보기 및 삭제");
			System.out.println("3. 주문 현황 보기\t 4. 판매량 조회");
			System.out.println("5. 종료하기");
			System.out.println("-------------------------------------");
			System.out.print("원하시는 메뉴를 선택하세요 : ");
			int adminSelect = in.nextInt();
			switch(adminSelect) {
				case 1:
					bookadd();
					break;
				case 2:
					booklist();
					break;
				case 3:
					orderlist();
					break;
				case 4:
					salereport();
					break;
				case 5:
					System.out.println("관리자 모드를 종료합니다.");
					adminOn = false;
					break;
				default :
					System.out.println("입력이 잘 못 되었습니다.");
					break;
			}
		} // while 종료
	} // admin 메서드 종료

	public void bookadd() {
		System.out.println("--------------[상품 추가]---------------");
		System.out.print("bookid : ");
		int tempBookid = in.nextInt();
		System.out.print("책 제목(title) : ");
		String tempBookTitle = in.next();
		System.out.print("저자 : ");
		String tempBookWriter = in.next();
		System.out.print("출판사 : ");
		String tempBookCompany = in.next();
		System.out.print("발행일자(YYYYMMDD) : ");
		int tempBookDate = in.nextInt();
		System.out.print("가격 : ");
		int tempBookPrice = in.nextInt();
		for(int i=0; i < book.size(); i++) {
			if(tempBookid == book.get(i).getBookid()) {
				System.out.println("상품ID가 중복되어 추가되지 않았습니다.");
				return;
			}
		}
		book.add(new book(tempBookid, tempBookTitle, tempBookWriter, tempBookCompany, tempBookDate, tempBookPrice));
	}
	
	public void booklist() {
	boolean rewrite = true;
	while(rewrite) {	
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("NO\t ID\t 책제목\t 저자\t 출판사\t 발행일자\t\t가격");
		System.out.println("-------------------------------------------------------------------------");
		for(int i=0; i < book.size(); i++) {
			System.out.print((i+1) + "\t");
			System.out.print(book.get(i).getBookid()+"\t");
			System.out.print(book.get(i).getTitle()+"\t");
			System.out.print(book.get(i).getWriter()+"\t");
			System.out.print(book.get(i).getCompany()+"\t");
			System.out.print(book.get(i).getPrintedDate()+"\t");
			System.out.print(book.get(i).getPrice());
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.print("원하시는 메뉴를 선택하세요(1. 상품삭제 | 2. 돌아가기) : ");
		int select = in.nextInt();
		if(select == 1) {
			System.out.print("삭제하실 상품의 번호를 입력하세요 : ");
			int no = in.nextInt();
			if((no > 0)&& (no <= book.size())) {
			book.remove(no-1);
			} else { System.out.println("상품의 번호가 틀립니다."); }
		} else if (select == 2) {
			System.out.println("상품리스트 보기를 종료합니다.");
			rewrite = false;
		} else { System.out.println("입력이 올바르지 않습니다");}
	} // while 종료
	}
	
	public void orderlist() {
		System.out.println("주문자명\t 주문상품\t 수량\t 전화번호\t\t 우편번호\t 주소");
		System.out.println("-------------------------------------------------------");
		for(int i=0; i < cart.size(); i++) {
			System.out.print(cart.get(i).getId() + "\t");
			for(int j=0; j< book.size(); j++ ) {
				if(cart.get(i).getOrderNumber() == book.get(j).getBookid()) {
					System.out.print(book.get(j).getTitle() + "\t");
					break;
				}
			}
			System.out.print(cart.get(i).getCount() + "\t");
			for(int j=0; j< member.size(); j++) {
				if(cart.get(i).getId() == member.get(j).getId()) {
					System.out.print(member.get(j).getTel() + "\t");
					System.out.print(member.get(j).getPostal() + "\t");
					System.out.print(member.get(j).getAddress() + "\t");
					break;
				}
			}
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------");
		System.out.print("종료는 1번을 눌러주세요 : ");
		int select = in.nextInt();
		if(select == 1) { return; }
	}
	
	public void salereport() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("NO\t ID\t 책제목\t 저자\t 출판사\t 가격\t 판매량");
		System.out.println("-------------------------------------------------------------------------");
		for(int i=0; i < book.size(); i++) {
			System.out.print((i+1) + "\t");
			System.out.print(book.get(i).getBookid()+"\t");
			System.out.print(book.get(i).getTitle()+"\t");
			System.out.print(book.get(i).getWriter()+"\t");
			System.out.print(book.get(i).getCompany()+"\t");
			System.out.print(book.get(i).getPrice()+ "\t");
			System.out.print(booksum(i));
			System.out.println("");
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.print("종료는 1번을 눌러주세요 : ");
		int select = in.nextInt();
		if(select == 1) { return; }
	}
	
	public int booksum(int i) {
		int sum=0;
			for(int j=0; j < cart.size(); j++) {
				if(cart.get(j).getOrderNumber() == book.get(i).getBookid()) {
					sum = sum + cart.get(j).getCount();	
				}
			}
		return sum;
	}
}
