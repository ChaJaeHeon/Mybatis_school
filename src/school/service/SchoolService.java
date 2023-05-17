package school.service;

import school.ui.*;

import java.util.ArrayList;

import school.dao.*;
import school.vo.*;
//기능을 처리함

public class SchoolService {
	SchoolDao dao = new SchoolDao();
	
	public void inputStudent(Student s) {
		dao.insert(s);
	}

	public ArrayList<Student> getList() {
		ArrayList<Student> studentlist = dao.getList();
		return studentlist;
	}

	//dao에서 학번을 검색하여 있(으면 해당 정보값 삭제)는지 없는지를 확인한 값(논리값)을 리턴받아 리턴받는 메서드
	public boolean deleteStudent(String id) {
		return dao.delete(id);
	}

	//dao에서 검색한 값을 리턴받아 UI에 리턴하는 메서드
	public ArrayList<Student> searchStudent(String str, int n) {
		if(n==2)
			return dao.searchName(str);
		else if(n==1)
			return dao.searchId(str);
		else return null;
	}
	//UI에서 입력한 값 이상/이하의 값을 dao에서 찾아 리턴하는 메서드
	public ArrayList<Student> searchUpper(String c, String score) {
		int num = Integer.parseInt(score);
		return dao.searchUpper(c,num);
	}
	public ArrayList<Student> searchLower(String c, String score) {
		int num = Integer.parseInt(score);
		return dao.searchLower(c,num);
	}
	//dao에서 검색한 값을 리턴받는 등급검색 메서드
	public ArrayList<Student> searchGrade(String choice) {
		return dao.searchGrade(choice);
	}

	public void save() {
		dao.save();
	}

//	public void save() {
//		dao.save();
//	}

}
