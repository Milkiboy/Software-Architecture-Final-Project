package Library.System.Customers.kafka;



import Library.System.Customers.service.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, CustomerDto> kafkaTemplate;

    public void send(String topic, CustomerDto customerDto) {

        kafkaTemplate.send(topic,customerDto);
    }
//@Autowired
//private KafkaTemplate<String, String> kafkaTemplate;
//
//    public void send(CustomerDto customerDto) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String customerDtoToString;
//        try {
//            customerDtoToString = objectMapper.writeValueAsString(customerDto);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        kafkaTemplate.send("customer_topic", customerDtoToString);
//    }
}
