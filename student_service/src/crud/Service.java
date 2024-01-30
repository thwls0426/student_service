package crud;

import dto.Student;
import main.Scan;

public class Service {
    Student stu = new Student();

    public int stuTotalScore(){
        int sno = Scan.sc.nextInt();
        DAO dao = new DAO();
        dao.read2(sno);
        int total = stu.getK_score() + stu.getM_score() + stu.getE_score();
        System.out.print("총 점수 합은 : ");
        return total;
    }

    public int oneAverageScore(){

        System.out.print("해당 학생의 평균 : ");
        return stu.getK_score() + stu.getM_score() + stu.getE_score()/3;
    }





}
