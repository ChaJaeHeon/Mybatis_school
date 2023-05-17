package school.vo;

public class Student  extends Person {
private int kor;
private int eng;
private int mat;

//생성자
public Student() {
	super();
}
public Student(String name, String id, String phone,
		int kor,int eng,int mat) {//6종 전부 입력
	super(name,id,phone);
	this.kor=kor;
	this.eng=eng;
	this.mat=mat;
}

//getter setter 설정
public void setKor(int kor) {
	if(kor<0)this.kor=0;
	this.kor=kor;
}
public void setEng(int eng) {
	if(eng<0)this.eng=0;
	this.eng=eng;
}
public void setMat(int mat) {
	if(mat<0)this.mat=0;
	this.mat=mat;
}
public int getKor() {
	return kor;
}
public int getEng() {
	return eng;
}
public int getMat() {
	return mat;
}

//총합, 평균 계산하여 산출
public int getTotal() {
	int t=kor+eng+mat;
	return t;
}
public double getAvg() {
	double a = getTotal()/3.0;
	return a;
}
//성적등급 구하기
public String getGrade() {
	double a = getAvg();
	String g=null;
	switch((int)a/10) {
	case 10:case 9:g="A";break;
	case 8:g="B";break;
	case 7:g="C";break;
	case 6:g="D";break;
	default:g="F";
	}
	return g;
}

public boolean getGCode() {
	double a = getAvg();
	if(a>=70)return true;
	else
	return false;
}

public String toString() {
	String s=super.toString()+" 국어점수 : "+kor+
			"영어점수 : "+eng+"수학점수 : "+mat+" 총합: "+
			getTotal()+" 평균: "+getAvg();
	return s;
}

}
