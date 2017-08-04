package io.mikepoirier.hellorabbitmq.receiver.web

import io.mikepoirier.hellorabbitmq.publisher.ext.json
import io.mikepoirier.hellorabbitmq.receiver.repository.MessageDocumentRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes {

    @Bean
    fun apiRoutes(messageDocumentRepository: MessageDocumentRepository) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "/messages".nest {
                GET("/", {
                    ServerResponse
                        .ok()
                        .json()
                        .body(messageDocumentRepository.findAll())
                })
            }
        }
    }
}