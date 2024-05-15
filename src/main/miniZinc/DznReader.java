package src.main.miniZinc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class DznReader {
    boolean isWindows;
    public DznReader(){
        isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

  /*

  //Currently, there is no way to handle pipes with .exec(). Fortunately, the pipes are a shell feature.
  //So, we can create the whole command where we want to use pipe and pass it to .exec():

      Process process;
  if (isWindows) {
      process = Runtime.getRuntime()
        .exec(String.format("cmd.exe /c dir %s", homeDirectory));
  } else {
      process = Runtime.getRuntime()
        .exec(String.format("/bin/sh -c ls %s", homeDirectory));
  }
  StreamGobbler streamGobbler =
    new StreamGobbler(process.getInputStream(), System.out::println);
  Future<?> future = executorService.submit(streamGobbler);

  int exitCode = process.waitFor();

  assertDoesNotThrow(() -> future.get(10, TimeUnit.SECONDS));
  assertEquals(0, exitCode);

  // Alternatively, we can use a ProcessBuilder, which is preferred over the Runtime approach because we can customize it instead of just running a string command.
  //
  //In short, with this approach, we’re able to:
  //
  //change the working directory our shell command is running in using .directory()
  //change environment variables by providing a key-value map to .environment()
  //redirect input and output streams in a custom way
  //inherit both of them to the streams of the current JVM process using .inheritIO()
  //Similarly, we can run the same shell command as in the previous example:

  if (IS_WINDOWS) {
      process = Runtime.getRuntime()
          .exec(String.format("cmd.exe /c dir %s | findstr \"Desktop\"", homeDirectory));
  } else {
      process = Runtime.getRuntime()
          .exec(String.format("/bin/sh -c ls %s | grep \"Desktop\"", homeDirectory));
  }

       */

}
