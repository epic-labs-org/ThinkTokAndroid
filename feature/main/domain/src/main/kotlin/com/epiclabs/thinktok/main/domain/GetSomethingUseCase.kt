package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.SomethingRepository

class GetSomethingUseCase(
    private val somethingRepository: SomethingRepository,
) {
    operator fun invoke() = somethingRepository.getThatThing()
}