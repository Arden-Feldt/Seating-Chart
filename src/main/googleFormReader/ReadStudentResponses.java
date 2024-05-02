package src.main.googleFormReader;

import src.main.Student;
import src.main.exceptions.StudentNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import static src.main.Main.FRIENDNUMBER;

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
        ArrayList<String> friendList = addFriendsToList(ids);

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
      String twoFriendId = friends.get(student.getId()).get(1);
      String threeFriendId = friends.get(student.getId()).get(2);

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
      } else if (student.getId().isEmpty()) {
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
