package com.jpop.kafka.producer.helloproducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.retrytopic.DestinationTopic;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC_NAME = "topic1";

    @PostMapping("/publish/{msg}")
    public String publishMsg(@PathVariable("msg") String msg){
        kafkaTemplate.send(TOPIC_NAME, msg+"key",msg+"value");
        return "Publish successfully";
    }

/*    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate2;

    private static final String TOPIC_NAME2 = "book1";

    @PostMapping("/publish")
    public String publishMsg2(@RequestBody Book book){
        kafkaTemplate2.send(TOPIC_NAME2, book.getBookName(),book);
        return "Publish successfully";
    }*/

}
