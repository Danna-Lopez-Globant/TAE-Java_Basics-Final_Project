# TAE-Java_Basics-Final_Project

# University Management System — Java Basics Final Project

Console-based Java application to manage a university's teachers, students and classes.

## Features

- Print all teachers with their calculated salary (polymorphic, based on teacher type).
- List all classes and view the detail of one, including its teacher and enrolled students.
- Create a new student and enroll them in an existing class.
- Create a new class, assigning an existing teacher and one or more existing students.
- Search all classes a given student belongs to, by student ID.

## Requirements covered

- **Access modifiers**: private fields, protected fields in `Teacher` (used by its subclasses), public constructors/methods.
- **Encapsulation**: all model fields are private (or protected where inheritance needs it), accessed only through getters/setters.
- **Inheritance**: `FullTimeTeacher` and `PartTimeTeacher` extend the abstract class `Teacher`.
- **Polymorphism**: `calculateSalary()` and `getType()` behave differently per subclass, called through `Teacher` references.
- **Constructors**: every model, view and controller class has an explicit constructor.
- **Static attributes/methods**: `Teacher.teacherCount` (private static attribute) and `Teacher.getTeacherCount()` (public static method); same pattern in `Student` and `UniClass`.
- **Main class**: `Main` — the composition root that wires the MVC layers together.
- **Packages and layers (MVC)**:
  - `model` — domain entities and business/query logic: `Teacher`, `FullTimeTeacher`, `PartTimeTeacher`, `Student`, `UniClass`, `University`. No console I/O of any kind happens here.
  - `view` — `UiView`: the only class that touches `System.out`/`Scanner`. Pure input/output, no business rules.
  - `controller` — `Controller`: orchestrates the application flow between the Model and the View.
  - `Main`: creates the Model, the View and the Controller, then starts the app.
- **Reading and printing** happen entirely inside `UiView` (the View layer). The Model never touches `System.out`/`Scanner`, and the Controller only decides *what* to show, never *how*.

## Salary rules

- Full time teacher: `baseSalary * 1.10 * experienceYears`
- Part time teacher: `baseSalary * activeHoursPerWeek`

## How to run

Open the project in IntelliJ IDEA and run `Main`, or from the command line:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Menu options

1. Print all teachers with their data
2. Print all classes and view the detail of one
3. Create a new student and add them to an existing class
4. Create a new class and assign an existing teacher and students
5. List all classes a given student (by ID) belongs to
6. Exit

## Design diagram

An exported version is also available at [`docs/UML.pdf`](docs/UML.pdf).