package p4;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter{
	private String filePath;
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	public void output(String msg) throws IOException{
		FileWriter out = new FileWriter(filePath);
		out.write(msg);
		out.close();
	}
	public static void main(String[] args) throws IOException{
		FileOutputter fout = new FileOutputter();
		fout.output("Hello spring!!\n");
	}
	
}
