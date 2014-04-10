/**
A class staff is declared with the following details:-

Class name          Staff

Data members
Code_num            int to store staff code number
Sname               to store staff name
Basic               to store basic salary

Member functions
Staff()             contructor
Void input()        to accept the values
Void printdata()    to print values

Another class Overtime is declared as:-

Class name          Overtime

Data members
ndays               to store the number of days worked
ex_hrs              to store the number of hours worked per day
rate                rate per hour

Member functions
Overtime(int n,doubl r,int h)   constructor to assign n to ndays, r to rate and h to ex_hrs.
Double calculate()              to calculate the total salary(number of days worked *rate per hour*number 
                                of hours worked per day+basic salary) and returns total salary.
Void show_salary()              to display number of days worked ,rate and total salary.

Using the concept of inheritance defines the above classes and all the functions in them. The main function 
need not to be written.
 */
import java.io.*;
class Q12
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter number of days worked, rate per hour and number of hours worked");
        int n=Integer.parseInt(obj.readLine());
        double r=Double.parseDouble(obj.readLine());
        int h=Integer.parseInt(obj.readLine());
        Overtime A=new Overtime(n,r,h);
        A.input();
        A.show_salary();
    }
}
class Staff
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int Code_num;
    String Sname;
    double Basic;
    Staff()
    {
        Code_num=0;
        Sname="";
        Basic=0.0;
    }
    void input()throws IOException
    {
        System.out.println("Enter staff code number, staff name and basic salary");
        Code_num=Integer.parseInt(obj.readLine());
        Sname=obj.readLine();
        Basic=Double.parseDouble(obj.readLine());
    }
    void printdata()
    {
        System.out.println("Staff Code - "+Code_num);
        System.out.println("Staff Name - "+Sname);
        System.out.println("Staff's Basic Salary - "+Basic);
    }
}
class Overtime extends Staff
{
    int ndays;
    int ex_hrs;
    double rate;
    Overtime(int n, double r, int h)
    {
        super();
        ndays=n;
        rate=r;
        ex_hrs=h;
    }
    Double calculate()
    {
        double ts=(ndays*rate*ex_hrs)+Basic;
        return ts;
    }
    void show_salary()
    {
        super.printdata();
        System.out.println("Number of days worked - "+ndays);
        System.out.println("Rate - "+rate);
        double tot_sal=calculate();
        System.out.println("Total salary - "+tot_sal);
    }
}
