package io.mikepoirier.hellorabbitmq.receiver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class MessageReceiverApplication

fun main(args: Array<String>) {
    SpringApplication.run(MessageReceiverApplication::class.java, *args)
}