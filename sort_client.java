import java.io.*;
import java.net.*;
import java.util.Scanner;
public class sort_client {

            public static void main(String[] args) throws Exception
            {
                                    Socket s=new Socket("127.0.0.1",7777);
                                    if(s.isConnected())
                                    {
                                                System.out.println("Connected to server");
                                    }
                                    System.out.println("Enter size of array:");
                                    Scanner scanner=new Scanner(System.in);
                                    int n=scanner.nextInt();
                                    int a[]=new int[n];
                                    System.out.println("Enter elements of array:");
                                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                                    dout.writeInt(n);
                                    for(int i=0;i<n;i++)
                                    {
                                                int r=scanner.nextInt();;
                                                dout.writeInt(r);
                                    }
                                    System.out.println("Data Sent");
                                    DataInputStream din=new DataInputStream(s.getInputStream());
                                    int r;
                                    System.out.println("Receiving Sorted Data...");
									System.out.println("Sorted Array:");
                                    for(int i=0;i<n;i++)
                                    {
                                                r=din.readInt();
                                                System.out.print(r+" ");
                                    }
                                    s.close();
            }
}