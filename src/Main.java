package src;

import src.miniZinc.DznWriter;
import src.miniZinc.MiniZincManager;
import src.miniZinc.SolutionParser;
import src.teacherInput.TeacherInputReader;

public class Main {
  public static String DATAPATH = "src/miniZinc/seatingdata.dzn";

  public static int TABLENUMBER; // Max number of tables available;
  public static final int FRIENDNUMBER = 3; // DO NOT FUCK WITH - How many friends each student has
  public static int SEATNUMBER; // Number of seats at a table;
  public static int TIMESTOP = 10000; // Time stop is in milliseconds;
  // ^ init with function that ramps with students and constraints

  public static void main(String[] args) {
    // Init teacher stuff - maybe put this somewhere else cleaner
    TeacherInputReader teacherInputReader = new TeacherInputReader();
    teacherInputReader.defineStaticVariables();

    // Make the grade
    Grade grade = new Grade();

    // Checking it all works
    System.out.println(grade.getStudents());

    // Mini Zinc Shit has to go here
    MiniZincManager miniZincManager = MiniZincManager.MiniZincManager(grade);
    miniZincManager.transformStudents();
    miniZincManager.write();
    miniZincManager.execute();
    miniZincManager.parse();
  }
}
