package school.ui;

import school.service.*;
import school.dao.*;
import school.vo.*;

/**
 * 성적처리 프로그램의 시작
 * @seoholee 2023.04.27 생성
 * 
 *
 */
public class SchoolMain {
	public static void main(String[] args) {
		new SchoolUi();//
		/*schoolUI ui 생성됨
		 *특별한 일이 없으면 public, return값이 없고, 클래스 이름과 같아야함,
		 * 매개변수가 하나도 없어야함,
		 * overload해서 여러개 만들 수 있다
		 * 여기서는 기본 생성자만 사용한다
		 * 
		 * 생성자는 기본적으로 while(true)로 계속 돌아감
		 * UI생성자 종료시 이곳으로 다시 되돌아오며, 이후 코드가 없으므로 자동으로 프로그램 종료.
		*/
	}//main 끝
}