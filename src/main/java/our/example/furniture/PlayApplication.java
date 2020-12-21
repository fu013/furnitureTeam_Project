package our.example.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class PlayApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(PlayApplication.class, args);
	}
}
