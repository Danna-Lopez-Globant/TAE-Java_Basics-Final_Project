package model;

import java.util.List;

import userinterface.UiView;

public class Controller {

    private final University university;
    private final UiView view;

    public Controller(University university, UiView view){
        this.university = university;
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while(running) {
            view.displayMainMenu();

            String option = view.readOption();
            switch (option) {
                case "1": printTeachers(); break;
                case "2": handleClassesMenu(); break;
                case "3": createStudent(); break;
                case "4": createClass(); break;
                case "5": printListClassesByStudent(); break;
                case "6": 
                    running = false;
                    view.displayMessage("Goodbye!");
                    break;
                default:
                    view.displayError("Invalid option, try again.");
                    break;
            }
        }
    }

    private void printTeachers() {
        view.displayTeachers(university.getTeachers());
    }

    private void handleClassesMenu() {
        List<UniClass> classes = university.getClasses();
        view.displayClasses(classes);
        if (classes.isEmpty()) return;

        int idc = view.promptInt("Enter the class number to view its details (0 to cancel): ");
        if (idc == 0) return;

        UniClass c = university.getClassByIndex(idc -1);
        if (c == null) {
            view.displayError("Invalid class number");
            return;
        }
        view.displayClassDetails(c);
    }

    private void createClass() {
        if (university.getTeachers().isEmpty()) {
            view.displayError("No teachers available. Cannot create a class.");
            return;
        }

        String name = view.promptString("Class name: ");
        String classroom = view.promptString("Classroom: ");

        view.displayTeachers(university.getTeachers());
        String teacherName = view.promptString("Enter the exact teacher name to assign: ");
        Teacher teacher = university.findTeacherByName(teacherName);
        if (teacher == null) {
            view.displayError("Teacher not found. Class creation cancelled.");
            return;
        }

        UniClass newClass = new UniClass(name, classroom, teacher);

        int count = view.promptInt("How many existing students do you want to add now? ");
        for (int i = 0; i < count; i++) {
            String id = view.promptString("Enter student ID #" + (i + 1) + ": ");
            Student s = university.findStudentById(id);
            if (s == null) {
                view.displayError("Student ID not found, skipping.");
                continue;
            }
            newClass.addStudent(s);
        }

        university.addClass(newClass);
        view.displayMessage("Class '" + name + "' created successfully.");
    }

    private void createStudent() {
        List<UniClass> classes = university.getClasses();
        view.displayClasses(classes);
        if (classes.isEmpty()) {
            view.displayMessage("Create a class first (option 4).");
            return;
        }

        int idc = view.promptInt("Enter the class number where the new student will be added: ");
        UniClass c = university.getClassByIndex(idc - 1);
        if (c == null) {
            view.displayError("Invalid class number.");
            return;
        }

        String name = view.promptString("Student name: ");
        String id = view.promptString("Student ID: ");
        if (university.findStudentById(id) != null) {
            view.displayError("A student with that ID already exists. Operation cancelled.");
            return;
        }
        int age = view.promptInt("Student age: ");

        Student student = new Student(name, id, age);
        university.addStudent(student);
        c.addStudent(student);
        view.displayMessage("Student '" + name + "' created and added to class '" + c.getName() + "'.");
    }

    private void printListClassesByStudent() {
        String id = view.promptString("Enter student ID: ");
        Student s = university.findStudentById(id);
        if(s == null){
            view.displayError("Student not found.");
            return;
        }
        
        List<UniClass> sClasses = university.findClassesByStudentId(id);
        view.displayStudentClasses(s, sClasses);
    }

}