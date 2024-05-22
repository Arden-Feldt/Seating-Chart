package src.miniZinc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MiniZincExecutor {
    String[] command;
    public MiniZincExecutor(int timestop) {
    // Define the command and its arguments
    command =
        new String[] {
          "minizinc",
          "--solver",
          "gecode",
          "--time-limit",
          String.valueOf(timestop),
          "\"src/main/miniZinc/seatingchart.mzn\"",
          "\"src/main/miniZinc/seatingdata.dzn\""
        };
    }

    public String execute(){
        // What this code is basically doing
        // minizinc --solver gecode --time-limit 10 seatingchart.mzn seatingdata.dzn
        // --time-limit is in milliseconds

        try {
            // Create a ProcessBuilder with the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output.append(line).append("\n");
            }

            // Read the error output from the process
            StringBuilder errorOutput = new StringBuilder();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("MiniZincExecutor exited with code: " + exitCode);

            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "MiniZincExecutor: How we get here?";
    }
}