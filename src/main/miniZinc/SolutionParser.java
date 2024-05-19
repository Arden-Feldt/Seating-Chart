package src.main.miniZinc;

import src.main.Grade;

public class SolutionParser {
    String solution;
    Grade grade;
    public SolutionParser(Grade grade, String solution){
        this.grade = grade;
        this.solution = solution;
    }

    public String parse() {
        // TODO: build parse as defined down below
        // Recognize which Students are with each table by connecting ID's
        // Print out a nice solution of who is at what table
        // Maybe color code the names to show how many friends they are with

        return "Yippie!";
    }

    private String scoreBoard(String score){
        return score;
    }
}
