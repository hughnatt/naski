package io.github.hughnatt.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BirthdayDAO {
    @Query("SELECT * FROM BIRTHDAY")
    fun getAll(): List<BirthdayEntity>

    @Query("SELECT * FROM BIRTHDAY WHERE uid IN (:uids)")
    fun loadAllByIds(uids: Array<String>): List<BirthdayEntity>

    @Query("SELECT * FROM BIRTHDAY WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): BirthdayEntity

    @Insert
    fun insertAll(vararg birthdays: BirthdayEntity)

    @Delete
    fun delete(birthday: BirthdayEntity)

    @Query("DELETE FROM BIRTHDAY WHERE uid = :uid")
    fun delete(uid: String)
}