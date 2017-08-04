package io.mikepoirier.hellorabbitmq.receiver.repository

import io.mikepoirier.hellorabbitmq.receiver.model.MessageDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MessageDocumentRepository : ReactiveMongoRepository<MessageDocument, ObjectId>