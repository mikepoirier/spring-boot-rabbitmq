package io.mikepoirier.hellorabbitmq.publisher

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MessagePublisherApplication

fun main(args: Array<String>) {
    SpringApplication.run(MessagePublisherApplication::class.java, *args)
}
