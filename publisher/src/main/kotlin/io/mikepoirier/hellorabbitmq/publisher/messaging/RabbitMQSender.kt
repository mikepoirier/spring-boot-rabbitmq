package io.mikepoirier.hellorabbitmq.publisher.messaging

import io.mikepoirier.hellorabbitmq.common.model.MessagePayload
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class RabbitMQSender(
    val rabbitTemplate: RabbitTemplate
) {

    fun send(message: String) {

        val msg = MessagePayload(message, Date())

        rabbitTemplate.convertAndSend("test", msg)
    }
}