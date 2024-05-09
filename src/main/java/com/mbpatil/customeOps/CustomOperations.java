package com.mbpatil.customeOps;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class CustomOperations {

	public static String createNewDirectoryPath(String rootDirectory)
	{
		
		return rootDirectory+ RandomStringUtils.randomAlphabetic(10)+"/";
		
	}

	
	public static String getDirPath(String rootDirectory,String splitString)
	{
		/*Get Directory path from split string */
		return rootDirectory.split(splitString)[1];
		
	}
	
	public static java.sql.Date sqldate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(dateString);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return null; // Or throw an exception if you prefer
        }
    }
	
	
	public static String getNewFilePath(String baseDirectoryPath, String FileName) {
		// TODO Auto-generated method stub
		
		File NewDirectory=new File(baseDirectoryPath);
		if(!NewDirectory.exists())
		   if(NewDirectory.mkdirs())
		   return baseDirectoryPath+FileName;
		   else
			   return null;
		return null;
	}
	
	
	
	public static void saveFile(MultipartFile mfile,String filePath) {
		try {
			mfile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("unable to create directory with given path : "+filePath);
		}
	}
}
