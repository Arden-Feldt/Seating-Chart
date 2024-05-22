package src.miniZinc;

import src.Grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DznWriter {
    Grade grade;
    String content;
    String filePath;
    public DznWriter(Grade grade, String filePath, StudentTransformer studentTransformer){
        this.grade = grade;
        this.filePath = filePath;
        content = studentTransformer.toString();
    }

    public void write(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
