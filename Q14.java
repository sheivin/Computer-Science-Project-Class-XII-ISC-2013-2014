/**
A principal of a school needs to find the highest and lowest marks scored by the student and also 
merit list on marks from highest to lowest in a class of 5 students. The classes student and 
meritlist are declared for above activities with following details where student is base class and 
meritlist is derived class

Class name      :   student

Data members/instance variables:
Tot[ ]          :   (DOUBLE) an array to store total marks of 15 students
                    out of 500 each
stud[]          :   string array to store name of 15 students of a class

Member functions/methods:
void readdetails()  :   to input names and marks of 15 students. Marks are
                        given out of 500 each.
void printresult()  :   to print students scoring highest and lowest marks in
                        the class along with names of students.

Class name      :   meritlist

Data members/instance variables:    None

Member function / methods:
void printmerit()   :   to print merit list of 15 students in two columns in the
                        following format:

                        NAME        MARKS SCORED
                        X X X X     X X X X X X
                        X X X X     X X X X X X
                        X X X X     X X X X X X

Also write main().
 */
import java.io.*;
class Q14
{
    public static void main(String args[])throws IOException
    {
        meritlist A=new meritlist();
        A.readdetails();
        A.printresult();
        A.printmerit();
    }
}
class student
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    double Tot[]=new double[15];
    String stud[]=new String[15];
    void readdetails()throws IOException
    {
        System.out.println("Enter names and marks (out of 500) of 15 students");
        for(int i=0;i<15;i++)
        {
            stud[i]=obj.readLine();
            Tot[i]=Double.parseDouble(obj.readLine());
        }
    }
    void printresult()
    {
        double max=Tot[0];
        double min=Tot[0];
        for(int i=1;i<15;i++)
        {
            if(Tot[i]>max)
            {
                max=Tot[i];
            }
            if(Tot[i]<min)
            {
                min=Tot[i];
            }
        }
        System.out.println("Student/s with highest marks :");
        for(int i=0;i<15;i++)
        {
            if(Tot[i]==max)
            {
                System.out.println(stud[i]+"    \t"+max);
            }
        }
        System.out.println("Student/s with lowest marks :");
        for(int i=0;i<15;i++)
        {
            if(Tot[i]==min)
            {
                System.out.println(stud[i]+"    \t"+min);
            }
        }
    }
}
class meritlist extends student
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    void printmerit()throws IOException
    {
        String temp="";
        double m=0;
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15-i-1;j++)
            {
                if(Tot[j]<Tot[j+1])
                {
                    m=Tot[j];
                    Tot[j]=Tot[j+1];
                    Tot[j+1]=m;
                    temp=stud[j];
                    stud[j]=stud[j+1];
                    stud[j+1]=temp;
                }
            }
        }
        System.out.println("NAME"+"\t\t"+"MARKS SCORED");
        for(int i=0;i<15;i++)
        {
            System.out.println(stud[i]+"      \t"+Tot[i]);
        }
    }
}
