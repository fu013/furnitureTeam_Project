package our.example.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import our.example.furniture.model.Name;
import our.example.furniture.repository.NameMapper;


import java.util.List;

@SpringBootApplication
public class PlayApplication {

	@Autowired
	private NameMapper nameMapper;

	public static void main(String[] args) {
		var context = SpringApplication.run(PlayApplication.class, args);
		var nameMapper = context.getBean(NameMapper.class);

		List<Name> names = nameMapper.selectAllName();

		for(var e : nameMapper.selectAllName())
			System.out.println(e.toString());
	}
}
