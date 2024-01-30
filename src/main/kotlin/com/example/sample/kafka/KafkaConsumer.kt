package com.example.sample.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class KafkaConsumer {
    @KafkaListener(topics = ["example-topic","greeting-topic"], groupId = "demoId")
   fun listenToMessages(record:String) {
        println("-----Received message in consumer 1: $record")
   }
    @KafkaListener(topics = ["example-topic","greeting-topic"], groupId = "demoId")
    fun consumer2(record:String) {
        println("-----Received message in consumer 2: $record")
    }

    @KafkaListener(topics = ["__consumer_offsets"])
    fun consumeMessage(record: ConsumerRecord<String, String>) {
        val key = record.key()
        val value = record.value()
        val partition = record.partition()
        val offset = record.offset()
        println("Received Kafka message. Key: $key, Value: $value , partition : $partition , offset : $offset" )
    }


}