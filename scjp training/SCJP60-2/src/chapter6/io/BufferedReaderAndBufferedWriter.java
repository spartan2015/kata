package chapter6.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderAndBufferedWriter {
	
	public static void main(String[] args) {
		File file = new File("c:\\test.test");
		
		/**
		 * BuffredReader constructors:
		 * 1. Reader
		 * 
		 * BufferedReader methods
		 * 1. read
		 * 2. readLine
		 * 
		 * BufferedWriterConstructor 
		 * 2. Writer
		 * 
		 * BufferedWriter methods:
		 * 1. write
		 * 2. newLine() - writes a file system specific line separator
		 */
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try{
			fw = new FileWriter(file);
		}catch(IOException io){io.printStackTrace();}
		
		bw = new BufferedWriter(fw); // CLEAN
		
		try{
			bw.write("howdy");
		}catch(IOException ioe){ioe.printStackTrace();}
		
		try{
			bw.newLine();
		}catch(IOException ioe){ioe.printStackTrace();}
		
		try{
			bw.write("folks");
		}catch(IOException ioe){ioe.printStackTrace();}
		
		try{
			bw.flush();
			bw.close();
		}catch(IOException ioe){ioe.printStackTrace();}
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader(file);
		}catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
		
		br = new BufferedReader(fr); // CLEAN
		
		String s = null;
		try{
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
		}catch(IOException ioe){ioe.printStackTrace();}
	}
}
