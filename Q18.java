/**
A class replace is declared to perform string related operations. Some of the members of the 
class are as follows:-

Class name          :   replace

Data member/instance variables:
String str , substr

Member function/methods:
Replace()               :   a constructor .
Replace (String s)      :   a constructor to assign s to str
void display()          :   to print value of str ,substr and frequency of
                            substr in str.
void getword (String ss):   to assign ss (it is a string no blank space) to substr
int find_frequency ()   :   to find frequency of substr in str and return the frequency
                            substr can occur in sub word also.

For example:-
Str = “aaa abc aa bcd”
Substr = “aa”
It should return =2.

Also write main().
 */
import java.io.*;
class Q18
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter String and Substring");
        String s=obj.readLine();
        String ss=obj.readLine();
        replace A=new replace(s);
        A.getword(ss);
        A.display();
    }
}
class replace
{
    String str;
    String substr;
    replace()
    {
        str="";
        substr="";
    }
    replace(String s)
    {
        str=s;
    }
    void display()
    {
        System.out.println("Original String: "+str);
        System.out.println("Substring: "+substr);
        int freq=find_frequency();
        System.out.println("Frequency: "+freq);
    }
    void getword(String ss)
    {
        substr=ss;
    }
    int find_frequency()
    {
        int f=0;
        int i=0;
        String temp="";
        int l1=str.length();
        int l2=substr.length();
        for(i=0;i<l1-l2+1;i++)
        {
            temp=str.substring(i,i+l2);
            if(temp.equals(substr)==true)
            {
                f++;
            }
        }
        return f;
    }
}
