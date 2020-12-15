//TRANSLATOR FROM BINARY CODE TO TEXT
//Input format, example: 10101010 01001011 01011100 01101000
//txt file with ASCII information to import: binary_text.txt

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryTranslator
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		Dictionary table = new Dictionary();
		table.fillDictionary();

		System.out.println("******Binary Translator******");
		String sCode = keyboard.nextLine();
		String[] code = sCode.split("\\s+");

		System.out.print("Text: ");
		for(int i=0; i<code.length; i++)
			System.out.print(table.searchText(code[i]));
		System.out.println("");
	}
}

//DICTIONARY with Pairs (character ascii, binary code)
class Dictionary
{
	Pair[] pair = new Pair[27];		//array with pairs
	int index = 0;					//index

	//Returns character from binary code
	public String searchText(String s)
	{
		String retValue = "";
		for(int i=0; i<pair.length; i++)		//Linear search
		{
			if(pair[i].getBin().equals(s))
				retValue = pair[i].getText(); 	//Find the character
		}
		return retValue;
	}

	//Insert Paris method
	private void insertPairs(Pair p)
	{
		pair[index] = p;
		index++;
	}

	//Fill dictionary method with pairs
	public void fillDictionary() throws FileNotFoundException
	{
		insertPairs(new Pair(" ", "00100000"));	//inserimento manuale dello spazio
		
		FileReader fr = new FileReader("binary_text.txt");	//read txt file
		BufferedReader bf = new BufferedReader(fr);
		String st = "";
		
		try
		{
			while((st = bf.readLine())!= null)
			{
				Scanner tk = new Scanner(st);			//Scanner token
				String ascii = tk.next();				//character
				String zerouno = tk.next();				//binary code
				insertPairs(new Pair(ascii, zerouno));		//insertion in the dictionary
			}
		} catch(IOException ioe) {}
	}

	//Pair class
	class Pair
	{
		String text;		//character
		String bin;		//binary code

		private Pair(String sText, String sBin)
		{
			text = sText;
			bin = sBin;
		}
	
		private String getText() { return text;}
		private String getBin() { return bin;}
	}
}
