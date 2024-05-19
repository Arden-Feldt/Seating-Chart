package src.main;

import java.util.HashSet;

import src.main.googleFormReader.PathLocator;
import src.main.googleFormReader.StudentResponseReader;

public class Grade {
  HashSet<Student> students;

  public Grade() {
    PathLocator pathLocator = new PathLocator();

    // Remove this after UI implementation
    pathLocator.setPath(
        "C:\\Users\\ethan\\IdeaProjects\\Seating-Chart\\src\\main\\googleFormReader\\studentForm");

    String path = pathLocator.getPath();

    // Read in all the student responses
    StudentResponseReader studentResponseReader = new StudentResponseReader(path);
    // Associate students with their friends
    studentResponseReader.knitStudents();

    students = new HashSet<>(studentResponseReader.getStudents());
    // Give each student a unique identifier
    addIDs();
  }

  public void addIDs() {
    int i = 1;
    for (Student student : students) {
      student.setId(i);
      i++;
    }
  }

  public HashSet<Student> getStudents() {
    return students;
  }
}
