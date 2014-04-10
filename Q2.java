/**
Write a program to create square matrix of order N whose maximum size = 11. You are then required to fill
the matrix by the value ranging from 1 to N2; and then display the matrix on the screen.

For example-
If N=5, then the matrix would be as shown below
1    2   3   4   5
6    7   8   9   10
11   12  13  14  15
16   17  18  19  20
21   22  23  24  25

Now let the user input the value ‘V’ in range [1 - N2] and the order ‘M’ of the sub matrix ‘S’ that is to
be created using the values starting from the feeded value ‘V’ to right side.

For example
If user enters V = 18 and M = 2, then the sub matrix formed
S = 18   19
    23   24
If user enters V = 14 and order of sub matrix M = 3, then the sub matrix formed
S = 14   15  11
    19   20  16
    24   25  21
    
If user enters V = 4 and order of sub matrix M = 4, then the sub matrix formed
S =  4   5   1   2
     9   10  6   7
     14  15  11  12
     19  20  16  17
*/

import java.io.*;
class Q2
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        System.out.println("Enter order of matrix");
        int N=Integer.parseInt(obj.readLine());
        if(N>11)
        {
            System.out.println("Order greater than permissible limit");
            System.exit(0);
        }
        int a[][]=new int[N][N];
        int i=0;
        int j=0;
        int c=1;
        System.out.println("Enter starting value of sub matrix");
        int V=Integer.parseInt(obj.readLine());
        if(V<1 || V>(N*N))
        {
            System.out.println("Value not in permissible limit");
            System.exit(0);
        }
        System.out.println("Enter order of sub matrix");
        int M=Integer.parseInt(obj.readLine());
        if(M<1 || M>N)
        {
            System.out.println("Value not in permissible limit");
            System.exit(0);
        }
        int b[][]=new int[M][M];
        int x=0;
        int y=0;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
            {
                a[i][j]=c;
                if(c==V)
                {
                    x=i;
                    y=j;
                }
                c++;
            }
        }
        int q=0;
        for(i=0;i<M;i++)
        {
            q=y;
            for(j=0;j<M;j++)
            {
                b[i][j]=a[x][q];
                q++;
                if(q==N)
                {
                    q=0;
                }
            }
            x++;
            if(x==N)
            {
                x=0;
            }
        }
        for(i=0;i<M;i++)
        {
            for(j=0;j<M;j++)
            {
                System.out.print(b[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
