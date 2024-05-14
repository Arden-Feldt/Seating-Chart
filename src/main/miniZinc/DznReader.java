package src.main.miniZinc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DznReader {
    public DznReader(){
        // Will read in the solution and make it pretty, currently just copies what DznWriter put down
        String filePath = "src/main/miniZinc/seatingdata.dzn";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
