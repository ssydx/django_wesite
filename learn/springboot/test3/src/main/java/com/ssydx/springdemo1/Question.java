package com.ssydx.springdemo1;

import java.util.List;
import java.util.Map;

public class Question {
    private int id;
    private String name;
    private List<String> answerbasels;
    private List<AnswerLs> answerrefls;
    private Map<Integer, String> answerbasemap;
    private Map<AnswerMapKey, AnswerMapValue> answerrefmap;
    public Question() {}
    public Question(int id, String name, List<String> answerbasels) {
        this.id = id;
        this.name = name;
        this.answerbasels = answerbasels;
    }
    public Question(int id, String name, List<AnswerLs> answerrefls, int onlydiff) {
        this.id = id;
        this.name = name;
        this.answerrefls = answerrefls;
    }
    public Question(int id, String name, Map<Integer,String> answerbasemap) {
        this.id = id;
        this.name = name;
        this.answerbasemap = answerbasemap;
    }
    public Question(int id, String name, Map<AnswerMapKey,AnswerMapValue> answerrefmap, int onlydiff) {
        this.id = id;
        this.name = name;
        this.answerrefmap = answerrefmap;
    }
    public void displayInfo1() {
        System.out.println(id + " " + name + " " + answerbasels);
    }
    public void displayInfo2() {
        System.out.println(id + " " + name + " " + answerrefls);
    }
    public void displayInfo3() {
        System.out.println(id + " " + name + " " + answerbasemap);
    }
    public void displayInfo4() {
        System.out.println(id + " " + name + " " + answerrefmap);
    }

}
