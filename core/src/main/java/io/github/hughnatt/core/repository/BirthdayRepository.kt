package io.github.hughnatt.core.repository

import io.github.hughnatt.core.entity.Birthday

interface BirthdayRepository {
    suspend fun getBirthdays() : List<Birthday>
    suspend fun createBirthday(birthday: Birthday)
}