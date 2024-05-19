package src.teacherInput;

public class TeacherInputReader {
    // TODO: Implement this
    // reads who shouldn't get put together
    // returns that info in the format of a mzn
    // is somehow injected into mzm (called by MznWriter?)

    private int numConstraints;

    public TeacherInputReader(){

    }

    public int getTableNumber(){
        return 100;
    }

    public int getSeatNumber() {
        return 8;
    }

    public int getNumberConstraints(){
        return numConstraints;
    }
}
