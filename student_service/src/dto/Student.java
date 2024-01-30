package dto;

public class Student {
    //학생이름 학생번호 국영수 , 총점출력
    private int sno;
    private String name;
    private int age;
    private int k_score;
    private int e_score;
    private int m_score;
    private String password;

    public Student(){}

    public Student(int sno,String name,int age,int k_score,int e_score,int m_score, String password){
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.k_score = k_score;
        this.e_score = e_score;
        this.m_score = m_score;
        this.password = password;

    }

    @Override
    public String toString(){

        return " 번호 : " + sno +
                "\n 이름 : " + name +
                "\n 나이 : " + age +
                "\n 국어성적 : " + k_score +
                "\n 영어성적 : " + e_score +
                "\n 수학성적 : " + m_score ;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getK_score() {
        return k_score;
    }

    public void setK_score(int k_score) {
        this.k_score = k_score;
    }

    public int getE_score() {
        return e_score;
    }

    public void setE_score(int e_score) {
        this.e_score = e_score;
    }

    public int getM_score() {
        return m_score;
    }

    public void setM_score(int m_score) {
        this.m_score = m_score;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
