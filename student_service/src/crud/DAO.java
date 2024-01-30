package crud;

import crud.utils.DBcon;
import main.Scan;
import dto.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private int sno;

    private String s;


    private Scan scan = new Scan();

    public void createTable(){
        try {
            s = "CREATE TABLE tbl_students (" +
                    "sno INT AUTO_INCREMENT primary key," +
                    "name VARCHAR(20), " +
                    "age INT," +
                    "k_score INT," +
                    "e_score INT," +
                    "m_score INT," +
                    "password VARCHAR(20))";
            PreparedStatement stmt = DBcon.getConnection().prepareStatement(s);
            stmt.executeUpdate();
            System.out.println("테이블생성");
        }catch (Exception e){
            e.getMessage();
        }
    }

    public int save(Student stu){
        try{
            s = "INSERT INTO tbl_students (name,age,k_score,e_score,m_score,password) VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt = DBcon.getConnection().prepareStatement(s);
            scan.returnStu();
            stmt.setString(1,stu.getName());
            stmt.setInt(2,stu.getAge());
            stmt.setInt(3,stu.getK_score());
            stmt.setInt(4,stu.getE_score());
            stmt.setInt(5,stu.getE_score());
            stmt.setString(6,stu.getPassword());

            System.out.println("ㅇㅇㅇㅇㅇㅇ");
            stmt.executeUpdate();


        }catch (Exception e){
            e.getMessage();
        }
        return 0;
    }

    public int update(int sno){
        try{
            s = "UPDATE tbl_students SET name = ?,age = ?,k_score = ?,e_score = ?,m_score = ?, password = ? WHERE sno = ?";
            PreparedStatement stmt = DBcon.getConnection().prepareStatement(s);

            stmt.setString(1,scan.returnStu().getName());
            stmt.setInt(2,scan.returnStu().getAge());
            stmt.setInt(3,scan.returnStu().getK_score());
            stmt.setInt(4,scan.returnStu().getE_score());
            stmt.setInt(5,scan.returnStu().getE_score());
            stmt.setString(6,scan.returnStu().getPassword());
            stmt.setInt(7,sno);
            stmt.executeUpdate();

            System.out.println("완료");
        }catch(Exception e){
            e.getMessage();
        }
        return 0;
    }
    public void delete(){
        try{
            String s = "DELETE FROM tbl_students WHERE sno = ?";
            PreparedStatement stmt = DBcon.getConnection().prepareStatement(s);
            sno = Scan.sc.nextInt();
            stmt.setInt(1,sno);
            stmt.executeUpdate();

        }catch(Exception e){
            e.getMessage();
        }
    }

    public int read1() {
        try {

            Statement stmt = DBcon.getConnection().createStatement();
            s = "SELECT * FROM tbl_students";
            ResultSet rs = stmt.executeQuery(s);

            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getInt("sno"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setK_score(rs.getInt("k_score"));
                stu.setE_score(rs.getInt("e_score"));
                stu.setM_score(rs.getInt("m_score"));
                stu.setPassword(rs.getString("password"));

                students.add(stu);

            }
            for (Student stu : students) {
                System.out.println(stu.toString());
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }

    public int read2(int sno) {
        try {
            s = "SELECT * FROM tbl_students WHERE sno = ? ";
            PreparedStatement stmt = DBcon.getConnection().prepareStatement(s);
            stmt.setInt(1, sno);
            ResultSet rs = stmt.executeQuery();

            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                Student stu = new Student();
                stu.setSno(rs.getInt("sno"));
                stu.setName(rs.getString("name"));
                stu.setAge(rs.getInt("age"));
                stu.setK_score(rs.getInt("k_score"));
                stu.setE_score(rs.getInt("e_score"));
                stu.setM_score(rs.getInt("m_score"));
                stu.setPassword(rs.getString("password"));

                students.add(stu);
            }
            for (Student stu : students) {
                System.out.println(stu.toString());
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return 0;
    }
}
