/*
 * File: Catch_Exception.java
 * Created by Tianming Wei
 * Example code created for Lab07, CSC115 201901
 */

import java.io.*;

public class Catch_Exception {
	File file;
	int divideNum;
	int parseNum;
	public Catch_Exception() {
		file = null; 
		divideNum = 0;
		parseNum = 0;
	}
	public void readMyFile() throws MyException {  

	try{
		file = new File("inputfile.txt");
		FileReader fr = new FileReader(file);
		
		char [] a = new char[50];
		fr.read(a);
		System.out.println(a);
		//fr.close();
		fr.read(a);

	} catch (IOException e) {
		System.out.println(e);
	
		throw new MyException("This is our new exception!");
	    }
	}
	public void calculateDivideNumber(int dividend, int divisor) throws MyException {

	try{
		divideNum = dividend / divisor;
	}
	catch (ArithmeticException e) {
		System.out.println(e);

		throw new MyException("ArithmeticException was caught!");
	
		}
	}
	public void calculateParseNumber(String str) throws MyException {
	
	try{
		parseNum = Integer.parseInt(str);
	}
	catch (NumberFormatException e) {
		System.out.println(e);

		throw new MyException("NumberFormatException was caught!");
	
		}

	}
	public static void main(String args[]) throws MyException {
		Catch_Exception test = new Catch_Exception();
		
		/* 
		 * CREATE A FILE NAMED inputfile.txt 
		 * IN THE CURRENT FOLDER TO SEE 
		 * DIFFERENT RESULT 
		 */
	
		test.readMyFile();
	}
}
