
package school.ui;

import school.service.*;

import java.util.ArrayList;
import java.util.Scanner;

import school.dao.*;
import school.vo.*;
//입력받고  출력

public class SchoolUi {
	//멤버변수 위치
	Scanner keyin =new Scanner(System.in);
	SchoolService service = new SchoolService();//타 패키지의 schoolservice 클래스의 생성자를 통해 생성한 클래스 인스턴스. uI구동에 필요한 각 기능들이 들어있음
	String choice;
	
	public SchoolUi() {
		while(true) {//schoolMain을 통해 실행되어 종료 커맨드를 입력하기 전까지 계속 돌아감
			mainMenu();//UI의 메인메뉴. 가장 기반이 되는 메서드 호출
			choice = keyin.nextLine();//mainMenu의 출력문에 따라 입력받음
			
			switch(choice) {//입력받은 choice에 따라 해당 선택지의 메서드 출력, 종료시 생성자 종료
			case "1" : input();		break;
			case "2" : list(); 		break;
			case "3" : search();	break;
			case "4" : delete();	break;
			case "0" : exit();		return;
			default:
				System.out.println("선택 오류...");
				keyin.nextLine();
			}//switch 종료
		}//while 종료
	}//생성자 종료
	
	
	void mainMenu() {
		//메인메뉴 출력
		System.out.println();
		System.out.println(">원하는 명령어를 입력하시오_");
		System.out.println(">1.학생 성적 입력");
		System.out.println(">2.전체 목록 출력");
		System.out.println(">3.학생 정보 검색");
		System.out.println(">4.학생 정보 삭제");
		System.out.println(">0.프로그램 종료");
		System.out.print("->");
	}

	//입력 UI
	private void input() {
		System.out.println("학생정보 입력UI로 이동합니다...");

		System.out.println("[1.학생 성적 입력]");
		String name, id, phone;//학생 이름, 학번, 전화번호 변수
		int k, e, m;//학생 국어, 영어, 수학점수 변수
		
		//6종의 변수를 스캐너로 입력받는다
		System.out.print("이름 입력 : ");
		name = keyin.nextLine();
		System.out.print("학번 입력 : ");
		id = keyin.nextLine();
		System.out.print("전화번호 입력 : ");
		phone = keyin.nextLine();
		System.out.print("국어점수 입력 : ");
		k = keyin.nextInt();
		System.out.print("영어점수 입력 : ");
		e = keyin.nextInt();
		System.out.print("수학점수 입력 : ");
		m = keyin.nextInt();
		keyin.nextLine();
		
		Student st = new Student(name, id, phone, k, e, m);
		service.inputStudent(st);
		System.out.println("저장되었습니다.");
		
	}//입력UI 종료
	
	//출력UI
	private void list() {
		System.out.println("학생정보 출력UI로 이동합니다...");
		
		System.out.println("[2.전체 목록 출력]");
		ArrayList<Student> st_list = service.getList();
		for(int i=0;i<st_list.size();i++) {
			System.out.println(st_list.get(i));
		}
		
	}
	//검색UI
	private void search() {
		System.out.println("학생정보 검색UI로 이동합니다...");
		while(true) {

			System.out.println("[3.학생 정보 검색]");
			
			System.out.println("어떤 방식으로 검색할지 선택하시오");
			System.out.println("1.학번으로 검색");
			System.out.println("2.이름으로 검색");
			System.out.println("3.점수로 검색(세부 메뉴로 넘어감)");
			System.out.println("0.검색 종료");
			System.out.print("->");
			choice = keyin.nextLine();
			
			switch(choice) {
			case "1":
				searchId();
				break;
			case "2":
				searchName();
				break;
			case "3":
				searchScore();
				break;
			case "0":exit();return;
			default:
				System.out.println("선택 오류...");
			}
		}
	}//검색 끝
	
	//search메서드에 종속된 메서드들
	private void searchId() {
		System.out.println("검색하고 싶은 학생의 학번을 입력하시오");
		System.out.print("->");
		String id = keyin.nextLine();
		ArrayList<Student> slist = service.searchStudent(id,2);
		
		if(slist.isEmpty()) {
			System.out.println("입력한 학번에 해당하는 학생의 정보를 찾을 수 없습니다.");
		}else {
			System.out.println("이름/학번/총점/평균");
			System.out.println("-----------------------");
			for(int i=0;i<slist.size();i++) {
				System.out.printf("%s / %s / %d / %.2f\n",slist.get(i).getName(),slist.get(i).getId(),
						slist.get(i).getTotal(),slist.get(i).getAvg());
			}
		}
	}//id검색 끝
	private void searchName() {
		System.out.println("검색하고 싶은 학생의 학번을 입력하시오");
		System.out.print("->");
		String name = keyin.nextLine();
		ArrayList<Student> slist = service.searchStudent(name,1);
		
		if(slist.isEmpty()) {
			System.out.println("입력한 학번에 해당하는 학생의 정보를 찾을 수 없습니다.");
		}else {
			System.out.println("이름/학번/총점/평균");
			System.out.println("-----------------------");
			for(int i=0;i<slist.size();i++) {
				System.out.printf("%s / %s / %d / %.2f\n",slist.get(i).getName(),slist.get(i).getId(),
						slist.get(i).getTotal(),slist.get(i).getAvg());
			}
		}
	}//이름검색 끝
	
