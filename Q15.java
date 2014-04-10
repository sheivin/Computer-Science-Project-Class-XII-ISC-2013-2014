/**
You are given a string with English sentences as data. You have to read it and output after 
formatting it so that each sentence is on a new line with no leading blanks. A sentence is 
recognized by the following pattern: Full stop, followed by a space, followed by a capital 
letter. Note that just a full stop by itself does not indicate a sentence since full stop may 
be a part of a decimal number.

Class name      :   format

Data members:-
str (to store the given string)
len(to store the length of the string)

Member function/ methods:-
Format ()                       :   Constructor
Void read_string()              :   reads the string from the input.
Int is_end_of_sentence (int i)  :   returns 1 if the end of a sentence has been reached at the 
                                    character position ‘i’ in the string, 0 otherwise
void format_string ()           :   using the method is_end_of_sentence() formats and outputs the 
                                    given string in such a manner that each sentence is on a new line 
                                    with no leading blanks.

Specify the class format  and write the main() function.
 */
import java.io.*;
class Q15
{
    public static void main(String args[])throws IOException
    {
        format A=new format();
        A.read_string();
        A.format_string();
    }
}
class format
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    String str;
    int len;
    format()
    {
        str="";
        len=0;
    }
    void read_string()throws IOException
    {
        System.out.println("Enter string to be formatted");
        str=obj.readLine();
    }
    int is_end_of_sentence(int i)
    {
        char ch1=str.charAt(i);
        char ch2=str.charAt(i+1);
        char ch3=str.charAt(i+2);
        if((ch1=='.') && (ch2==' ') && ((ch3>='A')&&(ch3<='Z')))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    void format_string()
    {
        len=str.length();
        int i=0;
        String temp="";
        char ch=' ';
        int c=0;
        for(i=0;i<len-2;i++)
        {
            ch=str.charAt(i);
            c=is_end_of_sentence(i);
            if(c==1)
            {
                temp=temp+ch;
                System.out.println(temp);
                temp="";
                c=0;
                i=i+1;
            }
            else
            {
                temp=temp+ch;
            }
        }
        temp=temp+str.charAt(len-2)+str.charAt(len-1);
        System.out.println(temp);
    }
}
