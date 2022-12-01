package Library.System.Reviews.kafka;




import Library.System.Reviews.service.dtos.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private KafkaTemplate<String, ReviewDto> kafkaTemplate;

    public void send(String topic, ReviewDto reviewDto) {

        kafkaTemplate.send(topic,reviewDto);
    }
}
