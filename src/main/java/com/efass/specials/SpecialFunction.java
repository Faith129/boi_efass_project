package com.efass.specials;

import java.io.File;
import java.util.Random;

import com.efass.payload.folderData;

public class SpecialFunction {

	private final String UPLOAD_DIR = "./datafiles/export/";
	

	public String createFolderDirectory(String fName,String rand) {
		// Check if folder exists/create a folder path with report_id
		String filename = null;
		//String rand = generateRandomString();
		String filePath = UPLOAD_DIR +fName;
		File file = new File(filePath);
		if (!file.exists()) {
			if (file.mkdir()) {

				try {
					folderData fd = new folderData(); 
					fd.setFilepath(filename);
						filename = filePath ;

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				filename= null;
			}

		}
		return filename;

	}
	
	
	
	
	public String checkCreateFolder(String filePath) {
		
		String path = filePath+"/output";
		File file = new File(path);
		if (!file.exists()) {
			if (file.mkdir()) {

				return path;
			} else {
				return null;
			}
		
	}else {
		return path;	
	}

		
	}
	
	
	public String generateRandomString() {
		
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 5;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    
	    return randomString;


	  }
	
}
