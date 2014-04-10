/**
A line on a plane can be represented by the coordinates of the two end points L and M as L(x1,y1) 
and M(x2,y2). A class Point is defined to represent a line as follows:-

Class name          Point1

Data members    x1,y1,x2,y2 to store the coordinates of the end points of a line
Member functions
Point1()        contructor
Void accept()   to accept the values of coordinates
Void print()    to print the values of coordinates

Another class circle is defined to represent the circle and calculates its area as follows:-

Class name          Circle

Data members        radius to store radius and area for area of circle

Member functions
cal_length()    calculate the length of the radius of the circle.i.e distance between L and M
cal_area()      calculates the area of the circle .
print()         displays coordinates of the radius, its length and area of the circle.

Using the concept of inheritance defines the above classes and all the functions in them.
 */
import java.io.*;
class Q11
{
    public static void main(String args[])throws IOException
    {
        Circle A=new Circle();
        A.accept();
        A.cal_length();
        A.cal_area();
        A.print();
    }
}
class Point1
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    double x1;
    double y1;
    double x2;
    double y2;
    Point1()
    {
        x1=0.0;
        y1=0.0;
        x2=0.0;
        y2=0.0;
    }
    void accept()throws IOException
    {
        System.out.println("Enter X-coordinate of L");
        x1=Double.parseDouble(obj.readLine());
        System.out.println("Enter Y-coordinate of L");
        y1=Double.parseDouble(obj.readLine());
        System.out.println("Enter X-coordinate of M");
        x2=Double.parseDouble(obj.readLine());
        System.out.println("Enter Y-coordinate of M");
        y2=Double.parseDouble(obj.readLine());
    }
    void print()
    {
        System.out.println("The coordinates are : ("+x1+","+y1+") and ("+x2+","+y2+")");
    }
}
class Circle extends Point1
{
    double radius;
    double area;
    void cal_length()
    {
        double d=((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
        radius=Math.sqrt(d);
    }
    void cal_area()
    {
        area=3.141592654*radius*radius;
    }
    void print()
    {
        super.print();
        System.out.println("Length of radius is : "+radius+" units");
        System.out.println("Area of the circle is : "+area+" square units");
    }
}