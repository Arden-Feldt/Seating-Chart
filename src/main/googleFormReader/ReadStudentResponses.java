package src.main.googleFormReader;

import src.main.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ReadStudentResponses {
    ArrayList<Student> students;
    HashMap<String, ArrayList<String>> friends;
    public ReadStudentResponses(String path) {
        this.students = new ArrayList<>();
        this.friends = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] ids = line.split(",");

                // Init Student
                Student student = new Student(ids[0]);
                students.add(student);

                // Build body for friends
                ArrayList<String> friendList = new ArrayList<>();
                friendList.add(ids[1]);
                friendList.add(ids[2]);
                friendList.add(ids[3]);

                friends.put(student.getId(), friendList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public HashMap<String, ArrayList<String>> getFriends() {
        return friends;
    }
}
