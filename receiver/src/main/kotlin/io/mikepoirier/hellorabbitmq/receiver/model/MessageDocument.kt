package io.mikepoirier.hellorabbitmq.receiver.model

import io.mikepoirier.hellorabbitmq.common.model.MessagePayload
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class MessageDocument(
    val updatedAt: Date,
    val message: MessagePayload,
    @Id var id: ObjectId? = null
)