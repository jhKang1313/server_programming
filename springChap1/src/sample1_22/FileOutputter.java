package sample1_22;

import java.io.*;

public class FileOutputter {

	private String filePath = "output.txt" ;
	public void output(String msg) throws IOException {
		FileWriter out = new FileWriter(filePath) ;
		out.write(msg);
		out.close();
	}
	
	public static void main (String[] args) throws IOException {
		FileOutputter fout = new FileOutputter() ;
		fout.output("Hello Spring!! \n");
	}
}
