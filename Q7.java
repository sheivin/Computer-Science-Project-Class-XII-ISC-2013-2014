/**
A class Numbers contains the following data members and member functions to fill the cell of N X N matrix
with the triangular numbers. [ A triangular number is formed by the addition of a consecutive sequence of
integers starting from ‘Num’].
e.g.    if Num=1 then
        1 + 2 = 3
        1 + 2 + 3 = 6
        1 + 2 + 3 + 4 = 10
        1 + 2 + 3 + 4 + 5 = 15
Therefore, 3, 6, 10, 15 etc. are triangular numbers.

Class name      :   Numbers
Data members/ instance variables:
N       :   integer to store order of matrix.
Num     :   integer to store starting value of triangular numbers.
Prev    :   integer to store last value which gave triangular number.
Arr[][] :   array to store triangular numbers in array
Member functions/methods:
Numbers(int a, int b):  constructor to assign a to N and create matrix of order N X N. Also assign Num=b
Numbers check(int n) :  to check if ‘n’ is triangular and initialize ‘n’ to Num if triangular or initialize
                        Num by next triangular greater than ‘n’ and initialize Prev with last value which 
                        gave triangular number.
void fill( )         :   to fill the boundary cells of Arr[][]by triangular number
                         beginning from ‘Num’.
void display()       :   to display the matrix Arr[].

Specify the class Numbers giving details of the functions int check(int) and void display( ).

 */
import java.io.*;
class Q7
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException
    {
        System.out.println("Input Order of Matrix:");
        int a=Integer.parseInt(obj.readLine());
        System.out.println("Input Starting Number:");
        int b=Integer.parseInt(obj.readLine());
        Numbers A=new Numbers(a, b);
        A=A.check(b);
        A.fill();
        A.display();
    }
}
class Numbers
{
	int N;
	int Num;
	int Prev;
	int Arr[][];
	int r;
	Numbers(int a, int b)
	{
	    N=a;
	    Arr = new int[N][N];
	    Num = b;
	}
    Numbers check(int n)
	{
		int r = (int)Math.sqrt(2*n);
		this.Num= (r+1)*(r)/2;
		this.Prev = r*(r-1)/2;
		this.r= r;
		return this;
	}
	void fill()	
	{
		int m = r;
		int i,j;
		for(j=0; j<N; j++)
		{
		    Arr[0][j] = (m+1)*(m++)/2;
		}
		j--;
		for(i=0; i<N; i++)
		{
		    Arr[i][j] = (m+1)*(m++)/2;
		}
		i--;
		for(; j>=0; j--)
		{
		    Arr[i][j] = (m+1)*(m++)/2;
		}
		j++;
		for(; i>0; i--)
		{
		    Arr[i][j] = (m+1)*(m++)/2;
		}
		j++;
    }
   	void display()
	{
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(Arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
