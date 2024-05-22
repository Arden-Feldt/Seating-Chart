package src.miniZinc;

import src.Grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static src.Main.TIMESTOP;

public class DznWriter {
    private Grade grade;
    private StudentTransformer studentTransformer;
    private String content;
    private String filePath;
    private String solution;
    public DznWriter(Grade grade, String filePath){
        studentTransformer = new StudentTransformer(grade);
        this.grade = grade; // Currently doing nothing
        this.filePath = filePath;
        content = getStudentTransformer().toString();
    }

    public StudentTransformer getStudentTransformer(){
        return studentTransformer;
    }

    public void solve(){
        // Execute optimization
        MiniZincExecutor miniZincExecutor = new MiniZincExecutor(TIMESTOP);
        solution = miniZincExecutor.execute();
    }

    public void write(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSolution() {
        return solution;
    }
}
