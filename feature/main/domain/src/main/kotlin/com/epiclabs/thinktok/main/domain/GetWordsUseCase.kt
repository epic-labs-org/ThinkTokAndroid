package com.epiclabs.thinktok.main.domain

import androidx.paging.PagingData
import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.domain.api.repository.WordRepository
import kotlinx.coroutines.flow.Flow

class GetWordsUseCase(
    private val repository: WordRepository,
) {
    operator fun invoke(): Flow<PagingData<Word>> = repository.getWords()
}