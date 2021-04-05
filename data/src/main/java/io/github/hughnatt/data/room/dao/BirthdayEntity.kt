package io.github.hughnatt.data.room.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.github.hughnatt.data.room.util.DateConverter
import java.util.Date

@Entity(tableName = "BIRTHDAY")
@TypeConverters(DateConverter::class)
data class BirthdayEntity(
    @PrimaryKey val uid: String,
    val name: String,
    val date: Date,
)