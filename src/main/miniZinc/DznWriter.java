package src.main.miniZinc;

import src.main.Grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DznWriter {
    String content;
    String filePath;
    public DznWriter(Grade grade, String filePath){
        StudentTransformer studentTransformer = new StudentTransformer(grade);
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
