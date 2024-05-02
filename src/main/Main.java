package src.main;

public class Main {

    public static int TABLENUMBER;
    public static int FRIENDNUMBER;
    public static int SEATNUMBER;
    public static void main(String[] args) {
        TABLENUMBER = 100;
        FRIENDNUMBER = 3;
        SEATNUMBER = 8;


        Grade grade = new Grade();

        // Checking it all works
        System.out.println(grade.getStudents());

        // Mini Zinc Shit has to go here
    }
}
