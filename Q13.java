/**
Define a class “cqueuop” to illustrate operations in a circular queue. The class specification are 
given-

Class name:     cqueueop

Data member
int q[]     ->  to store id of job in queue
capacity    ->  maximum storage capacity of q[] is 20.
int front   ->  to point to the index of front of queue
int rear    ->  to point to the index of rear of queue

Member function
cqueueop()              -> constructor to initialize f to -1, r to -1 and 20 to capacity
void insertqueue(int)   -> function to insert job item in queue if possible else display message 
                           “queue overflow”
void deletequeue()      -> function to delete job id from queue if possible or display “queue underflow”

Specify the class cqueueop giving details of all its member functions.
 */
import java.io.*;
class Q13
{
    static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        cqueueop A=new cqueueop();
        int ch=0;
        int n=0;
        do
        {
            System.out.println("Menu \n1.Insert Job ID\n2.Delete Job ID\n3.Exit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(obj.readLine());
            switch(ch)
            {
                case 1:
                System.out.println("Enter Job ID");
                n=Integer.parseInt(obj.readLine());
                A.insertqueue(n);
                break;
                case 2:
                A.deletequeue();
                break;
                case 3:
                System.out.println("You are now exiting");
                System.exit(0);
                break;
                default:
                System.out.println("Invalid choice! Enter again");
                break;
            }
        }while(true);
    }
}
class cqueueop
{
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int q[];
    int capacity;
    int front;
    int rear;
    cqueueop()
    {
        front=-1;
        rear=-1;
        capacity=20;
        q=new int[capacity];
    }
    void insertqueue(int val)
    {
        if((front==0 && rear==(capacity-1)) || ((rear+1)==front))
        {
            System.out.println("queue overflow");
            return;
        }
        else if(front==-1 && rear==-1)
        {
            front++;
            rear++;
        }
        else if(rear==(capacity-1))
        {
            rear=0;
        }
        else
        {
            rear++;
        }
        q[rear]=val;
    }
    void deletequeue()
    {
        if(front==-1 && rear==-1)
        {
            System.out.println("queue underflow");
        }
        else if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else if(front==(capacity-1))
        {
            front=0;
        }
        else
        {
            front++;
        }
    }
}