package com.ssydx.springdemo1;

public class Employee {
    private int id;
    private String name;
    private Department dpt;
    public Employee() {}
    public Employee(int id) { this.id = id; }
    public Employee(String name) { this.name = name; }
    public Employee(int id, String name) { this.id = id; this.name = name; }
    public Employee(int id, String name, Department dpt) {
        this.id = id; 
        this.name = name;
        this.dpt = dpt;
    }
    void show1() {
        System.out.println(id + " " + name);
    }
    void show2() {
        System.out.println(id + " " + name + " " + dpt);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDpt(Department dpt) {
        this.dpt = dpt;
    }
}
