package src.main;

import java.util.HashSet;
import src.main.googleFormReader.ReadStudentResponses;

public class Grade {
    HashSet<Student> students;
    public Grade(String path){
        ReadStudentResponses readStudentResponses = new ReadStudentResponses(path);
        readStudentResponses.knitStudents();
        students = new HashSet<>(readStudentResponses.getStudents());
    }
}
