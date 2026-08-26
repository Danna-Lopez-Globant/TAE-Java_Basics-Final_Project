package model;

import model.Teacher;
import model.Student;
import model.UniClass;
import model.University;
import userinterface.UiView;

public class Controller {

    private final University university;
    private final UiView view;

    public Controller(University university, UiView view){
        this.university = university;
        this.view = view;
    }

}