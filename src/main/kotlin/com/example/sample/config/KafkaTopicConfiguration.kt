package com.example.sample.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
@EnableKafka
class KafkaTopicConfiguration {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any> = HashMap()
        configs["bootstrap.servers"] = "localhost:9092"
        return KafkaAdmin(configs)
    }

    @Bean
    fun exampleTopic(): NewTopic {
        return TopicBuilder.name("example-topic")
            .partitions(10)
            .replicas(3)
            .build()
    }

    @Bean
    fun greetingTopic(): NewTopic {
        return TopicBuilder.name("greeting-topic")
            .partitions(1)
            .replicas(1)
            .build()
    }

//    @Bean
//    fun kafkaTemplate(): KafkaTemplate<String, String> {
//        return KafkaTemplate(producerFactory())
//    }


    @Bean
    fun kafkaConsumerConfig(): Map<String, Any> {
        val config = HashMap<String, Any>()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[ConsumerConfig.GROUP_ID_CONFIG] = "demoId"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        return config
    }

    @Bean
    fun kafkaConsumerr(): KafkaConsumer<String, String> {
        return KafkaConsumer(kafkaConsumerConfig())
    }

}