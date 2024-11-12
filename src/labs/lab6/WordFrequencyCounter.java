package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Counts the frequencies of words in a file and generates a frequency graph
 */
public class WordFrequencyCounter {
	
	private class WordPair implements Comparable
	{
		private String word;
		private int count;
		
		public WordPair(String word)
		{
			this.word = word;
			this.count = 1;
		}
		
		public String getWord() {return word;}
		public int getCount() {return count;}
		public void add() { count++; }
		
		public int compareTo(Object otherObject)
		{
			WordPair other = (WordPair) otherObject;
			
			// sort first by count
			if (count > other.count)
				return -1;
			else if (count < other.count)
				return 1;
			
			// if counts are the same sort lexicographically
			return word.compareTo(other.word);
		}
	}
	
	private ArrayList<WordPair> wordList;

	/**
	 * Constructor
	 * 
	 * @param fileName name of file from which to count word frequencies
	 */
	public WordFrequencyCounter(String fileName) {	
		wordList = new ArrayList<WordPair>();
		try 
		{
			Scanner in = new Scanner(new File(fileName));
			
			while (in.hasNext())
			{
				String currWord = in.next();
				
				currWord = removePunc(currWord).toLowerCase();
				
//				temp += currWord + "\n";
				
				int index = findIndex(currWord);
				
				// update wordList with current word
				if (index >= 0)
				{
					wordList.get(index).add();
				}
				else 
				{
					wordList.add(new WordPair(currWord));
				}
				
			}
			
			in.close();
//			}
//			catch (FileNotFoundException e)
//			{
//				System.out.print("File: " + file + " not found");
//				return "";
//			}
			
			// sort wordList
			Collections.sort(wordList);
		}
		catch (FileNotFoundException e)
		{
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Returns a word frequency graph based on the input file. Words are sorted
	 * based on frequency (more frequent words appear first) and then by name
	 * (lexicographically). 
	 * 
	 * Convert all words into lower case for the analysis and graph generation.
	 * 
	 * @return a word frequency graph based on the input file
	 */
	public String getFrequencyGraph() {
		String returnMe = "";
//		String temp = "";
		// test file opening
//		try 
//		{
//			Scanner in = new Scanner(new File(file));
			
			
		
		for (int i = 0; i < wordList.size(); ++i)
		{
			returnMe += wordList.get(i).getWord() + ": ";
			for (int j = 1; j <= wordList.get(i).getCount(); ++j) 
			{
				returnMe += "*";
			}
			returnMe += "\n";
		}
		
		return returnMe;
		
//		return temp;
	}
	
	// return the parameter string but only its alphabetic characters 
	private String removePunc(String str)
	{
		String returnMe = "";
		for (int i = 0; i < str.length(); ++i)
		{
			if(Character.isAlphabetic(str.charAt(i)))
				returnMe += str.charAt(i);
		}
		return returnMe;
	}
	
	// return the index of the WordPair with the given word, or -1 if not found
	private int findIndex(String word)
	{
		for (int i = 0; i < wordList.size(); ++i) 
		{
			if (wordList.get(i).getWord().equals(word))
				return i;
		}
		return -1;
	}
}