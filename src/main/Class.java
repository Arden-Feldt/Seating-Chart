package src.main;

import java.util.HashSet;
import src.main.googleFormReader.ReadStudentResponses;

public class Class {
    HashSet<Student> students;
    public Class (String path){
        ReadStudentResponses readStudentResponses = new ReadStudentResponses(path);
        students = new HashSet<>(readStudentResponses.getStudents());
    }

    private void knitStudents(){
        // Adds friends to existing students
    }
}
