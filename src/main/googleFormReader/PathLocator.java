package src.main.googleFormReader;

import java.util.Scanner;

public class PathLocator {
    private String path;
    public void pathLocator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the path to your file?");
        path = scanner.next();
    }

    public String getPath() {
        return path;
    }

    // Remove setPath at some point
    public void setPath(String path) {
        this.path = path;
    }
}
