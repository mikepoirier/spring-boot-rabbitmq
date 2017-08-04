package io.mikepoirier.hellorabbitmq.receiver.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class JacksonConfig {

    @Bean
    fun objectMapper() = jacksonObjectMapper()
}