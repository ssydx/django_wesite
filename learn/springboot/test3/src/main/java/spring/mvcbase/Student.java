package spring.mvcbase;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
    @Max(value = 100, message = "must smaller than 100")
    @Min(value = 10, message="must larger than 10")
    private int id;
    @Size(min=3,message="required")
    private String name;
    @NotNull(message = "not null")
    private Integer age;
    @Pattern(regexp = "[0-9]+", message = "需要满足正则")
    private String score;
    @Password(message = "必须包含jsp子串")
    private String password;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
