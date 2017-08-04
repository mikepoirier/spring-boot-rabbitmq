package io.mikepoirier.hellorabbitmq.publisher.web.handler

import io.mikepoirier.hellorabbitmq.publisher.ext.json
import io.mikepoirier.hellorabbitmq.publisher.messaging.RabbitMQSender
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.stream.IntStream

@Component
class SendHandler(
    val rabbitMQSender: RabbitMQSender
) {

    fun handleRequest(req: ServerRequest): Mono<ServerResponse> {

        val iterationFlux = Flux.fromStream(IntStream.range(0, 5).boxed())
        val bodyFlux = req.bodyToFlux<String>()

        req.bodyToMono<String>()
            .doOnNext { println("Sending $it") }
            .doOnNext(rabbitMQSender::send)
            .subscribe()

        return ServerResponse
            .ok()
            .json()
            .body(Mono.just(SendResponse("Message sent!")))
    }
}

data class SendResponse(val message: String)