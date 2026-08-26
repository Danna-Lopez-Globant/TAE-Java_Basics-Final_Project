package model;

import java.util.List;
import java.util.ArrayList;

public class University{
    private List<Teacher> teachers;
    private List<Student> students;
    private List<UniClass> classes;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {return teachers;}
    public List<Student> getStudents() {return students;}
    public List<UniClass> getClasses() {return classes;}
    
}