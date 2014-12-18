package main.api.my.sort;

import main.api.my.sort.insertion.InsertionSorter;

public class SortTester {


    private SortTester() {

    }

    public static void main(String...s) {

        Comparable<Employee>[] employee =   new Comparable[4];
        Employee employee1  =   new Employee("sandeep",22,100);
        Employee employee2  =   new Employee("kakke",23,200);
        Employee employee3  =   new Employee("ankit",24,300);
        Employee employee4  =   new Employee("puneet",25,400);



        employee[0]         =   employee1;
        employee[1]         =   employee2;
        employee[2]         =   employee3;
        employee[3]         =   employee4;


        Sorter<Employee> letsSort   =   new InsertionSorter<Employee>();
        Comparable<Employee>[]  sortedArray  =   letsSort.sort(employee);

        for(int i   =   0;i < sortedArray.length ; i++) {
            Employee    employee5   =   (Employee)sortedArray[i];

            System.out.println(employee5.getEmpAge());
        }

    }

    public static SortTester createSortTester() {
        return new SortTester();
    }
}
