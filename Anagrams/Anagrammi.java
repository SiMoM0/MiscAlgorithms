import java.util.Scanner;

public class Anagrammi
{
	public static void main(String args[])
	{
		Scanner tastiera = new Scanner(System.in);
		System.out.print("Insert word: ");
		String s = tastiera.nextLine();
		anagrams(s);
	}

	public static void anagrams(String s)
	{
		anagrams("", s);
	}

	public static void anagrams(String pre, String s)
	{
		int n = s.length();
		if(n==0)
			System.out.println(pre);
		else
		{
			for(int i=0; i<n; i++)
				anagrams(pre + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
		}
	}
}