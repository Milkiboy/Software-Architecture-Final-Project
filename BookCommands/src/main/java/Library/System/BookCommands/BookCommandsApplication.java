package Library.System.BookCommands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookCommandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCommandsApplication.class, args);
	}

}
