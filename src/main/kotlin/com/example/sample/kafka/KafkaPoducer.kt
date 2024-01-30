package com.example.sample.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaPoducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

  fun sendMessge(topic:String,message:String){
      kafkaTemplate.send(topic, message)
      println("------ Send message TOPIC: "+topic + " MESSAGE :"+message)
  }


}