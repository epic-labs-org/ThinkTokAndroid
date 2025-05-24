package com.epiclabs.thinktok.main.domain.api.model

data class WordReaction(
    val id: Int,
    val wordId: Int,
    val reaction: Boolean,
    val timestamp: Long,
)
