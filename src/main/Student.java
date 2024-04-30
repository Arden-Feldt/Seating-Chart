package src.main;

public class Student {
    private String id;
    private String oneFriend;
    private String twoFriend;
    private String threeFriend;

    public Student(String id){
        this.id = id;
        this.oneFriend = null;
        this.twoFriend = null;
        this.threeFriend = null;
    }
    public Student(String id, String oneFriend, String twoStudent, String threeStudent){
        this.id = id;
        this.oneFriend = oneFriend;
        this.twoFriend = twoStudent;
        this.threeFriend = threeStudent;
    }

    public String getId() {
        return id;
    }

    public String getOneFriend() {
        return oneFriend;
    }

    public String getTwoFriend() {
        return twoFriend;
    }

    public String getThreeFriend() {
        return threeFriend;
    }

    public void setOneFriend(String oneFriend) {
        this.oneFriend = oneFriend;
    }

    public void setTwoFriend(String twoFriend) {
        this.twoFriend = twoFriend;
    }

    public void setThreeFriend(String threeFriend) {
        this.threeFriend = threeFriend;
    }
}
