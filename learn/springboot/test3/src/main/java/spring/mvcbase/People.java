package spring.mvcbase;

public class People {
    private String name;
    private int age;
    private String gender;
    private String[] hobbies;
    private String[] from;
    private String to;
    public People(){}
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String[] getHobbies() {
        return hobbies;
    }
    public String[] getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
    public void setFrom(String[] from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
}
