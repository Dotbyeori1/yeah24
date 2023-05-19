package kdgjava;

import java.util.*;
import kdgjava.*;

public class main {

	public static Scanner in = new Scanner(System.in);
	public static method method = new method();
	
	public static void main(String[] args) {
		boolean run = true;
		method.adminadd();
		method.firstadd();
		while(run) {
		System.out.println("-----------[YEAH24]------------");
		System.out.println("1. 회원가입\t 2. 로그인 ");
		System.out.println("3. 회원정보\t 4. 책구입하기");
		System.out.println("5. 장바구니\t 6. 로그아웃");
		System.out.println("7. 종료\t\t 8. 관리자모드");
		System.out.println("-------------------------------");
		System.out.print("원하시는 메뉴를 선택하세요 : ");
		int select = in.nextInt();
		switch(select) {
			case 1:
				method.join();					
				break;
			case 2:
				method.login();					
				break;
			case 3:
				method.memberInfo();					
				break;
			case 4:
				method.buy();					
				break;
			case 5:
				method.cartlist();					
				break;
			case 6:
				method.logout();			
				break;
			case 7:
				System.out.println("종료합니다");					
				return;
			case 8:
				method.admin();					
				break;
			default:
				System.out.println("입력이 올바르지 않습니다.");					
				break;
			} //switch(run) 종료
		} // while(run) 종료
	}

}
