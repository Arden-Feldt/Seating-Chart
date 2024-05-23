package src.miniZinc;

import src.Grade;
import src.Student;

public class StudentTransformer {

  private final Grade grade;
  private String transformedStudents;

  public StudentTransformer(Grade grade) {
    this.grade = grade;
  }

  public void transform(){
    int[][] array = friendArray();
    StringBuilder result = new StringBuilder();

    result.append("n = ").append(grade.getStudents().size()).append(";\n");
    result.append("friends = array2d(1..").append(grade.getStudents().size()).append(", 1..3, [\n");

    for (int i = 0; i < array.length; i++){
      for (int j = 0; j < array[i].length; j++){
        result.append(array[i][j]);
        if (i != array.length - 1 || j != array[i].length - 1){
          result.append(", ");
        }
      }
      result.append("\n");
    }
    result.append("]);");

    transformedStudents = result.toString();
  }

  public int maxId() {
    int result = 0;
    for (Student student : grade.getStudents()) {
      if (student.getId() > result) {
        result = student.getId();
      }
    }
    return result;
  }

  public int[][] friendArray() {
    int[][] result = new int[grade.getStudents().size()][3];
    int i = 0;
    for (Student student : grade.getStudents()) {
      result[i][0] = (student.getOneFriend().getId());
      result[i][1] = (student.getTwoFriend().getId());
      result[i][2] = (student.getThreeFriend().getId());
      i++;
    }
    return result;
  }

  public String getTransformedStudents() {
    if (transformedStudents == null){
      transform();
    }
    return transformedStudents;
  }
}
