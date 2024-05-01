package src.main;

import src.main.googleFormReader.PathLocator;

public class main {
    public static void main(String[] args) {
        // Implement UI that gets studentForm.csv path
        PathLocator pathLocator = new PathLocator();

        // Remove this after UI implementation
        pathLocator.setPath("C:\\Users\\ethan\\IdeaProjects\\Seating-Chart\\src\\main\\googleFormReader\\studentForm");

        Grade grade = new Grade(pathLocator.getPath());

        // Checking it all works
        System.out.println(grade.getStudents());

        // Mini Zinc Shit has to go here
    }
}
