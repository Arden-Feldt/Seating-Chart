package src.miniZinc;

import src.Grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static src.Main.DATAPATH;

public class DznWriter {
    private String content;
    private String filePath;
    public DznWriter(StudentTransformer studentTransformer){
        this.filePath = DATAPATH;
        content = studentTransformer.getTransformedStudents();
    }

    public void write(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
