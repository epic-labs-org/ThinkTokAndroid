package com.epiclabs.thinktok.data.local.mapper

import com.epiclabs.thinktok.data.local.entity.WordReactionEntity
import com.epiclabs.thinktok.main.domain.api.model.WordReaction

internal fun WordReactionEntity.toWordReaction(): WordReaction {
    return WordReaction(
        id = this.id,
        wordId = this.wordId,
        reaction = this.reaction,
        timestamp = this.timestamp,
    )
}

internal fun WordReaction.toWordReactionEntity(): WordReactionEntity {
    return WordReactionEntity(
        id = this.id,
        wordId = this.wordId,
        reaction = this.reaction,
        timestamp = this.timestamp,
    )
}