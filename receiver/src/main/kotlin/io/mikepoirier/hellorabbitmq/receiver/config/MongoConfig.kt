package io.mikepoirier.hellorabbitmq.receiver.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import io.mikepoirier.hellorabbitmq.receiver.repository.MessageDocumentRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.data.mongodb.core.ReactiveMongoTemplate




@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = arrayOf(MessageDocumentRepository::class))
class MongoConfig : AbstractReactiveMongoConfiguration() {

    @Bean
    override fun mongoClient(): MongoClient {
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return "test"
    }

    @Bean
    override fun reactiveMongoTemplate(): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(mongoClient(), databaseName)
    }
}