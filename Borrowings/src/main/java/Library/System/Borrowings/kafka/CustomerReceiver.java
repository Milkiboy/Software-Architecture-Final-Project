package Library.System.Borrowings.kafka;

import Library.System.Borrowings.domain.Book;
import Library.System.Borrowings.domain.Borrowings;
import Library.System.Borrowings.domain.Customer;
import Library.System.Borrowings.repo.BorrowingRepo;
import Library.System.Borrowings.service.BorrowingsService;
import Library.System.Borrowings.service.dtos.BookDto;
import Library.System.Borrowings.service.dtos.CustomerDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerReceiver {


    @Autowired
    private BorrowingRepo borrowingRepo;

    @Autowired
    private BorrowingsService borrowingsService;

    @KafkaListener(id = "borrowingListener", topics = {"customer_topic"})
    public void receive(@Payload CustomerDto customerDTO) {
        System.out.println("Recieved .. " + customerDTO);
        Customer c = new Customer(customerDTO.getCustomerNumber(), customerDTO.getName());
        List<Borrowings> o = borrowingRepo.findCustomerByCustomerNumber(customerDTO.getCustomerNumber());
        for (Borrowings borrowings : o) {
            borrowings.getCustomer().setCustomerName(c.getCustomerName());
            borrowingRepo.save(borrowings);
        }
    }

//@KafkaListener(id= "borrowingListener",topics = {"customer_topic"})
//    public void receive(@Payload String customerAsString) {
//        ObjectMapper objectMapper=new ObjectMapper();
//
//        CustomerDto customerDto=null;
//        try {
//            customerDto=objectMapper.readValue(customerAsString, CustomerDto.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        borrowingRepo.update(customerDto);
//
//    }

}

