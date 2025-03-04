package com.epiclabs.thinktok.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.entity.UserPreferenceEntity

@Database(entities = [UserPreferenceEntity::class], version = 1, exportSchema = false)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userPreferenceDao(): UserPreferenceDao
}