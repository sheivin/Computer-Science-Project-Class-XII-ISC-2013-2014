/**
A bank intends to design a program to display the denomination of an input amount, upto 5 digits. 
The available denominations with the bank are of Rupees 1000, 500, 100, 50, 20, 10, 5, 2 and 1. 
Design a program to accept the amount from the user and display the break-up in descending order 
of denominations (i.e. preference should be given to the highest denomination available) along with 
the total number of notes. [Note: only the denominations used should be displayed].

Also print the amount in words according to the digits.

Example 1:

INPUT: 14836

OUTPUT: ONE FOUR EIGHT THREE SIX
DENOMINATION:
1000 X 14 =14000
500 X 1 =500
100 X 3 =300
50 X 1 =50
5 X 1 =5
1 X 1 =1
TOTAL=14856
TOTAL NUMBER OF NOTES = 21
EXAMPLE 2:

INPUT: 235001

OUTPUT: INVALID AMOUNT
 */
import java.io.*;
class Q17
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    static void amount_to_digits(int n)
    {
        int b=0;
        String a[]={"ZERO ","ONE ","TWO ","THREE ","FOUR ","FIVE ","SIX ","SEVEN ","EIGHT ","NINE ","TEN "};
        String s="";
        while(n!=0)
        {
            b=n%10;
            s=a[b]+s;
            n=n/10;
        }
        System.out.println(s);
    }
    static void denomination(int n)
    {
        int i=0;
        int j=n;
        int b=0;
        int sum=0;
        int p=0;
        System.out.println("DENOMINATION:");
        int a[]={1000,500,100,50,20,10,5,2,1};
        for(i=0;i<9;i++)
        {
            b=n/a[i];
            sum=sum+b;
            p=a[i]*b;
            if(b>0)
            {
                System.out.println(a[i]+" X "+b+" = "+p);
            }
            n=n-p;
        }
        System.out.println("TOTAL = "+j);
        System.out.println("TOTAL NUMBER OF NOTES = "+sum);
    }
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter amount");
        int amount=Integer.parseInt(obj.readLine());
        if(amount>=100000)
        {
            System.out.println("INVALID AMOUNT");
        }
        else
        {
            amount_to_digits(amount);
            denomination(amount);
        }
    }
}