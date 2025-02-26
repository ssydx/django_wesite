package spring.dependency;

public class AnswerMapValue {
    private int id;
    private String name;
    private String auther;
    public AnswerMapValue(int id, String name, String auther) {
        this.id = id;
        this.name = name;
        this.auther = auther;
    }
    public String toString() {
        return id + " " + name + " " + auther;
    }
}
