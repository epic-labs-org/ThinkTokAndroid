package com.epiclabs.thinktok.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.epiclabs.thinktok.data.local.entity.UserPreferenceEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserPreferenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPreference(userPreference: UserPreferenceEntity)

    @Query("SELECT * FROM user_preferences LIMIT 1")
    fun getUserPreference(): Flow<UserPreferenceEntity?>
}