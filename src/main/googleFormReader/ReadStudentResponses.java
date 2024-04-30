package src.main.googleFormReader;

import src.main.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class ReadStudentResponses {
    HashSet<Student> students;
    HashMap<String, ArrayList<String>> friends;
    public ReadStudentResponses(String path) {
        this.students = new HashSet<>();
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

    public void knitStudents() {
        // Adds friends to existing students
        for (Student student : students) {
            // Retrieve the friend's ID from the friend list
            String oneFriendId = friends.get(student.getId()).get(0);
            String twoFriendId = friends.get(student.getId()).get(0);
            String threeFriendId = friends.get(student.getId()).get(0);

            // Find the corresponding Student object with the friend's ID
            Student oneFriend = findStudentById(oneFriendId);
            Student twoFriend = findStudentById(twoFriendId);
            Student threeFriend = findStudentById(threeFriendId);

            // Set oneFriend for the current student
            student.setOneFriend(oneFriend);
            student.setTwoFriend(twoFriend);
            student.setThreeFriend(threeFriend);
        }
    }

    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return new Student("UH OH");
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public HashMap<String, ArrayList<String>> getFriends() {
        return friends;
    }
}
