package kdgjava;

import java.util.*;
import kdgjava.*;

public class method extends admin {
	
	public static String useid;
	
	// 1. 회원가입
	public void join() {
		if(login == true) {
			System.out.println("이미 로그인 되어 있습니다.");
			return;
		}
		System.out.println("------------[회원가입]-------------");
		System.out.print("아이디 (ID) : ");
		String tempid = in.next();
		System.out.print("패스워드 (Password) : ");
		String temppw = in.next();
		System.out.print("이름 : ");
		String tempName = in.next();
		System.out.print("생년월일 : ");
		String tempBirth = in.next();
		System.out.print("전화번호 : ");
		String tempTel = in.next();
		System.out.print("우편번호 : ");
		int tempPostal = Integer.parseInt(in.next()); 
		in.nextLine();
		System.out.print("주소 : ");
		String tempAddress = in.nextLine();
		boolean admin = false;
		for(int i=0; i < member.size(); i++) {
			if(tempid.equals(member.get(i).getId())) {
				System.out.println("아이디가 중복됩니다. 다시 시도하여 주세요.");
				return;
			}
		}
		member.add(new member(tempid, temppw, tempName, tempBirth, tempTel, tempAddress, tempPostal, admin));
		System.out.println("회원가입이 완료 되었습니다. 로그인 해주세요.");
	}
	
	// 2. 로그인
	public void login() {
		if(login == true) {
				System.out.println("이미 로그인 되어 있습니다.");
				return;
			}
		boolean loging = false; 
		System.out.println("------------[로그인]---------------");
		for(int i=0; i<3 ; i++ ) {
			System.out.print("아이디(ID) : ");
			String tempid = in.next();
			System.out.print("비밀번호(Password) : ");
			String temppw = in.next();
				for(int j=0; j < member.size(); j++) {
					if(tempid.equals(member.get(j).getId())) {
						if(temppw.equals(member.get(j).getPassword())) {
							System.out.println("로그인 되었습니다.");
							login = true; loging = true;
							useid = member.get(j).getId();
							logined = member.get(j);
							return;
						} else {loging = false; }
					} else {loging = false; }
				}
			if(loging == false) {
				System.out.println("로그인 실패하였습니다. 다시 시도하여 주십시오. " + (i+1) + "회 시도");
			}
		}// 회원로그인 3회
		System.out.println("로그인시도 횟수가 3회를 초과하여 종료되었습니다.");
	}
	
	// 3. 회원정보
	public void memberInfo() {
		if(login == false) {
			System.out.println("로그인상태가 아닙니다. 로그인 해주세요");
			return;
		} 
		boolean run = true; 
				while(run) {
				System.out.println("----------------[회원정보]---------------");
				System.out.println("아이디(ID) : " + logined.getId());
				System.out.println("비밀번호(Password) : " + logined.getPassword());
				System.out.println("이름 : " + logined.getName());
				System.out.println("생년월일 : " + logined.getBirth());
				System.out.println("전화번호 : " + logined.getTel());
				System.out.println("주소 : " + logined.getAddress());
				System.out.println("우편번호 : " + logined.getPostal());
				System.out.println("------------------------------------");
				System.out.println("1. 주소수정\t 2. 우편번호수정\t 3. 전화번호수정\t 4. 메인으로");
				System.out.println("------------------------------------");
				System.out.print(">>>>>>>> ");
				int select = in.nextInt();
				switch(select) {
					case 1:
						System.out.println("---------[주소수정]----------");
						System.out.print("주소를 입력해주세요 : ");
						in.nextLine();
						String tempAddress = in.nextLine();
						logined.setAddress(tempAddress);
						break;
					case 2:
						System.out.println("----------[우편번호수정]----------");
						System.out.print("우편번호를 입력해주세요 : ");
						int tempPostal = in.nextInt();
						logined.setPostal(tempPostal);
						break;
					case 3:
						System.out.println("-----------[전화번호수정]----------");
						System.out.print("전화번호를 입력해주세요 : ");
						String tempTel = in.next();
						logined.setTel(tempTel);
						break;
					case 4:
						System.out.println("메인으로 돌아갑니다.");
						run = false;
						return;
					default:
						System.out.println("올바른 번호를 입력해주세요.");
						break;
				} // switch(select)	
			} // while(run)
	} // 회원정보 수정 종료

	
	// 4. shop
	public void buy() {
		if(login == false) {
			System.out.println("로그인상태가 아닙니다. 로그인 해주세요");
			return;
		} 
		boolean shop = true;
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("상품번호\t ID\t 책제목\t 저자\t 출판사\t 발행일자\t\t 가격");
		System.out.println("-------------------------------------------------------------------------");	
		for(int i=0; i < book.size(); i++) {
			System.out.print(i+1 + "\t");
			System.out.print(book.get(i).getBookid()+"\t");
			System.out.print(book.get(i).getTitle()+"\t");
			System.out.print(book.get(i).getWriter()+"\t");
			System.out.print(book.get(i).getCompany()+"\t");
			System.out.print(book.get(i).getPrintedDate()+"\t");
			System.out.print(book.get(i).getPrice());
			System.out.println("");
		}	
		System.out.println("-------------------------------------------------------------------------");
		while(shop) {
			System.out.print("구입하실려면 1번을 종료하실려면 2번을 입력하세요. : ");
			int select = in.nextInt();
			if(select==1) {
				System.out.print("원하시는 상품 번호를 입력하세요 : ");
				int bookid = in.nextInt();
				System.out.print("구입할 책의 수량을 입력하세요 : ");
				int count = in.nextInt();
				if((bookid > 0 ) &&(bookid <= book.size())) {
				boolean search = false;
					for(int i=0; i < cart.size(); i++) {
					if(useid.equals(cart.get(i).getId())){
							if(cart.get(i).getOrderNumber() == book.get(bookid-1).getBookid()) {
							cart.get(i).setCount(cart.get(i).getCount()+count);
							search = true;				
							}
					 	} else { search = false; }
					}
					if(search == false) { cart.add(new cart(useid, book.get(bookid-1).getBookid(), count )); }
				} else { System.out.println("상품번호가 올바르지 않습니다.");} // 상품번호 검증 if
			} else if(select==2) {
				System.out.println("구입을 종료합니다.");
				return;
			} else {System.out.println("입력이 올바르지 않습니다."); }
		}//while

	}
	
