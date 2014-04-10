/**
An ISBN (International Standard Book Number) is a ten digit code which uniquely identifies a book.
The first nine digits represent the group, publisher and title of the book and the last digit is 
used to check whether ISBN is correct or not.
Each of the first nine digits of the code can take a value between 0 to 9. Sometimes it is necessary 
to make the last digit equal to ten. This is done by writing the last digit of the code as X.
To verify an ISBN, calculate 10 times the first digit, plus 9 times the second digit, plus 8 times 
the third digit and so on until we add 1 time the last digit. If the final number leaves no remainder 
while divided by 11, the code is a valid ISBN

For example:

0201103311=10*0+9*2+8*0+7*1+6*1+5*0+4*3+3*3+2*1+1*1=55
This is a valid ISBN

007462542X=10*0+9*0+8*7+7*4+6*6+5*2+4*5+3*4+2*2+1*10=176
This is a valid ISBN

Similarly 0112112425 is not a valid ISBN.

Test Data:-

Input code: 0201530821
Output: Sum=99
Leaves no remainder – valid ISBN

Input code: 356680324
Output: Sum=invalid input

Input code: 0231428031
Output: Sum=122
Leaves remainder – invalid ISBN
 */
import java.io.*;
class Q19
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter the code");
        String s1=obj.readLine();
        int l=s1.length();
        if(l!=10)
        {
            System.out.println("Sum=invalid input");
            System.exit(0);
        }
        int a[]=new int[10];
        int n=0;
        char ch=' ';
        int i=0;
        for(i=0;i<10;i++)
        {
            ch=s1.charAt(i);
            if(ch=='X')
            {
                a[i]=10;
            }
            else
            {
                n=ch-48;
                a[i]=n;
            }
        }
        int s=0;
        for(i=0;i<10;i++)
        {
            s=s+(a[i]*(10-i));
        }
        System.out.println("Sum="+s);
        if(s%11==0)
        {
            System.out.println("Leaves no remainder - valid ISBN");
        }
        else
        {
            System.out.println("Leaves remainder - invalid ISBN");
        }
    }
}