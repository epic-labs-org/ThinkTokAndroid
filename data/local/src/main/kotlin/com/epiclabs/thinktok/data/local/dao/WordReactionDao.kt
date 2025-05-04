package com.epiclabs.thinktok.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.epiclabs.thinktok.data.local.entity.WordReactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface WordReactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordReaction: WordReactionEntity)

    @Query("SELECT * FROM word_reactions WHERE word_id = :wordId")
    fun getWordReaction(wordId: Int): Flow<List<WordReactionEntity>>

    @Query("DELETE FROM word_reactions")
    suspend fun clearAll()
}