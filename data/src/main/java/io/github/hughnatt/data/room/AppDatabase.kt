package io.github.hughnatt.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.hughnatt.data.room.dao.BirthdayDAO
import io.github.hughnatt.data.room.dao.BirthdayEntity

@Database(entities = [BirthdayEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun birthdayDAO(): BirthdayDAO
}