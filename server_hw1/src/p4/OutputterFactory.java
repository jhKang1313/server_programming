package p4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OutputterFactory{
	@Bean 
	public FileOutputter fileOutputter(){
		FileOutputter fileOutputter = new FileOutputter();
		fileOutputter.setFilePath("out.txt");
		return fileOutputter;
	}
}