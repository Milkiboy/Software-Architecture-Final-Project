package Library.System.Borrowings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BorrowingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingsApplication.class, args);
	}

}
