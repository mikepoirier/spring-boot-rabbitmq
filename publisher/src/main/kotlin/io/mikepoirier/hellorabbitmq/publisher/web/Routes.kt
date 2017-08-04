package io.mikepoirier.hellorabbitmq.publisher.web

import io.mikepoirier.hellorabbitmq.publisher.web.handler.SendHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes {

    @Bean
    fun apiRoutes(sendHandler: SendHandler) = router {
        accept(MediaType.APPLICATION_JSON).nest {
            "/send".nest {
                POST("/", sendHandler::handleRequest)
            }
        }
    }
}