package com.epiclabs.thinktok.main.domain.api.repository

import androidx.paging.PagingData
import com.epiclabs.thinktok.main.domain.api.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    suspend fun insertWords(words: List<Word>)

    suspend fun clearAllWords()

    fun getWords(): Flow<PagingData<Word>>
}