/**
The computer department of the Agency of International Espionage is trying to decode intercepted 
messages. The agency’s spies have determined that the enemy encodes messages by first converting 
all characters to their ASCII values and then reversing the string.

For example, consider A_z (the underscore is just to highlight the space). The ASCII values of 
A. <space>, z are 65, 32, 122 respectively. Concatenate them to get 6532122, then reverse this to 
get 2212356 as the code message.

Write a program which reads a coded message and decodes it. The coded message will not exceed 200 
characters. It will contain only alphabets (A …. Z, and a ….z) and spaces. ASCII values of A …Z are 
65 ...90 and those of a …z are 97 …122. Test your program for the following data and some random data.

SAMPLE DATA:

INPUT;
Encode message:
2 3 1 2 1 7 9 8 6 2 3 1 0 1 9 9 5 0 1 8 7 2 3 7 9 2 31 0 1 8 1 1 7 9 2 7

OUTPUT:
THE DECODED MESSAGE: Have a Nice Day

INPUT;
Encode message:
2 3 5 1 10 1 1 5 0 1 7 8 2 3 5 1 1 1 2 1 7 9 9 1 1 8 0 1 5 6 2 3 4 0 1 6 1 1 7 1 1 4 1 1 4 8

OUTPUT:
THE DECODED MESSAGE: Truth Always Wins
*/
import java.io.*;
class Q20
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter the encoded message");
        String s1=obj.readLine();
        String t="";
        int n=0;
        char a=' ';
        char ch=' ';
        String s2="";
        String f="";
        int l=s1.length();
        if(l>200)
        {
            System.out.println("Input code limit exceeded. You are now exiting.");
            System.exit(0);
        }
        int i=0;
        for(i=0;i<l;i++)
        {
            ch=s1.charAt(i);
            s2=ch+s2;
        }
        System.out.print("THE DECODED MESSAGE : ");
        for(i=0;i<l-2;i++)
        {
            t=s2.substring(i,i+2);
            n=Integer.parseInt(t);
            if(n==32)
            {
                f=f+" ";
                i++;
            }
            else if((n>=65 && n<=90) || (n>=97 && n<=99))
            {
                a=(char)n;
                f=f+a;
                i++;
            }
            else
            {
                t=s2.substring(i,i+3);
                n=Integer.parseInt(t);
                a=(char)n;
                f=f+a;
                i=i+2;
            }
        }
        System.out.println(f);
    }
}