	private void searchScore() {
		while(true) {
			System.out.println("어떤 방식으로 검색할지 선택하시오");
			System.out.println("1.국어점수 검색");
			System.out.println("2.영어점수 검색");
			System.out.println("3.수학점수 검색");
			System.out.println("4.총합점수 검색");
			System.out.println("5.평균점수 검색");
			System.out.println("6.성적등급 검색");
			System.out.println("0.검색 종료");
			System.out.print("->");
			choice = keyin.nextLine();
			
			switch(choice) {
			case "1": case "2": case "3":
				searchScoreMenu(choice);
				break;
			case "4":
				searchTotal();
				break;
			case "5":
				searchAvg();
				break;
			case "6":
				searchGrade();
				break;
			case "0":exit();return;
			default:
				System.out.println("선택 오류...");
			}
		}
	}//점수검색 끝

	//점수검색 소분류 메서드
	private void searchScoreMenu(String c) {
		System.out.println("임의의 점수를 입력하시오");
		System.out.print("->");
		choice = keyin.nextLine();
		
		while(true) {
			System.out.println("1.해당 점수 이상을 검색");
			System.out.println("2.해당 점수 이하를 검색");
			System.out.println("0.검색 취소");
			System.out.print("->");
			choice = keyin.nextLine();
			if(choice.equals("1")) {
				searchUpper(c,choice);
			}else if(choice.equals("2")) {
				searchLower(c,choice);
			}else if(choice.equals("0")) {
				System.out.println("검색을 취소합니다.");
				return;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	private void searchUpper(String c, String score) {

		ArrayList<Student> slist = service.searchUpper(c,score);
		
		if(slist.isEmpty()){
			System.out.println("입력한 점수 이상인 성적을 가진 학생의 정보를 찾을 수 없습니다.");
		}else {
			System.out.println("이름/학번/총점/평균");
			System.out.println("-----------------------");
			for(int i=0;i<slist.size();i++) {
				System.out.printf("%s / %s / %d / %.2f\n",slist.get(i).getName(),slist.get(i).getId(),
						slist.get(i).getTotal(),slist.get(i).getAvg());
			}
		}
	}
	private void searchLower(String c, String score) {
		ArrayList<Student> slist = service.searchLower(c,score);
		
		if(slist.isEmpty()) {
			System.out.println("입력한 점수 이상인 성적을 가진 학생의 정보를 찾을 수 없습니다.");
		}else {
			System.out.println("이름/학번/총점/평균");
			System.out.println("-----------------------");
			for(int i=0;i<slist.size();i++) {
				System.out.printf("%s / %s / %d / %.2f\n",slist.get(i).getName(),slist.get(i).getId(),
						slist.get(i).getTotal(),slist.get(i).getAvg());
			}
		}
	}
	private void searchTotal() {
		System.out.println("검색할 총합점수를 입력하시오.");
		System.out.print("->");
		choice = keyin.nextLine();
		
		while(true) {
			System.out.println("1.해당 점수 이상을 검색");
			System.out.println("2.해당 점수 이하를 검색");
			System.out.println("0.검색 취소");
			System.out.print("->");
			choice = keyin.nextLine();
			if(choice.equals("1")) {
				searchUpper("4",choice);
			}else if(choice.equals("2")) {
				searchLower("4",choice);
			}else if(choice.equals("0")) {
				System.out.println("검색을 취소합니다.");
				return;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	private void searchAvg() {
		System.out.println("검색할 평균점수(10점단위)를 입력하시오.");
		System.out.print("->");
		choice = keyin.nextLine();
		choice+="0";
		
		while(true) {
			System.out.println("1.해당 점수 이상을 검색");
			System.out.println("2.해당 점수 이하를 검색");
			System.out.println("0.검색 취소");
			System.out.print("->");
			choice = keyin.nextLine();
			if(choice.equals("1")) {
				searchUpper("5",choice);
			}else if(choice.equals("2")) {
				searchLower("5",choice);
			}else if(choice.equals("0")) {
				System.out.println("검색을 취소합니다.");
				return;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	private void searchGrade() {
		System.out.println("검색할 등급을 입력하시오.");
		System.out.print("->");
		choice = keyin.nextLine();
		ArrayList<Student> slist = service.searchGrade(choice);
		
		if(slist.isEmpty()){
			System.out.println("해당하는 등급의 학생이 없습니다.");
		}else {
			System.out.println("이름/학번/등급/평균");
			System.out.println("-----------------------");
			for(int i=0;i<slist.size();i++) {
				System.out.printf("%s / %s / %s / %.2f\n",slist.get(i).getName(),slist.get(i).getId(),
						slist.get(i).getGrade(),slist.get(i).getAvg());
			}
		}
	}

	//삭제UI
	private void delete() {
		System.out.println("학생정보 삭제UI로 이동합니다...");
		System.out.println("[4.학생 정보 삭제]");
		
		System.out.println("지울 학생의 학번을 입력하시오");
		System.out.print("->");
		String id = keyin.nextLine();
		
		if(service.deleteStudent(id)) {
			System.out.println("삭제하였습니다.");
		}else {
			System.out.println("입력한 학번에 해당하는 학생의 정보를 찾지 못했습니다.");
		}
	}
	//프로그램 종료 출력
	private void exit() {
		service.save();
		System.out.println("프로그램을 종료합니다...");
	}
	
	
}