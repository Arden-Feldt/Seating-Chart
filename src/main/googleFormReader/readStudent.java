package src.main.googleFormReader;

import src.main.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class readStudent {
    ArrayList<Student> students;
    ArrayList<String> oneFriends;
    ArrayList<String> twoFriends;
    ArrayList<String> threeFriends;
    public readStudent(String path) {
        this.students = new ArrayList<>();
        oneFriends = new ArrayList<>();
        twoFriends = new ArrayList<>();
        threeFriends = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] ids = line.split(",");

                Student student = new Student(ids[0], ids[1], ids[2], ids[3]);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
