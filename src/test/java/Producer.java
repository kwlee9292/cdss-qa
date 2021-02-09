import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
    public static void produce(String brokers, String topicName) throws IOException {
        // Create Producer
        KafkaProducer<String, String> producer;
        // Configure
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", brokers);
        properties.setProperty("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);

        for(int i=0;i<100;i++){
            ProducerRecord record = new ProducerRecord<String, String>(topicName, Integer.toString(i));
            producer.send(record);
        }
        producer.close();
    }
}