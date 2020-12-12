package our.example.furniture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import our.example.furniture.repository.NameMapper;

@SpringBootApplication
public class PlayApplication {
	public static void main(String[] args) {
		var context = SpringApplication.run(PlayApplication.class, args);
		var nameMapper = context.getBean(NameMapper.class);

		for(var e : nameMapper.selectAllName())
			System.out.println(e.toString());
	}
}
