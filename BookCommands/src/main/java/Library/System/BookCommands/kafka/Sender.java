package Library.System.BookCommands.kafka;




import Library.System.BookCommands.service.dtos.BookDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, BookDto> kafkaTemplate;

    public void send(String topic,BookDto bookDto) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String bookDtoToString;
//        try {
//            bookDtoToString = objectMapper.writeValueAsString(bookDto);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        kafkaTemplate.send("book_topic", bookDtoToString);
//    }


            kafkaTemplate.send(topic,bookDto);
        }
}
