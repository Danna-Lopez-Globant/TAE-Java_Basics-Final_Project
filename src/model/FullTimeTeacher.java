package model;

public class FullTimeTeacher extends Teacher {
    private int yearsExperience;

    public FullTimeTeacher(String name, double baseSalary, int yearsExperience){
        super(name, baseSalary);
        this.yearsExperience = yearsExperience;
    }

    @Override
    public double calculateSalary(){
        return 0;
    }

    @Override
    public String getType() {
        return "Full Time Teacher";
    }

    public int getyearsExperience() {return yearsExperience;}
    public void setyearsExperience(int yearsExperience) {this.yearsExperience = yearsExperience;}

    
}