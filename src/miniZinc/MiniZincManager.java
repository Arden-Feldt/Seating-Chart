package src.miniZinc;

import src.Grade;

public class MiniZincManager {
    private static MiniZincManager instance = null;
    private StudentTransformer studentTransformer;
    private DznWriter dznWriter;
    private MiniZincExecutor miniZincExecutor;
    private SolutionParser solutionParser;

    private String solution;
    private MiniZincManager(Grade grade){
        studentTransformer = new StudentTransformer(grade);
        dznWriter = new DznWriter(studentTransformer);
        miniZincExecutor = new MiniZincExecutor();
        solutionParser = new  SolutionParser(grade, solution);

    }

    public static MiniZincManager MiniZincManager(Grade grade){
        if (instance == null){
            instance = new MiniZincManager(grade);
        }
        return  instance;
    }

    public void transformStudents(){
        studentTransformer.transform();
    }
    public void write(){
        dznWriter.write();
    }

    public void execute(){
        solution = miniZincExecutor.execute();
    }

    public void parse(){
        solutionParser.parse();
    }

    public void printSolution(){
        System.out.println(solution);
    }

}
