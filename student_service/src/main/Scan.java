package main;

import crud.DAO;
import crud.Service;
import dto.Student;
import dto.Teacher;

import java.util.Scanner;

public class Scan {
    public static Scanner sc = new Scanner(System.in);

    //dao
    public void start(){

        int i = 0;
        DAO dao  = new DAO();
        System.out.println("학생 정보 시스템을 시작합니다.");
        System.out.println("아이디와 비밀번호를 입력하세요.");
        System.out.println("학생은 본인의 학생번호가 Id 입니다.");

        System.out.print("Id : " );
        String id = Scan.sc.nextLine();

        System.out.print("비밀번호 : ");
        String pw = Scan.sc.nextLine();

        i = Scan.login(id,pw);
        if(i == 0){
            teacherScan();
            while (i != 6) {
                i = Scan.sc.nextInt();
                switch (i) {
                    case 1:
                        dao.createTable();
                        System.out.println("신규 생성 할 정보를 입력 해 주세요.");
                        System.out.println("이름, 나이, 국어점수, 영어점수, 수학점수, 비밀번호");
                        returnStu();
                        Student stu = new Student();
                        dao.save(stu);
                        break;

                    case 2:
                        System.out.println("전체 조회는 1번, \n개인별 조회는 2번을 눌러주세요.");
                        int a = Scan.sc.nextInt();
                        if(a == 1){
                            dao.read1();
                        }else if(a == 2){
                            System.out.println("조회 할 학생 번호를 입력하세요.");
                            int sno = Scan.sc.nextInt();
                            dao.read2(sno);
                        }
                        break;

                    case 3:
                        System.out.println("업데이트 할 번호를 입력해주세요.");
                        int sno = Scan.sc.nextInt();
                        System.out.println("이름, 나이, 국어점수, 영어점수, 수학점수, 비밀번호");
                        Scan.sc.nextLine();
                        dao.update(sno);
                        break;

                    case 4:
                        System.out.println("삭제 하실 학생의 번호를 입력해 주세요");
                        Scan.sc.nextLine();
                        dao.delete();
                        break;
                    case 5 :
                        Service serv = new Service();
                        serv.oneAverageScore();
                }

            }

        }else if(i == 1){

            studentScan();
            int sno = Scan.sc.nextInt();
            System.out.println("조회 할 번호를 입력하세요.");
            dao.read2(sno);

        }

    }

    public void teacherScan(){
        System.out.println("****** 학생 정보 시스템 ****** \n원하시는 메뉴를 선택하세요.");
        System.out.println("1. 신규 학생 추가");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 회원 정보 변경");
        System.out.println("4. 회원 정보 삭제");
        System.out.println("5. 종료");
        System.out.print("입력 : ");

    }

    public void studentScan(){
        System.out.println("****** 학생 정보 시스템 ****** \n원하시는 메뉴를 선택하세요.");
        System.out.println("1. 학생 정보");
        System.out.println("2. 종료");
        System.out.print("입력 : ");
    }

    public static int login(String id, String pw){
        Student stu = new Student();
        Teacher tc = new Teacher();
        Scan scan = new Scan();

        if(id.equals(tc.gettID()) && pw.equals(tc.getTpassword())){
            scan.teacherScan();
        } else if (pw.equals(stu.getPassword())){
            scan.studentScan();
            return 1;
        } else {
            System.out.println("비정상적 접근입니다.");
            return 5;
        }
        return 0;
    }

    public Student returnStu(){
        String name = Scan.sc.nextLine();
        int age = Scan.sc.nextInt();
        int k_score = Scan.sc.nextInt();
        int e_score = Scan.sc.nextInt();
        int m_score = Scan.sc.nextInt();
        Scan.sc.nextLine();
        String password = Scan.sc.nextLine();

        Student stu = new Student();
        stu.setName(name);
        stu.setAge(age);
        stu.setK_score(k_score);
        stu.setK_score(e_score);
        stu.setK_score(m_score);
        stu.setPassword(password);
        return stu;
    }




}
