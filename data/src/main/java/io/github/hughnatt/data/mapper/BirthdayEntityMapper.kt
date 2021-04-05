package io.github.hughnatt.data.mapper

import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.data.room.dao.BirthdayEntity
import java.util.*

class BirthdayEntityMapper(val birthday: Birthday) {
    fun map(): BirthdayEntity {
        return BirthdayEntity(
            uid = UUID.randomUUID().toString(),
            name = birthday.name,
            date = birthday.date,
        )
    }
}