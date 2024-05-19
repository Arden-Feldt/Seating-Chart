package src.main;

import src.main.miniZinc.DznWriter;
import src.main.miniZinc.MiniZincExecutor;
import src.main.miniZinc.SolutionParser;
import src.main.miniZinc.StudentTransformer;

public class Main {

  public static int TABLENUMBER = 100; // Max number of tables available;
  public static final int FRIENDNUMBER = 3; // DO NOT FUCK WITH - How many friends each student has
  public static int SEATNUMBER = 8; // Number of seats at a table;
  public static int TIMESTOP = 1000; // Time stop is in milliseconds;

  public static void main(String[] args) {
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
