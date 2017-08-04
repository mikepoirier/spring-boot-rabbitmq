package io.mikepoirier.hellorabbitmq.receiver.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun jsonMessageConverter(objectMapper: ObjectMapper) = Jackson2JsonMessageConverter(objectMapper, "io.mikepoirier.hellorabbitmq.common.model")
}