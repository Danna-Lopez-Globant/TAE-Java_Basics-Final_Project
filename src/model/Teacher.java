package model;

public abstract class Teacher {
    private static int count = 0;

    private final int id;
    protected String name;
    protected double baseSalary;

    public Teacher(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        count++;
        this.id = count;
    }

    public abstract double calculateSalary();
    public abstract String getType();

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getBaseSalary() {return baseSalary;}
    
    public void setBaseSalary(double baseSalary) {this.baseSalary = baseSalary;}

    public int getId() {return id;}

    public static int getTeacherCount() {return count;}

    @Override
    public String toString() {
        return "Id: " + id + "\nname: " + name + "\ntype: " + getType() + "\nbase salary: " 
        + baseSalary + "\ncalculated salary: " + calculateSalary() + "\n";
    }
    
}