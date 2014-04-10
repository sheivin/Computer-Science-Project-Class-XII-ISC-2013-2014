/**
A set is a collection in which there is no duplication of elements. A multiset is a collection in 
which elements can be duplicate. For example
S   =   {1,2,3,4} is a set with integer elements
while
ms  =   {1,2,3, 1,3} is a multiset with integer elements
following are some member functions of class multiset (which defines multiset with integer elements)

Class name      :   Set

Data members /instance variables:-
Int arr[]       integers array of size n
Int n           size

Members functions/methods:-

Set()                               Constructor to assign 0 to n.
Set(int nn)                         Constructor to assign n=nn
Void readlist()                     to input integers
int isset()                         which is 1 (one) if the multiset object is a set and 0 (zero) otherwise
Set intersection (Set s1, Set s2)   returns intersection elements of s1, s2
Void displaylist()                  to display the intersection elements if both are sets, else 
                                    display “multiset”

Also write main().
 */
import java.io.*;
class Q16							
{
    public static void main(String args[])throws IOException
    {
        Set A = new Set();
        A.displaylist();	
    }
}
class Set
{
    int arr[];
    int n;
    Set()
    {
        n = 0;
    }
    Set(int nn)
    {
        n = nn;
    }
    void readlist()throws IOException
    {
        arr = new int[n];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        for(i = 1; i <= n; i++)
        {
            System.out.println("Enter element " + (i));
            arr[i - 1] = Integer.parseInt(in.readLine());
        }
    }
    int isset()
    {
        int i = 0;
        int j = 0;
        int flag = 0;                   
        for(i = 0; i < n; i++)
        {
            for(j = (i + 1); j < n; j ++)
            {
                if(arr[i] == arr[j])        
                {
                    flag = 1;
                }
            }
        }
        if(flag == 1)
        return 0;
        else
        return 1;
    }
    Set intersection(Set s1, Set s2)
    {
        int i = 0;
        int a[] = new int[s1.n];
        int j = 0;
        int c = 0;
        for(i = 0; i < s1.n; i++)
        {
            for(j = 0; j < s2.n; j++)
            {
                if(s1.arr[i] == s2.arr[j])
                {
                    a[c] = s1.arr[i];
                    c++;
                    break;
                }
            }
        }
        Set s3 = new Set();
        s3.n = c;
        s3.arr = new int[s3.n];
        for(i = 0; i < s3.n; i++)
        {
            s3.arr[i] = a[i];
        }
        return s3;
    }
    void displaylist()throws IOException
    {
        Set s1 = new Set(); 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of elements in first set or multiset");
        s1.n = Integer.parseInt(in.readLine());
        s1.readlist();
        Set s2 = new Set();
        System.out.println("Enter the number of elements in second set or multiset");
        s2.n = Integer.parseInt(in.readLine());
        s2.readlist();
        int d = 0;
        int e = 0;
        d = s1.isset();
        e = s2.isset();
        if((d == 1) && (e == 1))
        {
            Set s3 = new Set();
            s3 = intersection(s1, s2);
            System.out.println("The intersection elements are");
            int i = 0;
            if(s3.n == 0)
            System.out.println("No intersection element");
            for(i = 0; i < s3.n; i++)
            {
                System.out.println(s3.arr[i]);
            }
        }
        else
        System.out.println("Multiset");
    }
}