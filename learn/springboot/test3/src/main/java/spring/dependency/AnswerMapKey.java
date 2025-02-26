package spring.dependency;

public class AnswerMapKey {
    private int id;
    private String name;
    public AnswerMapKey(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return id + " " + name;
    }
}
