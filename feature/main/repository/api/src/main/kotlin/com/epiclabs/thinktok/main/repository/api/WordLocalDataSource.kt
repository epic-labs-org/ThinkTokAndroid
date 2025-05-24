package com.epiclabs.thinktok.main.repository.api

import androidx.paging.PagingData
import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.domain.api.model.WordReaction
import kotlinx.coroutines.flow.Flow

interface WordLocalDataSource {
    fun getWords(): Flow<PagingData<Word>>

    suspend fun insertWords(words: List<Word>)

    suspend fun clearAllWords()

    suspend fun getWordReactions(wordId: Int): Flow<List<WordReaction>>

    suspend fun insertWordReaction(wordReaction: WordReaction)

    suspend fun clearAllWordReactions()
}