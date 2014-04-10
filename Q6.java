/**
The trigonometric function sec(x) can be computed as

sec(x) = 1/cos(x)       x is in radians and (0 <= x <= π/2)

The trigonometric function cos(x) can be computed by the following infinite series:

cos(x) = 1 - (x^2)/2! + (x^4)/4! - (x^6)/6!………   x is in radians and (0 <= x <= π/2)

A class called MyMath has been defined to calculate the trigonometric functions. Some of the functions/methods
in MyMath are shown below:

Class Name : MyMath
Data Members/instance variables: x - angle in radians
Member function/methods:
MyMath(double nx)       :   constructor to assign x = nx
double abs(double y)    :   calculates and returns the absolute value of y
y = y when y>= 0 and y = -y when y<0
double cos()     :   calculates and returns the value of cos()  correct
                     to 7 places after the decimal using the infinite series given 
                     above when x is within the range otherwise it 
                     returns an error value of 9999999.9
double sec()    :   calculates and returns the value of sec() by
                    using the value of cos()
(remember when x is in radians and 0 <= x <= π/2 then 1 >= cos() >= 0)

Specify the class MyMath giving details of the constructor MyMath(double nx), double abs(double y), double cos(),
 double sec() only.
 */
import java.io.*;
class Q6
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter angle in radians");
        double nx=Double.parseDouble(obj.readLine());
        MyMath A=new MyMath(nx);
        double value_cos=A.cos();
        double value_sec=A.sec();
        if(value_cos==9999999.9)
        {
            System.out.println("Angle not within proper range. You are now exiting!");
            System.exit(0);
        }
        System.out.println("cos "+nx+" = "+value_cos);
        System.out.println("sec "+nx+" = "+value_sec);
    }
}
class MyMath
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    double x;
    MyMath(double nx)
    {
        x=nx;
    }
    double abs(double y)
    {
        if(y>=0)
        {
            return y;
        }
        else
        {
            return (-y);
        }
    }
    double cos()
    {
        double err=9999999.9;
        double pow=0.0;
        int fact=1;
        int sign=-1;
        int c=2;
        double t=0;
        long a=0;
        long b=0;
        double t1=0;
        double value=1.0;
        if(x>=0&&x<=(3.141592654/2))
        {
            while(true)
            {
                a=b;
                pow=1;
                fact=1;
                for(int i=1;i<=c;i++)
                {
                    fact=fact*i;
                    pow=pow*x;
                }
                c=c+2;
                value=value + sign*(pow/fact);
                t=Math.pow(10,7)*value;
                b=(long)t;
                if(a==b)
                {
                    t1=Math.round(t);
                    t=t1/Math.pow(10,7);
                    return t;
                }
                sign=sign*(-1);
            }
        }
        else
        {
            return err;
        }
    }
    double sec()
    {
        double c=cos();
        if(c==9999999.9)
        {
            return 9999999.9;
        }
        else
        {
            double s=1/c;
            double t=Math.pow(10,7)*s;
            t=Math.round(t);
            s=t/Math.pow(10,7);
            return s;
        }
    }
}