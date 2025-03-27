package com.epiclabs.thinktok.main.repository

import androidx.paging.PagingData
import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.domain.api.repository.WordRepository
import com.epiclabs.thinktok.main.repository.api.WordLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class WordRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher,
    private val wordLocalDataSource: WordLocalDataSource,
) : WordRepository {
    override fun getWords(): Flow<PagingData<Word>> =
        wordLocalDataSource
            .getWords()
            .flowOn(ioDispatcher)

    override suspend fun insertWords(words: List<Word>) {
        withContext(ioDispatcher) {
            wordLocalDataSource.insertWords(words)
        }
    }

    override suspend fun clearAllWords() =
        withContext(ioDispatcher) {
            wordLocalDataSource.clearAllWords()
        }
}