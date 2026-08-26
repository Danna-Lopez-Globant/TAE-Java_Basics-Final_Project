package userinterface; //Naming the directory UI/ui mark an error

import model.Teacher;

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

    }
}