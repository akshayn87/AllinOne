/**
 * 
 */
package fileoperations;

import java.io.File;
import java.io.IOException;

/**
 * This Class is used to Handle the File Operations
 */
public class MyClass {

	/**
	 * @param args
	 * This is the Main Method to Execute FileOperations
	 */
	public static void main(String[] args) {
		File file = new File("MyFile.txt");
		 if (file.exists()) {
	            System.out.println("Name of the File :-" + file.getName());
	        } else {
	            try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            System.out.println("New File created  :-" + file.getName());
	        }

	}

}
