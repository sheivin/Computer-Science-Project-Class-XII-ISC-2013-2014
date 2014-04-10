/**
Class Binary contains an array of n integers (n<=100) that are already arranged in ascending order. 
The subscript of the array elements vary from 0 to n-1. The data members and member functions are as 
follows:-

Class name: Binary
Data members-
a[]     int array of 100 elements
n       size of the array
l       location of lower bound
u       location of upper bound
Member functions
Binary(int num)             constructor to initialize the size n=num and other instance variables
Void readdata()             to fill the elements of the array in ascending order
Int binary_search(int v)    returns the location of the value v after searching the list by using binary 
                            search technique using recursive technique. The function returns -1 if the
                            number is not present in the list.

Specify the class Binary giving details of the constructor and the functions. You need not written the 
function main().
 */
import java.io.*;
class Q9
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter size of array which is less than or equal to 100");
        int size=Integer.parseInt(obj.readLine());
        if(size>100)
        {
            System.out.println("Size more than limit. You are now exiting!");
            System.exit(0);
        }
        Binary A=new Binary(size);
        A.readdata();
        System.out.println("Enter element to be searched");
        int value=Integer.parseInt(obj.readLine());
        int result=A.binary_search(value);
        if(result == -1)
        {
            System.out.println("Element not present in the list");
        }
        else
        {
            System.out.println("Element present in the list at position - "+(result+1));
        }
    }
}
class Binary
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int a[];
    int n;
    int l;
    int u;
    Binary(int num)
    {
        n=num;
        a=new int[n];
        l=0;
        u=num-1;
        for(int i=0;i<n;i++)
        {
            a[i]=0;
        }
    }
    void readdata()throws IOException
    {
        System.out.println("Enter elements of array in ascending order");
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(obj.readLine());
        }
    }
    int binary_search(int v)
    {
        int m=(l+u)/2;
        if(l>u)
        {
            return (-1);
        }
        else if(a[m]>v)
        {
            u=m-1;
            return (binary_search(v));
        }
        else if(a[m]<v)
        {
            l=m+1;
            return (binary_search(v));
        }
        else
        {
            return (m);
        }
    }
}