	public void cartlist() {
		if(login == false) {
			System.out.println("로그인상태가 아닙니다. 로그인 해주세요");
			return;
		} 
		boolean on = true;
		while(on) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("상품번호\t ID\t 책제목\t 저자\t 출판사\t 발행일자\t\t 가격\t 구입수량\t 총가격");
			System.out.println("-------------------------------------------------------------------------");	
			for(int j=0; j < cart.size(); j++ ) {
				if(useid.equals(cart.get(j).getId())) {
					for(int i=0; i < book.get(i).getBookid(); i++) {
						if(cart.get(j).getOrderNumber()==book.get(i).getBookid()) {
						System.out.print((j+1) + "\t");
						System.out.print(book.get(i).getBookid()+"\t");
						System.out.print(book.get(i).getTitle()+"\t");
						System.out.print(book.get(i).getWriter()+"\t");
						System.out.print(book.get(i).getCompany()+"\t");
						System.out.print(book.get(i).getPrintedDate()+"\t");
						System.out.print(book.get(i).getPrice()+"\t");
						System.out.print(cart.get(j).getCount()+"\t");
						System.out.print(sum(j,i));
						System.out.println("");
						System.out.println("-------------------------------------------------------------------------");
						break;
					}
				}
			}
		} 
		System.out.print("수량수정은 1번 삭제는 2번 종료는 3번 : ");
		int temp = in.nextInt();
		if(temp == 1) {
			System.out.print("수정하실 상품의 번호를 입력하세요. : ");
			int select = in.nextInt();
			System.out.print("몇 개로 수정 하시겠습니까? : ");
			int editCount = in.nextInt();
			for(int i=0; i < cart.size(); i++) {
				if(useid.equals(cart.get(i).getId())) {
					cart.get(select-1).setCount(editCount);
				}
			}
		} else if (temp == 2) {
			System.out.print("삭제하실 상품의 번호를 입력하세요. : ");
			int select = in.nextInt();
			cart.remove(select-1);
		} else if (temp == 3) {
			System.out.println("메인으로 돌아갑니다.");
			on = false;
		} else {
			System.out.println("입력이 올바르지 않습니다.");
		}
		
		
		} // while 종료
	} // cartlist 종료
	
	public int sum(int j, int i) {
		int sum=0;
		sum = cart.get(j).getCount() * book.get(i).getPrice();
		return sum;
	}
	
	public void logout() {
		useid = null;
		login = false;
		logined = null;
		System.out.println("로그아웃 되었습니다.");
	}
}
