package school.dao;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import school.ui.*;
import school.vo.*;
//실제로 데이터가 존재하는 곳
import school.dao.MybatisConfig;
import school.dao.StudentMapper;
import school.vo.Student;

public class SchoolDao {//실제 데이터가 저장되는 클래스
	ArrayList<Student> list;
	private static final String FILE_NAME = "student.sch";
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	public void insert(Student s) {
		SqlSession ss = null;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			mapper.insert(s);
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
	}
	
	public ArrayList<Student> getList() {
		return list;
	}

	public boolean delete(String id) {
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId())) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}


	public ArrayList<Student> searchName(String name) {
		ArrayList<Student> result = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(name.contains(list.get(i).getName()))
				result.add(list.get(i));
		}
		
		return result;
	}

	public ArrayList<Student> searchId(String id) {
		ArrayList<Student> st = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(id.equals(list.get(i).getId()))
				st.add(list.get(i));
		}
		
		return st;
	}
	
	public ArrayList<Student> searchUpper(String c, int num) {
		ArrayList<Student> st = new ArrayList<>();
		int score=0;
		for(int i=0;i<list.size();i++) {
			switch(c) {
			case "1":
				score=list.get(i).getKor();
				break;
			case "2":
				score=list.get(i).getEng();
				break;
			case "3":
				score=list.get(i).getMat();
				break;
			case "4":
				score=list.get(i).getTotal();
				break;
			case "5":
				score=(int)list.get(i).getAvg();
				break;
			}
			if(score>=num)
				st.add(list.get(i));
		}
		
		return st;
	}
	public ArrayList<Student> searchLower(String c, int num) {
		ArrayList<Student> st = new ArrayList<>();
		int score=0;
		for(int i=0;i<list.size();i++) {
			switch(c) {
			case "1":
				score=list.get(i).getKor();
				break;
			case "2":
				score=list.get(i).getEng();
				break;
			case "3":
				score=list.get(i).getMat();
				break;
			case "4":
				score=list.get(i).getTotal();
				break;
			case "5":
				score=(int)list.get(i).getAvg();
				break;
			}
			if(score<=num)
				st.add(list.get(i));
		}
		
		return st;
	}
	public ArrayList<Student> searchGrade(String grade) {
		ArrayList<Student> st = new ArrayList<>();
		switch(grade.toUpperCase()) {
		case "A":case "B":case "C":case "D":case "E":case "F":break;
		default:return null;
		}
		
		for(int i=0;i<list.size();i++) {
			if(grade.equals(list.get(i).getGrade()))
				st.add(list.get(i));
		}
		
		return st;
	}

	public void save() {
		
	}
	
	
}