package src.main;

import src.main.miniZinc.DznWriter;
import src.main.miniZinc.MiniZincExecutor;
import src.main.miniZinc.SolutionParser;
import src.main.miniZinc.StudentTransformer;
import src.main.teacherInput.TeacherInputReader;

public class Main {

  public static int TABLENUMBER; // Max number of tables available;
  public static final int FRIENDNUMBER = 3; // DO NOT FUCK WITH - How many friends each student has
  public static int SEATNUMBER; // Number of seats at a table;
  public static int TIMESTOP = 1000; // Time stop is in milliseconds;
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
    StudentTransformer studentTransformer = new StudentTransformer(grade);
    System.out.println(studentTransformer);

    // Write into datafile
    DznWriter dznWriter = new DznWriter(grade, "src/main/miniZinc/seatingdata.dzn");
    dznWriter.write();

    // Execute optimization
    MiniZincExecutor miniZincExecutor = new MiniZincExecutor(TIMESTOP);
    String solution = miniZincExecutor.execute();

    // Make Solution Intelligible
    SolutionParser solutionParser = new SolutionParser(grade, solution);
    String parsedSolution = solutionParser.parse();

    System.out.println(parsedSolution);
  }
}
