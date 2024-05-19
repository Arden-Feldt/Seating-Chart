package src.main;

import src.main.miniZinc.DznWriter;
import src.main.miniZinc.MiniZincExecutor;
import src.main.miniZinc.StudentTransformer;

public class Main {

  public static int TABLENUMBER;
  public static int FRIENDNUMBER;
  public static int SEATNUMBER;

  public static void main(String[] args) {
    TABLENUMBER = 100;
    FRIENDNUMBER = 3;
    SEATNUMBER = 8;

    Grade grade = new Grade();

    // Checking it all works
    System.out.println(grade.getStudents());

    // Mini Zinc Shit has to go here
    StudentTransformer studentTransformer = new StudentTransformer(grade);
    System.out.println(studentTransformer);

    // Write into datafile
    DznWriter dznWriter = new DznWriter(grade);

    // Execute optimization
    MiniZincExecutor miniZincExecutor = new MiniZincExecutor(1000);

    // cd .\src\main\miniZinc\
    // minizinc --solver gecode --time-limit 10 seatingchart.mzn seatingdata.dzn
    // --time-limit is in milliseconds
  }
}
