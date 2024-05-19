package src;

public class Student {
  private int id;

  private final String name;
  private Student oneFriend;
  private Student twoFriend;
  private Student threeFriend;

  public Student(String name) {
    this.name = name;
    this.oneFriend = null;
    this.twoFriend = null;
    this.threeFriend = null;
  }

  public Student(String name, Student oneFriend, Student twoStudent, Student threeStudent) {
    this.name = name;
    this.oneFriend = oneFriend;
    this.twoFriend = twoStudent;
    this.threeFriend = threeStudent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
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
    return "\nName: "
        + name
        + "\nF1: "
        + oneFriend.name
        + "\nF2: "
        + twoFriend.name
        + "\nF3: "
        + threeFriend.name;
  }
}
