package com.epiclabs.thinktok.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.dao.WordDao
import com.epiclabs.thinktok.data.local.dao.WordReactionDao
import com.epiclabs.thinktok.data.local.entity.UserPreferenceEntity
import com.epiclabs.thinktok.data.local.entity.WordEntity
import com.epiclabs.thinktok.data.local.entity.WordReactionEntity

@Database(
    entities = [
        UserPreferenceEntity::class,
        WordEntity::class,
        WordReactionEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userPreferenceDao(): UserPreferenceDao

    abstract fun wordDao(): WordDao

    abstract fun wordReactionDao(): WordReactionDao
}