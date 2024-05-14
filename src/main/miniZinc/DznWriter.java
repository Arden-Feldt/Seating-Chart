package src.main.miniZinc;

import src.main.Grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DznWriter {
    public DznWriter(Grade grade){
        StudentTransformer studentTransformer = new StudentTransformer(grade);
        String filePath = "src/main/miniZinc/seatingdata.dzn";
        String content = studentTransformer.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
