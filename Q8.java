/**
Declare a class “point” which contains following-
Data members:
A[][]   :  double dimensional array
R       :   integer to store row size
C       :   integer to store column size

Member  functions:

point(int  p, int q)        :   constructor to assign p to R and q to C and create array
                                of R X C order.
void get_ array()           :   to input a double dimensional array in the form of
                                matrix of given rows and columns.
void display_mat()          :   to print the entered matrix.
int check  _pseudo(int a[]) :   to check and find whether elements in each row are
                                pseudo numbers or not and return 1 if  numbers in rows are pseudo numbers
                                else return 0.
void result()               :   to invoke check_pseudo() to find whether the numbers in each row are pseudo
                                numbers or not and display the result in given format.
Input matrix
3  5  2  4
2  5  4  9
8  6  8  7

The output
Row 1 -> pseudo numbers
Row 2 -> not pseudo numbers
Row 3 -> not pseudo numbers

For example 3, 6, 4, 2, 5 are pseudo numbers as
3+5=8
6+2=8
4+4=8 [middle number add twice if no of column odd]
And 3x8=24 which is equal to sum all groups so formed.
For example 7, 9, 5, 84, 6 are pseudo numbers as
7+6=13  9+4=13  5+8=13  And 3x13=39 which is equal to sum all groups so formed.
 */
import java.io.*;
class Q8
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter number of rows and columns");
        int r=Integer.parseInt(obj.readLine());
        int c=Integer.parseInt(obj.readLine());
        point A=new point(r,c);
        A.get_array();
        A.display_mat();
        A.result();
    }
}
class point
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int A[][];
    int R;
    int C;
    point(int p, int q)
    {
        R=p;
        C=q;
        A=new int[R][C];
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                A[i][j]=0;
            }
        }
    }
    void get_array()throws IOException
    {
        System.out.println("Enter Array");
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                A[i][j]=Integer.parseInt(obj.readLine());
            }
        }
    }
    void display_mat()
    {
        int i=0;
        int j=0;
        System.out.println("Input Matrix");
        for(i=0;i<R;i++)
        {
            for(j=0;j<C;j++)
            {
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }
    int check_pseudo(int a[])
    {
        int l=a.length;
        int i=0;
        int c=0;
        int sum=a[0]+a[l-1];
        int sum1=0;
        for(i=1;i<=(l/2);i++)
        {
            c++;
            sum1=a[i]+a[l-i-1];
            if(sum!=sum1)
            {
                return 0;
            }
        }
        return 1;
    }
    void result()
    {
        int a[]=new int[C];
        int i=0;
        int j=0;
        int k=0;
        System.out.println("The output");
        for(i=0;i<R;i++)
        {
            for(j=0;j<C;j++)
            {
                a[j]=A[i][j];
            }
            k=check_pseudo(a);
            if(k==1)
            {
                System.out.println("Row "+(i+1)+" --> Pseudo numbers");
            }
            else
            {
                System.out.println("Row "+(i+1)+" --> Not pseudo numbers");
            }
        }
    }
}