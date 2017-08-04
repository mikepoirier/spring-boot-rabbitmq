package io.mikepoirier.hellorabbitmq.publisher.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun queue(): Queue {
        return Queue("test")
    }

    @Bean
    fun jsonMessageConverter() = Jackson2JsonMessageConverter()
}