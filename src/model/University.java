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

    public UniClass getClassByIndex(int i) {
        if(i < 0 || i >= classes.size()) return null;
        return classes.get(i);
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public Teacher findTeacherByName(String teacherName) {
        for (Teacher t : teachers) {
            if (t.getName().equalsIgnoreCase(teacherName)) {
                return t;
            }
        }
        return null;
    }

    public List<UniClass> findClassesByStudentId(String id) {
        List<UniClass> result = new ArrayList<>();
        for (UniClass c : classes) {
            for (Student s : c.getStudents()) {
                if (s.getId().equalsIgnoreCase(id)) {
                    result.add(c);
                    break;
                }
            }
        }
        return result;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addClass(UniClass newClass) {
        classes.add(newClass);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    
}