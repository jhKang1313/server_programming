package p4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OutputterFactory{
	@Bean 
	public FileOutputter fileOutputter(){				//FileOutputter 객체 생성 메서드
		FileOutputter fileOutputter = new FileOutputter();	//MessageFactory에서 Autowired를 통해 참조.
		fileOutputter.setFilePath("out.txt");
		return fileOutputter;							//객체 반환
	}
}