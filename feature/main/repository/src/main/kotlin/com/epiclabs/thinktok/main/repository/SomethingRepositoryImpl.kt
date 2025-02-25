package com.epiclabs.thinktok.main.repository

import com.epiclabs.thinktok.main.domain.api.SomethingRepository

class SomethingRepositoryImpl : SomethingRepository {
    override fun getThatThing() = "Thing"
}