/**
Design a program which accepts your date of birth in dd mm yyyy format. Check whether the date entered
is a valid date or not. If it is valid, display “VALID DATE”. Also compute and display the day number 
of the year for the date of birth and the date in words as given in example. If it is invalid, display
“INVALID DATE” and then terminate the program.

Test your program with the sample data and some random data:

EXAMPLE 1:
INPUT: Enter your date of birth in dd mm yyyy format
05
01
2013
OUTPUT:	VALID DATE
5
5th January 2013

EXAMPLE 2:
INPUT: Enter your date of birth in dd mm yyyy format
03
04
2010
OUTPUT:	VALID DATE
93
3rd April 2013

EXAMPLE 3:
INPUT: Enter your date of birth in dd mm yyyy format
34
06
2013
OUTPUT:	INVALID DATE
 */
import java.io.*;
class Q5
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    static int dd;
    static int mm;
    static int yyyy;
    static String day[]={"th","st","nd","rd"};
    static String month[]={""," January "," February "," March "," April "," May "," June "," July "," August "," September "," October "," November "," December "};
    static int nyear[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static int lyear[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
    static void date_numbers()
    {
        int n=0;
        if(((yyyy%4==0)&&(yyyy%100!=0))||(yyyy%400==0))
        {
            for(int i=1;i<mm;i++)
            {
                n=n+lyear[i];
            }
            n=n+dd;
        }
        else
        {
            for(int i=1;i<mm;i++)
            {
                n=n+nyear[i];
            }
            n=n+dd;
        }
        System.out.println(n);
    }
    static void date_to_words()
    {
        String d=""+dd;
        String year=""+yyyy;
        String s="";
        if(dd<=3)
        {
            s=d+day[dd]+month[mm]+year;
        }
        else
        {
            s=d+day[0]+month[mm]+year;
        }
        System.out.println(s);
    }
    static int valid_date()
    {
        int flag=0;
        if((mm>=1&&mm<=12) && yyyy>=1)
        {
            if(((yyyy%4==0)&&(yyyy%100!=0))||(yyyy%400==0))
            {
                if(dd>=0&&dd<=lyear[mm])
                {
                    flag=1;
                }
                else
                {
                    flag=0;
                }
            }
            else
            {
                if(dd>=0&&dd<=nyear[mm])
                {
                    flag=1;
                }
                else
                {
                    flag=0;
                }
            }
        }
        else
        {
            flag=0;
        }
        return flag;
    }
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter your date of birth in dd mm yyyy format");
        dd=Integer.parseInt(obj.readLine());
        mm=Integer.parseInt(obj.readLine());
        yyyy=Integer.parseInt(obj.readLine());
        int c=valid_date();
        if(c==0)
        {
            System.out.println("INVALID DATE");
        }
        else
        {
            System.out.println("VALID DATE");
            date_numbers();
            date_to_words();
        }
    }
}
            