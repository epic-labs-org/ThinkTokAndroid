package com.epiclabs.thinktok.data.local.dao

import com.epiclabs.thinktok.data.local.mapper.toWordEntity
import com.epiclabs.thinktok.data.local.mapper.toWordReaction
import com.epiclabs.thinktok.data.local.mapper.toWordReactionEntity
import com.epiclabs.thinktok.main.domain.api.model.Word
import com.epiclabs.thinktok.main.domain.api.model.WordReaction
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class WordReactionDaoTestImpl : WordDatabaseTest() {
    private lateinit var wordReactionDao: WordReactionDao
    private lateinit var wordDao: WordDao

    @Before
    fun initDao() {
        wordDao = db.wordDao()
        wordReactionDao = db.wordReactionDao()
    }

    @Test
    fun insertAndGetWordReaction_shouldRetrieveCorrectReaction() =
        runTest {
            // Given
            val initialWord =
                Word(
                    id = 1,
                    word = "word",
                    translation = "translation",
                )

            val initialWordReaction =
                WordReaction(
                    id = 1,
                    wordId = 1,
                    reaction = true,
                    timestamp = 123456789,
                )

            // When
            /*
             * As word_reactions table is a one to one relationship with words table, we need to insert word first.
             * */
            db.wordDao().insertAll(listOf(initialWord.toWordEntity()))
            wordReactionDao.insert(initialWordReaction.toWordReactionEntity())

            // Then
            val retrievedWordReaction =
                wordReactionDao
                    .getWordReaction(wordId = initialWordReaction.id)
                    .firstOrNull()
                    ?.firstOrNull()
                    ?.toWordReaction()
            assertEquals(initialWordReaction, retrievedWordReaction)
        }

    @Test
    fun clearWordReaction_shouldRetrieveEmptyList() =
        runTest {
            // Given
            val word =
                Word(
                    id = 1,
                    word = "word",
                    translation = "translation",
                )

            val wordReaction =
                WordReaction(
                    id = 1,
                    wordId = 1,
                    reaction = true,
                    timestamp = 123456789,
                )

            // When
        /*
         * As word_reactions table is a one to one relationship with words table, we need to insert word first.
         * */
            db.wordDao().insertAll(listOf(word.toWordEntity()))
            wordReactionDao.insert(wordReaction.toWordReactionEntity())

            // Then
            wordReactionDao.clearAll()
            val retrievedWordReaction =
                wordReactionDao
                    .getWordReaction(wordId = wordReaction.id)
                    .firstOrNull()
                    ?.map {
                        it.toWordReaction()
                    }

            assertEquals(emptyList<WordReaction>(), retrievedWordReaction)
        }
}