package Library.System.BookQueries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookQueriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookQueriesApplication.class, args);
	}

}
