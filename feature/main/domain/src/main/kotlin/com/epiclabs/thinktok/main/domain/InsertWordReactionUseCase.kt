package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.model.WordReaction
import com.epiclabs.thinktok.main.domain.api.repository.WordRepository

class InsertWordReactionUseCase(
    private val repository: WordRepository,
) {
    suspend operator fun invoke(wordReaction: WordReaction) = repository.insertWordReaction(wordReaction)
}