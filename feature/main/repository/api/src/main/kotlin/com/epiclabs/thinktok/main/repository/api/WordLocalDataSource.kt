package com.epiclabs.thinktok.main.repository.api

import androidx.paging.PagingData
import com.epiclabs.thinktok.main.domain.api.model.Word
import kotlinx.coroutines.flow.Flow

interface WordLocalDataSource {
    fun getWords(): Flow<PagingData<Word>>

    suspend fun insertWords(words: List<Word>)

    suspend fun clearAllWords()
}