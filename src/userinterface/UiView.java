package userinterface; //Naming the directory UI/ui mark an error

import model.Student;
import model.Teacher;
import model.UniClass;

import java.util.List;
import java.util.Scanner;

public class UiView {

    private final Scanner scanner;

    public UiView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("\n----- University Management Menu -----");
        System.out.println("1. Print all teachers");
        System.out.println("2. Print all classes");
        System.out.println("3. Create a new student and add it to an existing class");
        System.out.println("4. Create a new class with existing teacher and students");
        System.out.println("5. List all classes of a given student (search by id)");
        System.out.println("6. Exit");
    }

    public void displayTeachers(List<Teacher> teachers){
        if (teachers.isEmpty()) {
            System.out.println("No teachers registered yet.");
        }else{
            System.out.println("----- Teachers List (" + teachers.size() + " total) -----");
            for (Teacher t : teachers) System.out.println(t);
        }
    }

    public void displayClasses(List<UniClass> classes) {
        if (classes.isEmpty()) {
            System.out.println("No classes registered yet.");
        }else{
            System.out.println("----- Classes List -----");
            for (int i = 0; i < classes.size(); i++){
                System.out.println((i+1) + ". " + classes.get(i).getName());
            }
        }
    }

    public void displayClassDetails(UniClass c) {
        System.out.println("=========================================");
        System.out.println("Class     : " + c.getName());
        System.out.println("Classroom : " + c.getClassroom());
        System.out.println("Teacher   : " + (c.getTeacher() != null ? c.getTeacher() + " - " + c.getTeacher() : "No teacher assigned"));
        System.out.println("Students  (" + c.getStudents().size() + "):");
        if (c.getStudents().isEmpty()) {
            System.out.println("   No students enrolled yet.");
        } else {
            for (int i = 0; i < c.getStudents().size(); i++){
                System.out.println("   - " + c.getStudents().get(i).getName() + " with id "  + c.getStudents().get(i).getId());
            }
        }
        System.out.println("=========================================");
    }

    public void displayStudentClasses(Student s, List<UniClass> sClasses) {
        if (sClasses.isEmpty()) {
            System.out.println(s.getName() + " is not enrolled in any class.");
            return;
        }
        System.out.println("Classes for " + s.getName() + " (ID: " + s.getId() + "):");
        for (UniClass c : sClasses) {
            System.out.println("   - " + c.getName() + " (Classroom: " + c.getClassroom() + ")");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }

    //Input methods
    public String readOption() {
        System.out.println("Select an option: ");
        return scanner.nextLine().trim();
    }

    public int promptInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String promptString(String message) {
        String value;
        do {
            System.out.println(message);
            value = scanner.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("This field cannot be empty, try again");
            }
        } while (value.isEmpty());
        return value;
    }

}