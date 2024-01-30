package com.example.sample.controller

import com.example.sample.kafka.KafkaPoducer
import com.example.sample.util.TopicNAmes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class RestController(private val kafkaProducer :KafkaPoducer) {

    @GetMapping("/publish")
    fun publish(@RequestParam message: String): ResponseEntity<Any> {
        kafkaProducer.sendMessge(TopicNAmes.EXAMPLE_TOPIC, message)
        return ResponseEntity.ok().body("message produce succesfully")
    }

    @GetMapping("/greeting")
    fun GreetingApi(@RequestParam message: String): ResponseEntity<Any> {
        kafkaProducer.sendMessge(TopicNAmes.GREETING_TOPIC, message)
        return ResponseEntity.ok().body("message produce succesfully")
    }

}