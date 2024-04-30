package src.main;

import java.util.ArrayList;

public class Student {
    private final String id;
    private Student oneFriend;
    private Student twoFriend;
    private Student threeFriend;

    public Student(String id){
        this.id = id;
        this.oneFriend = null;
        this.twoFriend = null;
        this.threeFriend = null;
    }
    public Student(String id, Student oneFriend, Student twoStudent, Student threeStudent){
        this.id = id;
        this.oneFriend = oneFriend;
        this.twoFriend = twoStudent;
        this.threeFriend = threeStudent;
    }

    public String getId() {
        return id;
    }

    public Student getOneFriend() {
        return oneFriend;
    }

    public Student getTwoFriend() {
        return twoFriend;
    }

    public Student getThreeFriend() {
        return threeFriend;
    }

    public void setOneFriend(Student oneFriend) {
        this.oneFriend = oneFriend;
    }

    public void setTwoFriend(Student twoFriend) {
        this.twoFriend = twoFriend;
    }

    public void setThreeFriend(Student threeFriend) {
        this.threeFriend = threeFriend;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nF1: " + oneFriend + "\nF2: " + twoFriend + "\nF3: " + threeFriend;
    }
}
