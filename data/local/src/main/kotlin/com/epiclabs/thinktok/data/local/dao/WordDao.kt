package com.epiclabs.thinktok.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.epiclabs.thinktok.data.local.entity.WordEntity

@Dao
internal interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(words: List<WordEntity>)

    /**
     * @return A [PagingSource] that can be used to load pages of [WordEntity] data.
     * Each page is represented by an [Int] key (page number), and each item within a page is a [WordEntity].
     */
    @Query("SELECT * FROM words")
    fun getWordsPagingSource(): PagingSource<Int, WordEntity>

    @Query("DELETE FROM words")
    suspend fun clearAll()
}