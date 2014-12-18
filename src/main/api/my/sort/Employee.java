package main.api.my.sort;


public class Employee implements Comparable<Employee> {

    private int    empSalary;
    private String empName;
    private int    empAge;


    public Employee(String empName,int empAge,int empSalary) {
        this.empName    =   empName;
        this.empSalary  =   empSalary;
        this.empAge        =   empAge;
    }


    public String getEmpName() {
        return empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public int getEmpSalary() {
        return empSalary;
    }




    public int compareTo(Employee e) {

        if(e.getEmpSalary() > this.getEmpSalary())  {
            return -1;
        }
        else {
            return 1;
        }
    }
}

