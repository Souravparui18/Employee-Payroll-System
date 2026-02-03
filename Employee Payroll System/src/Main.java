import java.util.ArrayList;

abstract class Employee {
    private String name;
    private  int Id;

    public Employee(String name, int Id) {
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name= " + name + " Id= " + Id + " Salary= "+ calculateSalary() + "]";
    }
}
 class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int Id, int monthlySalary) {
        super(name,Id);
        this.monthlySalary = monthlySalary;
    }

    @Override
     public double calculateSalary(){
        return monthlySalary;
    }
 }

 class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int Id, int hourlyRate, int hoursWorked) {
        super(name,Id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
     public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
 }

 class PayRollSystem {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public PayRollSystem(){

    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int Id) {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList) {
            if(employee.getId() == Id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for(Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
 }
public class Main {
    public void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("sourav", 1, 100000);
        FullTimeEmployee emp2 = new FullTimeEmployee("sonu", 2, 70000);
        PartTimeEmployee emp3 = new PartTimeEmployee("vikas",3,700,120 );

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        payRollSystem.addEmployee(emp3);
        System.out.println("------Intial employees------");
        payRollSystem.displayEmployees();
        System.out.println("-----Removing employees-----");
        payRollSystem.removeEmployee(1);
        System.out.println("-----Intial employees-----");
        payRollSystem.displayEmployees();


    }
}
