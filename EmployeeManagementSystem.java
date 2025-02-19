interface Payable{
    double getPaymentAmount();
}

abstract class Employee{
    String name;
    int id;
    int baseSalary;

    Employee(String n, int i, int s){
        name = n;
        id = i;
        baseSalary = s;
    }
    abstract int calculateSalary();

    void displayEmployeeInfo(){
        System.out.printf("ID: %d, Name: %s, Base Salary: $%d\n",id,name,baseSalary);
    }

}

class FullTimeEmployee extends Employee implements Payable {
    int baseSalary;

    FullTimeEmployee(String n, int i, int b){
        super(n,i,b);
        baseSalary = b;
    }

    @Override
    int calculateSalary(){
        return (int)(baseSalary * 1.2);
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
    @Override
    public void displayEmployeeInfo(){
        super.displayEmployeeInfo();
        System.out.println("Total Salary: $" + getPaymentAmount());
    }
}

class ContractEmployee extends Employee implements Payable {
    int hoursWorked;
    int hourlyWage;

    ContractEmployee(String n, int i, int h, int hw){
        super(n,i,0);
        hourlyWage = hw;
        hoursWorked = h;
    }

    @Override
    int calculateSalary(){
        return hourlyWage * hoursWorked;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
    @Override
    public void displayEmployeeInfo(){
        super.displayEmployeeInfo();
        System.out.println("Total Salary: $" + getPaymentAmount());
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee jumabek = new FullTimeEmployee("Jumabek", 01, 5000);
        Employee bekbolsun = new ContractEmployee("Bekbolsun", 07, 120, 30);

        jumabek.displayEmployeeInfo();
        bekbolsun.displayEmployeeInfo();
    }
}
