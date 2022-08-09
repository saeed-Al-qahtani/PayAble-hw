Part1\
package day2.lastjava;

public interface PayAble {
    double computeAmount();
}
---------------------------------

Part 2\ 
package day2.lastjava;

public class PartTimeEmployee extends Employee{
    private int workHours;
    private int wage;
    public PartTimeEmployee(String name, int id,int workHours,int wage) {
        super(name, id);
        this.workHours=workHours;
        this.wage=wage;
    }

    @Override
    public double computeAmount() {
        return workHours * wage;
    }
}
-------------------------------------
Part3\ 
package day2.lastjava;

public class FullTimeEmployee extends Employee{
    private int weeklySalary;


    public FullTimeEmployee(String name, int id, int weeklySalary) {
        super(name, id);
        this.weeklySalary=weeklySalary;
    }

    @Override
    public double computeAmount() {
        return 4*weeklySalary;
    }

}
-------------------------------------
package day2.lastjava;

public abstract class Employee implements PayAble {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
-----------------------------------
package day2.lastjava;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<PayAble> arrayList=new ArrayList<PayAble>();


    public Company(String name) {
        this.name = name;
    }

    public boolean add(PayAble b){
        arrayList.add(b);
        return true;
    }

    public double computeAmount(){
        double sum=0;
        for (int i = 0; i < arrayList.size(); i++)
            sum+=arrayList.get(i).computeAmount();

        return sum;
        }



    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}
----------------------------------------------
package day2.lastjava;

public class Main {
    public static void main(String[]args){

        FullTimeEmployee fullTimeEmployee1=new FullTimeEmployee("Saleh",1,100);
        FullTimeEmployee fullTimeEmployee2=new FullTimeEmployee("Ali",2,50);
        PartTimeEmployee partTimeEmployee1=new PartTimeEmployee("Khalid",3,8,100);
        PartTimeEmployee partTimeEmployee2=new PartTimeEmployee("Noura",4,5,3);
        Company company=new Company("Tuwaiq");
        company.add(fullTimeEmployee1);
        company.add(fullTimeEmployee2);
        company.add(partTimeEmployee1);
        company.add(partTimeEmployee2);
        System.out.println(company);
        System.out.println(company.computeAmount());


    }
}