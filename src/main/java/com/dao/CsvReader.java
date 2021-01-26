package com.dao;
import java.io.FileReader; 
import com.opencsv.*; 

public class CsvReader { 
	private static final String CSV_FILE_PATH = "E:\\state_level.csv";
	private static CSVReader csvReader; 
	//public static void main(String[] args) 
	{ 

		System.out.println("Read Data Line by Line With Header \n"); 
		readDataLineByLine(CSV_FILE_PATH); 
	} 

	public static void readDataLineByLine(String file) 
	{ 

		try { 
			FileReader filereader = new FileReader(file); 
			csvReader =new CSVReaderBuilder(filereader).withSkipLines(0).build(); 
			String[] cases; 

			// we are going to read data line by line 
			while ((cases = csvReader.readNext()) != null) { 
					System.out.println("State_cases [State=" + cases[0] + ", Confirmed=" + cases[1] + ", Recovered=" + cases[2] +", Death=" + cases[3] + ", Active=" + cases[4]+"]"); 
			} 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
	} 

 

	