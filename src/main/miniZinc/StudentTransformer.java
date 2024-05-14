package src.main.miniZinc;

import src.main.Grade;
import src.main.Student;

import java.util.Arrays;

public class StudentTransformer {

    private Grade grade;

    public StudentTransformer(Grade grade){
        this.grade = grade;
    }

    public int maxId(){
        int result = 0;
        for (Student student: grade.getStudents()){
            if(student.getId() > result){
                result = student.getId();
            }
        }
        return result;
    }

    public String friendArray(){
        int[][] result = new int[grade.getStudents().size()][3];
        int i = 0;
        for (Student student: grade.getStudents()){
            result[i][0] = (student.getOneFriend().getId());
            result[i][1] = (student.getTwoFriend().getId());
            result[i][2] = (student.getThreeFriend().getId());
            i++;
        }
        return Arrays.deepToString(result);
    }
}
