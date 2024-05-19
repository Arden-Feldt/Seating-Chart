package src.main.miniZinc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MiniZincExecutor {
    public MiniZincExecutor(int timestop) {

    // Define the command and its arguments
    String[] command = {
      "minizinc",
      "--solver",
      "gecode",
      "--time-limit",
      String.valueOf(timestop),
      // TODO: Fix this absolute path
      "C:\\Users\\ethan\\IdeaProjects\\Seating-Chart\\src\\main\\miniZinc\\seatingchart.mzn",
      "C:\\Users\\ethan\\IdeaProjects\\Seating-Chart\\src\\main\\miniZinc\\seatingdata.mzn"
    };

        try {
            // Create a ProcessBuilder with the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Read the error output from the process
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
