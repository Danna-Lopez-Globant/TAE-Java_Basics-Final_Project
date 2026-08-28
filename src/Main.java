import model.Controller;
import model.FullTimeTeacher;
import model.PartTimeTeacher;
import model.Student;
import model.Teacher;
import model.UniClass;
import model.University;
import userinterface.UiView;

public class Main {
    public static void main(String[] args){
        University university = new University();
        seedData(university);

        UiView view = new UiView();
        Controller controller = new Controller(university, view);

        controller.start();
    }

    private static void seedData(University university) {
        Teacher t1 = new FullTimeTeacher("Maria Gomez", 1200.0, 8);
        Teacher t2 = new FullTimeTeacher("Carlos Restrepo", 1300.0, 5);
        Teacher t3 = new PartTimeTeacher("Laura Diaz", 25.0, 12);
        Teacher t4 = new PartTimeTeacher("Andres Lopez", 30.0, 10);

        university.addTeacher(t1); 
        university.addTeacher(t2);
        university.addTeacher(t3); 
        university.addTeacher(t4);

        Student s1 = new Student("Juan Perez", "S001", 20);
        Student s2 = new Student("Ana Torres", "S002", 21);
        Student s3 = new Student("Pedro Ramirez", "S003", 19);
        Student s4 = new Student("Sofia Castro", "S004", 22);
        Student s5 = new Student("Diego Morales", "S005", 20);
        Student s6 = new Student("Valentina Ruiz", "S006", 23);

        university.addStudent(s1); 
        university.addStudent(s2); 
        university.addStudent(s3);
        university.addStudent(s4); 
        university.addStudent(s5); 
        university.addStudent(s6);

        UniClass c1 = new UniClass("Data Structures", "A-101", t1);
        c1.addStudent(s1); 
        c1.addStudent(s2); 
        c1.addStudent(s3);

        UniClass c2 = new UniClass("Databases", "B-202", t2);
        c2.addStudent(s2); 
        c2.addStudent(s4);

        UniClass c3 = new UniClass("Web Development", "C-303", t3);
        c3.addStudent(s3); 
        c3.addStudent(s5); 
        c3.addStudent(s6);

        UniClass c4 = new UniClass("Software Engineering", "D-404", t4);
        c4.addStudent(s1); 
        c4.addStudent(s6);

        university.addClass(c1); 
        university.addClass(c2);
        university.addClass(c3); 
        university.addClass(c4);
    }
}