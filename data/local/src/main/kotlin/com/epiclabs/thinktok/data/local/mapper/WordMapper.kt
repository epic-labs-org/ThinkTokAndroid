package com.epiclabs.thinktok.data.local.mapper

import com.epiclabs.thinktok.data.local.entity.WordEntity
import com.epiclabs.thinktok.main.domain.api.model.Word

internal fun WordEntity.toWord(): Word {
    return Word(
        id = this.id,
        word = this.word,
        translation = this.translation,
    )
}

internal fun Word.toWordEntity(): WordEntity {
    return WordEntity(
        id = this.id,
        word = this.word,
        translation = this.translation,
    )
}