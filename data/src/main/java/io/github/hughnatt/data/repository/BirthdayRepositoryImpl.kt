package io.github.hughnatt.data.repository

import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.core.repository.BirthdayRepository
import io.github.hughnatt.data.mapper.BirthdayEntityMapper
import io.github.hughnatt.data.room.dao.BirthdayDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BirthdayRepositoryImpl (
    private val birthdayDAO: BirthdayDAO
) : BirthdayRepository {

    override suspend fun getBirthdays(): List<Birthday> = withContext(Dispatchers.IO) {
        birthdayDAO.getAll().map { Birthday(name = it.name, date = it.date) }
    }

    override suspend fun createBirthday(birthday: Birthday) = withContext(Dispatchers.IO) {
        birthdayDAO.insertAll(BirthdayEntityMapper(birthday).map())
    }
}