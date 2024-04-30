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

                Student student = new Student(ids[0]);
                students.add(student);

                oneFriends.add(ids[1]);
                twoFriends.add(ids[2]);
                threeFriends.add(ids[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void knitStudents(){
        for (int i = 0; i < students.size(); i ++){
            students.get(i).setOneFriend(oneFriends.get(i));
            students.get(i).setTwoFriend(twoFriends.get(i));
            students.get(i).setThreeFriend(threeFriends.get(i));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
