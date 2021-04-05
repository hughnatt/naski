package io.github.hughnatt.core.interactor

import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.core.repository.BirthdayRepository

interface SaveBirthdayInteractor {
    suspend fun execute(birthday: Birthday)
}

class SaveBirthdayInteractorImpl(
    private val birthdayRepository: BirthdayRepository,
): SaveBirthdayInteractor {
    override suspend fun execute(birthday: Birthday) {
        birthdayRepository.createBirthday(birthday)
    }
}