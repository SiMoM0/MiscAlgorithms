//TRANSLATOR from text to binary code
//Input format, example: ciaodwanves
//txt file with ASCII inforamtions to import: binary_text.txt

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryTranslator2
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		Dictionary2 table = new Dictionary2();
		table.fillDictionary();

		System.out.println("******Binary Translator(from text to binary code)******");
		String sTesto = keyboard.nextLine();
		String[] arrTesto = sTesto.split("");

		System.out.print("Binary Code:");
		for(int i=0; i<arrTesto.length; i++)
			System.out.print(" "+table.searchBin(arrTesto[i]));
		System.out.println("");
	}
}

//DICTIONARY with Pairs(character, binary code)
class Dictionary2
{
	Pair[] pair = new Pair[27];			//array with pairs
	int index = 0;					//index

	//Method that returns the binary code, based on the characters in input
	public String searchBin(String s)
	{
		String retValue = "";
		for(int i=0; i<pair.length; i++)		//Linear search
		{
			if(pair[i].getText().equals(s))
				retValue = pair[i].getBin(); 	//return binary code
		}
		return retValue;
	}

	//Insertion method for Pairs
	private void insertPairs(Pair p)
	{
		pair[index] = p;
		index++;
	}

	//Fill dictionary from the txt file
	public void fillDictionary() throws FileNotFoundException
	{
		insertPairs(new Pair(" ", "00100000"));	
		
		FileReader fr = new FileReader("binary_text.txt");	//reading txt file
		BufferedReader bf = new BufferedReader(fr);
		String st = "";
		
		try
		{
			while((st = bf.readLine())!= null)
			{
				Scanner tk = new Scanner(st);			//Scanner token
				String ascii = tk.next();				//character
				String zerouno = tk.next();				//binary code
				insertPairs(new Pair(ascii, zerouno));	//insertion in dictionary
			}
		} catch(IOException ioe) {}
	}

	//Pair CLASS
	private class Pair
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
