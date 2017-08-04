package io.mikepoirier.hellorabbitmq.receiver.messaging

import io.mikepoirier.hellorabbitmq.common.model.MessagePayload
import io.mikepoirier.hellorabbitmq.receiver.model.MessageDocument
import io.mikepoirier.hellorabbitmq.receiver.repository.MessageDocumentRepository
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.*

@Component
@RabbitListener(queues = arrayOf("test"))
class RabbitMQReceiver(
    val messageDocumentRepository: MessageDocumentRepository
) {

    private val LOGGER = LoggerFactory.getLogger(RabbitMQReceiver::class.java)

    @RabbitHandler
    fun receive(message: MessagePayload) {
        messageDocumentRepository.save(MessageDocument(Date(), message))
            .doOnNext{ LOGGER.info("Saved: $it") }
            .doOnError { LOGGER.error("Error saving message", it) }
            .subscribe()
    }
}