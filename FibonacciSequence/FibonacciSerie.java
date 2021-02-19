import java.util.Scanner;

public class FibonacciSerie
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.print("Insert number: ");
		int n = tastiera.nextInt();

		int a = 1;
		int b = 1;
		int i = 0;

		if(n==0)
			System.out.print('0');
		else if(n==1)
			System.out.print(a);
		else
			System.out.print(a+" "+b+" ");

		while(i<n-2)
		{
			int c = a+b;
			a = b;
			b = c;
			System.out.print(c+" ");
			i++;
		}
		System.out.println();
	}
}
