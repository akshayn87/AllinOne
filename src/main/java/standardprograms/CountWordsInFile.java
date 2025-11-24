package standardprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsInFile {
	
	public static void main(String[] args) throws IOException {
		String Path =System.getProperty("user.dir")+"//src//main//java//standardprograms//List.txt";
		CountCharactersInFile(Path);
	}
	
	public static int  CountCharactersInFile(String Path) throws IOException {
	    File f= new File(Path);     
		BufferedReader reader = new BufferedReader(new FileReader(f));
		int lineCount=0;
		int wordCount=0;
		int charCount=0;
		//Reading the first line into currentLine
        String currentLine = reader.readLine();
      
        while (currentLine != null)
        {
            //Updating the lineCount
             
            lineCount++;
             
            //Getting number of words in currentLine
             
            String[] words = currentLine.split(" ");
             
            //Updating the wordCount
             
            wordCount = wordCount + words.length;
             
            //Iterating each word
             
            for (String word : words)
            {
                //Updating the charCount
                 
                charCount = charCount + word.length();
            }
             
            //Reading next line into currentLine
             
            currentLine = reader.readLine();
        }
         reader.close();
        //Printing charCount, wordCount and lineCount
         
        System.out.println("Number Of Chars In A File : "+charCount);
         
        System.out.println("Number Of Words In A File : "+wordCount);
         
        System.out.println("Number Of Lines In A File : "+lineCount); 
        return charCount;
		  //reader.close();
		  
	
}
}