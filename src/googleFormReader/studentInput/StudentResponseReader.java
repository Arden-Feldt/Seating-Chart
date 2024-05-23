package src.googleFormReader.studentInput;

import src.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import static src.Main.FRIENDNUMBER;

public class StudentResponseReader {
  HashSet<Student> students;
  HashMap<String, ArrayList<String>> friends;

  public StudentResponseReader(String path) {
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
        ArrayList<String> friendList = addFriendsToList(ids);

        friends.put(student.getName(), friendList);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void knitStudents() {
    // Adds friends to existing students
    for (Student student : students) {
      // Retrieve the friend's ID from the friend list
      String oneFriendId = friends.get(student.getName()).get(0);
      String twoFriendId = friends.get(student.getName()).get(1);
      String threeFriendId = friends.get(student.getName()).get(2);

      // Find the corresponding Student object with the friend's ID
      Student oneFriend = findStudentByName(oneFriendId);
      Student twoFriend = findStudentByName(twoFriendId);
      Student threeFriend = findStudentByName(threeFriendId);

      // Set oneFriend for the current student
      student.setOneFriend(oneFriend);
      student.setTwoFriend(twoFriend);
      student.setThreeFriend(threeFriend);
    }
  }

  private Student findStudentByName(String name) {
    for (Student student : students) {
      if (student.getName().equals(name)) {
        return student;
      } else if (student.getName().isEmpty()) {
        return new Student("");
      }
    }
    return new Student("We shouldn't get here");
    // throw new StudentNotFoundException();
  }

  public HashSet<Student> getStudents() {
    return students;
  }

  public HashMap<String, ArrayList<String>> getFriends() {
    return friends;
  }

  private String checkFriend(String id) {
    if (id == null) {
      return "";
    }
    return id;
  }

  public ArrayList<String> addFriendsToList(String[] ids) {
    ArrayList<String> friendList = new ArrayList<>();
    for (int i = 1; i <= FRIENDNUMBER; i++) {
      try {
        friendList.add(ids[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        friendList.add("");
      }
    }
    return friendList;
  }
}
