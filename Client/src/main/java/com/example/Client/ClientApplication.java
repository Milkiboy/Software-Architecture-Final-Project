package com.example.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Autowired
	private RestOperations restTemplate;
	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/customers";

		//add customer1
		Contact contact1 = new Contact("hhhh@gamil.com", 074323);
		Address address1 = new Address("maitemany", "Asmara", "00000");
		restTemplate.postForLocation(serverUrl, new CustomerDTO(001, "Samuel", contact1, address1));

		//add customer2
		Contact contact2 = new Contact("kkkk@gamil.com", 01234);
		Address address2 = new Address("Tiravolo", "Asmara", "00000");
		restTemplate.postForLocation(serverUrl, new CustomerDTO(002, "Fish", contact2, address2));

		//get customer
		CustomerDTO customerDTO = restTemplate.getForObject(serverUrl+"{isbn}",
				CustomerDTO.class,"1");
		System.out.println("*************get customer**********");
		System.out.println(customerDTO);

		String serverUrl1 = "http://localhost:8080/books";
		//add book 1
		restTemplate.postForLocation(serverUrl1, new BookDTO("123","Harry poter","Fiction","Samuel"));

		//add book 2
		restTemplate.postForLocation(serverUrl1,  new BookDTO("234","Picolo","Fiction","Sidney"));

		String serverUrl2 = "http://localhost:8080/reviews";
		//add reviews
		Book book = new Book("123","Harry poter","Fiction","Samuel");
		Book book2 = new Book("234","Picolo","Fiction","Sidney");
		Customer customer1 = new Customer(001, "Samuel");
		Customer customer2 = new Customer(002, "Fish");

		ReviewDto reviewDto1 = new ReviewDto(1,5,"Good",customer1,book);
		ReviewDto reviewDto2 = new ReviewDto(1,4,"Excellent",customer2,book);
		ReviewDto reviewDto3 = new ReviewDto(1,5,"Good",customer1,book2);
		ReviewDto reviewDto4 = new ReviewDto(1,4,"Excellent",customer2,book2);
		List<ReviewDto> reviewDtos = new ArrayList<>();
		reviewDtos.add(reviewDto1);
		reviewDtos.add(reviewDto2);
		reviewDtos.add(reviewDto3);
		reviewDtos.add(reviewDto4);
		restTemplate.postForLocation(serverUrl2, reviewDtos);

		//get from BookQuery
		String serverUrl3 = "http://localhost:8080/bookQuery";
		BookDTO bookDTO = restTemplate.getForObject(serverUrl3+"{isbn}",BookDTO.class,"1");
		System.out.println("*************get books**********");
		System.out.println(bookDTO);

		//add borrowing
		String serverUrl4 = "http://localhost:8080/borrowing";
		restTemplate.postForLocation(serverUrl4, new BorrowingDTO(0001, LocalDate.now(),customer1,book));


        //get changed book
		book.setTitle("Sakai");
		String serverUrl5 = "http://localhost:8080/bookQuery";
		BookDTO bookDTO1 = restTemplate.getForObject(serverUrl5+"{isbn}",BookDTO.class,"1");
		System.out.println("*************get books**********");
		System.out.println(bookDTO1);

		//get borrowing
		String serverUrl6 = "http://localhost:8080/borrowing";
		BorrowingDTO borrowingDTO = restTemplate.getForObject(serverUrl6+"{borrowingNumber}",BorrowingDTO.class,"1");
		System.out.println("*************get borrowings**********");
		System.out.println(borrowingDTO);




	}
	@Bean
	RestOperations restTemplate(){
		return new RestTemplate();
	}



}
