package spring.dependency;

public class AnswerLs {
    private int id;
    private String name;
    private String fullname;
    public AnswerLs() {}
    public AnswerLs(int id, String name, String fullname) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
    }
    public String toString() {
        return id + " " + name + " " + fullname;
    }
}
