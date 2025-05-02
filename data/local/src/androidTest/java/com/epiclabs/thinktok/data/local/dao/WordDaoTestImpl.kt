package com.epiclabs.thinktok.data.local.dao

import androidx.paging.PagingSource
import com.epiclabs.thinktok.data.local.entity.DEFAULT_WORD_ID
import com.epiclabs.thinktok.data.local.entity.WordEntity
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class WordDaoTestImpl : WordDatabaseTest() {
    private lateinit var wordDao: WordDao

    @Before
    fun initDao() {
        wordDao = db.wordDao()
    }

    @Test
    fun insertAndGetWords() =
        runTest {
            val word = WordEntity(id = DEFAULT_WORD_ID, word = "word", translation = "کلمه")

            wordDao.insertAll(listOf(word))

            val pagingSource: PagingSource<Int, WordEntity> = wordDao.getWordsPagingSource()

            // Load the first page
            val loadResult: PagingSource.LoadResult<Int, WordEntity> =
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 1,
                        placeholdersEnabled = false,
                    ),
                )

            // Check if loadResult is a LoadResult.Page
            assert(loadResult is PagingSource.LoadResult.Page)

            // Extract the loaded data if it's a LoadResult.Page
            val loadedData: List<WordEntity> =
                when (loadResult) {
                    is PagingSource.LoadResult.Page -> loadResult.data
                    else -> emptyList()
                }

            assertEquals(1, loadedData.size)
            assertEquals(word.word, loadedData[0].word)
            assertEquals(word.translation, loadedData[0].translation)
        }

    @Test
    fun insertAndClearWords() =
        runTest {
            val word = WordEntity(id = DEFAULT_WORD_ID, word = "test", translation = "test")
            wordDao.insertAll(listOf(word))
            wordDao.clearAll()

            val pagingSource: PagingSource<Int, WordEntity> = wordDao.getWordsPagingSource()

            // Load the first page
            val loadResult: PagingSource.LoadResult<Int, WordEntity> =
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 1,
                        placeholdersEnabled = false,
                    ),
                )

            // Check if loadResult is a LoadResult.Page
            assert(loadResult is PagingSource.LoadResult.Page)

            // Extract the loaded data if it's a LoadResult.Page
            val loadedData: List<WordEntity> =
                when (loadResult) {
                    is PagingSource.LoadResult.Page -> loadResult.data
                    else -> emptyList()
                }

            assertEquals(0, loadedData.size)
        }

    @Test
    fun insertAndGetWordsWithQuery() =
        runTest {
            val word1 = WordEntity(id = DEFAULT_WORD_ID, word = "test", translation = "test")
            val word2 = WordEntity(id = DEFAULT_WORD_ID + 1, word = "test2", translation = "test2")
            wordDao.insertAll(
                listOf(word1, word2),
            )

            val pagingSource: PagingSource<Int, WordEntity> = wordDao.getWordsPagingSource()
            val loadResult: PagingSource.LoadResult<Int, WordEntity> =
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 1,
                        placeholdersEnabled = false,
                    ),
                )

            // Check if loadResult is a LoadResult.Page
            assert(loadResult is PagingSource.LoadResult.Page)

            // Extract the loaded data if it's a LoadResult.Page
            val loadedData: List<WordEntity> =
                when (loadResult) {
                    is PagingSource.LoadResult.Page -> loadResult.data
                    else -> emptyList()
                }

            assertEquals(1, loadedData.size)
            assertEquals(word1.word, loadedData[0].word)
            assertEquals(word1.translation, loadedData[0].translation)
        }
}