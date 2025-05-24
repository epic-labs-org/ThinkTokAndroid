package com.epiclabs.thinktok.data.local.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.epiclabs.thinktok.data.local.dao.WordDao
import com.epiclabs.thinktok.data.local.entity.WordEntity
import com.epiclabs.thinktok.data.local.mapper.toWord
import com.epiclabs.thinktok.data.local.mapper.toWordEntity
import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.repository.api.WordLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.epiclabs.thinktok.data.local.dao.WordReactionDao
import com.epiclabs.thinktok.data.local.mapper.toWordReaction
import com.epiclabs.thinktok.data.local.mapper.toWordReactionEntity
import com.epiclabs.thinktok.main.domain.api.model.WordReaction

internal class WordLocalDataSourceImpl(
    private val wordDao: WordDao,
    private val wordReactionDao: WordReactionDao,
) : WordLocalDataSource {
    override fun getWords(): Flow<PagingData<Word>> {
        return Pager(
            config =
                PagingConfig(
                    initialLoadSize = 30,
                    pageSize = 20,
                    enablePlaceholders = false,
                ),
            pagingSourceFactory = { wordDao.getWordsPagingSource() },
        ).flow.map { pagingData: PagingData<WordEntity> ->
            pagingData.map { wordEntity: WordEntity ->
                wordEntity.toWord()
            }
        }
    }

    override suspend fun insertWords(words: List<Word>) {
        wordDao.insertAll(words.map { it.toWordEntity() })
    }

    override suspend fun clearAllWords() {
        wordDao.clearAll()
    }

    override suspend fun getWordReactions(wordId: Int): Flow<List<WordReaction>> =
        wordReactionDao
            .getWordReaction(wordId)
            .map {
                it.map { wordReactionEntity ->
                    wordReactionEntity.toWordReaction()
                }
            }

    override suspend fun insertWordReaction(wordReaction: WordReaction) {
        wordReactionDao.insert(wordReaction.toWordReactionEntity())
    }

    override suspend fun clearAllWordReactions() {
        wordReactionDao.clearAll()
    }
}