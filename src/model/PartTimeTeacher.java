package model;

public class PartTimeTeacher extends Teacher {
    private int hoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int hoursPerWeek){
        super(name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculateSalary(){
        return 0;
    }

    @Override
    public String getType() {
        return "Part Time Teacher";
    }

    public int getHoursPerWeek() {return hoursPerWeek;}
    public void setHoursPerWeek(int hoursPerWeek) {this.hoursPerWeek = hoursPerWeek;}
    
}