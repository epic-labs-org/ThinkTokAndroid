package com.epiclabs.thinktok.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val DEFAULT_USER_ID = 1

@Entity(tableName = "user_preferences")
internal data class UserPreferenceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = DEFAULT_USER_ID,
    @ColumnInfo(name = "learning_language") val learningLanguage: String,
    @ColumnInfo(name = "origin_language") val originLanguage: String,
)