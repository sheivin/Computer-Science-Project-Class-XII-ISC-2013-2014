/**
Define a class Trr with the following data member-
int arr[3][3]

and the following functions-
void input()        to input a 3X3 matrix
Trr transpose()     to return transpose of matrix arr[][]
Trr product(Trr M)  to return the product of current and the transposed matrix M
void display()      to display the matrix, its transpose and their product in the following format-

1  1  1         1  2  9         11  21   21
2  4  7     X   3  4  2     =   21  69   68
9  2  6         1  7  6         21  68  121

Also write main( ) for above class.
 */
import java.io.*;
class Q4
{
    public static void main(String args[])throws IOException
    {
        Trr A=new Trr();
        A.input();
        A.display();
    }
}
class Trr
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int arr[][]=new int[3][3];
    void input()throws IOException
    {
        System.out.println("Enter 3X3 Matrix");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                arr[i][j]=Integer.parseInt(obj.readLine());
            }
        }
    }
    Trr transpose()
    {
        Trr M=new Trr();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                M.arr[i][j]=this.arr[j][i];
            }
        }
        return M;
    }
    Trr product(Trr M)
    {
        Trr X=new Trr();
        int s=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                s=0;
                for(int k=0;k<3;k++)
                {
                    s=s+(this.arr[i][k]*M.arr[k][j]);
                }
                X.arr[i][j]=s;
            }
        }
        return X;
    }
    void display()
    {
        Trr A=new Trr();
        Trr B=new Trr();
        A=transpose();
        B=product(A);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(this.arr[i][j]+"\t");
            }
            if(i==1)
            {
                System.out.print("X\t");
            }
            else
            {
                System.out.print(" \t");
            }
            for(int j=0;j<3;j++)
            {
                System.out.print(A.arr[i][j]+"\t");
            }
            if(i==1)
            {
                System.out.print("=\t");
            }
            else
            {
                System.out.print(" \t");
            }
            for(int j=0;j<3;j++)
            {
                System.out.print(B.arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
