package com.epiclabs.thinktok.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.epiclabs.thinktok.data.local.entity.WordReactionEntity

@Dao
internal interface WordReactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordReaction: WordReactionEntity)

    @Query("SELECT * FROM word_reactions WHERE word_id = :wordId")
    suspend fun getWordReaction(wordId: Int): List<WordReactionEntity>?
}