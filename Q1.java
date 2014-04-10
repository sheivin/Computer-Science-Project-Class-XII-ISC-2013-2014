/**
WAP to store 'N' different numbers in SDA where 'N' is always odd. Arrange them in such a way that
the smallest element should be in the middle position, second smallest element to the left side of it, 
third smallest to the right side and so on …..
    
    Input       :   71, 40, 66, 56, 19, 31, 85, 99, 23, 91, 59
    Output  :   91, 71, 59, 40, 23, 19, 31, 56, 66, 85, 99


    Class members are specified below:-
    Class name: arrange

    Data members:-
    arr []  :   integer type
    size    :   integer type variable to store size of array

    Member Functions:-
    Arrange (int n) :   parameterized constructor to initialize n to size
    Void input()        :   function to input an array of specified size
    Void arrange()  :   to arrange them in such a way that the smallest element should be in the middle position,
    second smallest element to the left side of it, third smallest to the right hand side and so on …..  
    Void dsiplay()  :   function to display the array before and after arrangement

    Specify the class arrange and also write the main() function.
 */

import java.io.*;
class Q1
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter size of array (size should be an odd number)");
        int n=Integer.parseInt(obj.readLine());
        if(n%2==0)
        {
            System.out.println("Size entered is invalid. You are now exiting.");
            System.exit(0);
        }
        arrange A=new arrange(n);
        A.input();
        A.display();
    }
}
class arrange
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int arr[];
    int size;
    arrange(int n)
    {
        size=n;
        arr=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=0;
        }
    }
    void input()throws IOException
    {
        System.out.println("Enter elements of array of specified size");
        int i=0;
        for(i=0;i<size;i++)
        {
            arr[i]=Integer.parseInt(obj.readLine());
        }
    }
    void arrange()
    {
        int t=0;
        int i=0;
        int j=0;
        int temp[]=new int[size];
        int u=size/2;
        int l=size/2-1;
        for(i=0;i<size;i++)
        {
            for(j=0;j<size-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        for(i=0;i<size;i++)
        {
            if(i%2==0)
            {
                temp[u]=arr[i];
                u++;
            }
            else
            {
                temp[l]=arr[i];
                l--;
            }
        }
        for(i=0;i<size;i++)
        {
            arr[i]=temp[i];
        }
    }
    void display()
    {
        System.out.print("Before arrangement : ");
        int i=0;
        for(i=0;i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        arrange();
        System.out.print("After arrangement : ");
        for(i=0;i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}