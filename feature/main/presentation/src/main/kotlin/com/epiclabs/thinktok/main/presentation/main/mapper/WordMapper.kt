package com.epiclabs.thinktok.main.presentation.main.mapper

import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.presentation.main.model.WordUiModel

class WordMapper {
    fun map(word: Word) =
        WordUiModel(
            id = word.id,
            word = word.word,
            translation = word.translation,
        )
}