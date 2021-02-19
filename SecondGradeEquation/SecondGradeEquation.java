//Second grade equation solver
import java.util.Scanner;

public class SecondGradeEquation
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);

		System.out.println("Insert a, b, c: ");
		// ax^2 + bx + c = 0
		int a = tastiera.nextInt();
		int b = tastiera.nextInt();
		int c = tastiera.nextInt();

		int delta = b*b -4*a*c;	//calculate delta
		double x1 = (-b + Math.sqrt(delta))/(2*a);	//first solution
		double x2 = (-b - Math.sqrt(delta))/(2*a);	//second solution

		System.out.println("Solutions: "+x1+" , "+x2);	//output
	}
}