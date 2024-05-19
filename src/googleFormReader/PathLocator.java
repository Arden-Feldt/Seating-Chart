package src.googleFormReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PathLocator {
  private String path;

  public void pathLocator() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is the path to your file?");
    path = scanner.next();

    boolean foundPath = false;

    while (!foundPath) {
      try {
        File file = new File(path);

        if (file.exists() && !file.isDirectory() && path.toLowerCase().endsWith(".csv")) {
          foundPath = true;
          System.out.println("Valid CSV file path: " + path);
        } else {
          System.out.println("Invalid CSV file path. Please enter a valid path to a CSV file.");
          path = scanner.next();
        }
      } catch (Exception e) {
        System.out.println("Not a valid path; error: " + e.getMessage());
      }
    }

    scanner.close();
  }

  public String getPath() {
    return path;
  }

  // Remove setPath at some point
  public void setPath(String path) {
    this.path = path;
  }
}
