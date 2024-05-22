package src;

import src.miniZinc.DznWriter;
import src.miniZinc.MiniZincExecutor;
import src.miniZinc.SolutionParser;
import src.miniZinc.StudentTransformer;
import src.teacherInput.TeacherInputReader;

public class Main {

  public static int TABLENUMBER; // Max number of tables available;
  public static final int FRIENDNUMBER = 3; // DO NOT FUCK WITH - How many friends each student has
  public static int SEATNUMBER; // Number of seats at a table;
  public static int TIMESTOP = 10000; // Time stop is in milliseconds;
  // ^ init with function that ramps with students and constraints

  public static void main(String[] args) {
    // Init teacher stuff - maybe put this somewhere else cleaner
    TeacherInputReader teacherInputReader = new TeacherInputReader();
    TABLENUMBER = teacherInputReader.getTableNumber();
    SEATNUMBER = teacherInputReader.getSeatNumber();

    // Make the grade
    Grade grade = new Grade();

    // Checking it all works
    System.out.println(grade.getStudents());

    // Mini Zinc Shit has to go here


    // Write into datafile
    DznWriter dznWriter = new DznWriter(grade, "src/miniZinc/seatingdata.dzn");
    dznWriter.write();
    // TODO: Why is it not stopping for the timstop?
    dznWriter.solve();

    System.out.println("-=-Solution-=-");
    System.out.println(dznWriter.getSolution());

    // Make Solution Intelligible
    SolutionParser solutionParser = new SolutionParser(grade, dznWriter.getSolution());
    String parsedSolution = solutionParser.parse();

    System.out.println(parsedSolution);
  }
}
