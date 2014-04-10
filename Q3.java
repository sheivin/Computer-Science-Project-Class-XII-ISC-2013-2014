/**
A Sentence is terminated by either “.” , “!” or “?” followed by a space. Input  a piece of text consisting
of sentences. Assume that there will be a maximum of 10 sentences in block letters. 

Class name      :   Sentence

Data members
String str      :   to store sentence

Member functions :
void input( )       :   to input any string in  str
int vowel(char)     :   to return 1 if character is a vowel else return 0
int words(String s) :   to return number of words in string s.
void out_graph ()   :   to display the output and graph as follows

Input
HELLO! HOW ARE YOU? HOPE EVERYTHING IS FINE. BEST OF LUCK

OUTUT
SENTENCE    NO OF VOWELS        NO OF WORDS
1           2                   1
2           5                   3
3           8                   4
4           3                   3
GRAPH
Sentence        No of words/Vowels

1.          VVVVVV
            WWW

2.          VVVVVVVVVVVVVVV
            WWWWWWWWW

3.          VVVVVVVVVVVVVVVVVVVVVVVV
            WWWWWWWWWWWW

4.          VVVVVVVVV
            WWWWWWWWW

Graph Ratio 1:3 
*/
import java.io.*;
class Q3
{
    public static void main(String args[])throws IOException
    {
        Sentence A=new Sentence();
        A.input();
        A.out_graph();
    }
}
class Sentence
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    String str;
    void input()throws IOException
    {
        System.out.println("Input (a maximum of 10 sentences)");
        str=obj.readLine();
    }
    int vowel(char ch)
    {
        switch(ch)
        {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return 1;
            default:
                return 0;
        }
    }
    int words(String s)
    {
        int c=0;
        char ch=' ';
        int i=0;
        s=s+" ";
        int l=s.length();
        for(i=0;i<l;i++)
        {
            ch=s.charAt(i);
            if(ch==' ')
            {
                c++;
            }
        }
        return c;
    }
    void out_graph()throws IOException
    {
        str=str+" ";
        int l=str.length();
        int w[]=new int[10];
        int v[]=new int[10];
        int i=0;
        int j=0;
        int c=0;
        String temp="";
        char ch=' ';
        char ch1=' ';
        for(i=0;i<(l-1);i++)
        {
            ch=str.charAt(i);
            ch1=str.charAt(i+1);
            if(((ch=='.')||(ch=='!')||(ch=='?')) && ch1==' ')
            {
                w[c]=words(temp);
                i++;
                temp="";
                c++;
            }
            else
            {
                temp=temp+ch;
                v[c]=v[c]+vowel(ch);
            }
        }
        System.out.println("OUTPUT\nSENTENCE NO OF VOWELS\tNO OF WORDS");
        for(i=0;i<c;i++)
        {
            System.out.println((i+1)+"\t \t"+v[i]+"\t \t"+w[i]);
        }
        System.out.println("GRAPH\nSentence\tNo of words/Vowels");
        for(i=0;i<c;i++)
        {
            System.out.print((i+1)+"\t \t");
            for(j=0;j<v[i];j++)
            {
                System.out.print("VVV");
            }
            System.out.print("\n \t \t");
            for(j=0;j<w[i];j++)
            {
                System.out.print("WWW");
            }
            System.out.println();
        }
        System.out.println("Graph Ratio 1:3");
    }
}
