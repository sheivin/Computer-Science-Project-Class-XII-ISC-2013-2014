/**
Define a class RevWord with following specifications :

Class Name          RevWord
Data member         String str
Member Functions
void getstring( )           to input string in str
void rev( String s,int l)   to reverse string and print it recursively.
Void print()                to print every word of str in reverse order with help of rev() function.

e.g.
Input   Faith is the force of life .
Output  htiaF si eht ecrof fo efil.

Also write main ( ) function for above class.
 */
import java.io.*;
class Q10
{
    public static void main(String args[])throws IOException
    {
        RevWord A=new RevWord();
        A.getstring();
        A.print();
    }
}
class RevWord
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    String str;
    void getstring()throws IOException
    {   
        System.out.println("Enter String");
        str=obj.readLine();
    }
    void rev(String s, int l)
    {
        if(l>=1)
        {
            char ch=s.charAt(l-1);
            System.out.print(ch);
            rev(s,l-1);
        }
    }
    void print()
    {
        String temp="";
        int temp_l=0;
        str=str+" ";
        char ch=' ';
        int i=0;
        int l=str.length();
        for(i=0;i<l;i++)
        {
            ch=str.charAt(i);
            if((ch>='A'&&ch<='Z') || (ch>='a'&&ch<='z'))
            {
                temp=temp+ch;
            }
            else
            {
                temp_l=temp.length();
                rev(temp,temp_l);
                System.out.print(ch);
                temp="";
                temp_l=0;
            }
        }
        System.out.println();
    }
}
