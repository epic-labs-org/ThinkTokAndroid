package com.epiclabs.thinktok.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val DEFAULT_WORD_ID = 1

@Entity(tableName = "words")
internal data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = DEFAULT_WORD_ID,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "translation") val translation: String,
)