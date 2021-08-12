package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//Creating File Object
		File fl = new File(folderpath);
		
		//Getting All the Files into FileArray
		File[] listOfiles = fl.listFiles();
		
		//Declared a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		//Getting file names from array of files
		for(File f:listOfiles)
			fileNames.add(f.getName());
		
		//Return the List of file names
		 return fileNames;
	}

	/**
	 * This method will create or append content into the file specified
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createFiles(String folderpath, String fileName, List<String> content) 
	{
		try 
		{
			//Creating file and file writer object
			File fl = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(fl);
			
			//Writing to file
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * This method will delete the file name if it exists.
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String folderpath, String fileName)
	{
		//Adding folder path with file name and creating file object
		File file = new File(folderpath+"\\"+fileName);
		
		try 
		{
			//Deleting file
			if(file.delete())
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	/**
	 * This method will search the file from a folder 
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		//Adding folder path with file name and creating file object
		File file = new File(folderpath+"\\"+fileName);
		
		//Search condition
		if(file.exists())
			return true;
		else
			return false;
	}
}
