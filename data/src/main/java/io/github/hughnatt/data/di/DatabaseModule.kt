package io.github.hughnatt.data.di

import androidx.room.Room
import io.github.hughnatt.data.room.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    // AppDatabase
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "NASKI_DATABASE",
        ).build()
    }

    // BirthdayDAO
    single {
        provideBirthdayDAO(get())
    }
}

private fun provideBirthdayDAO(db: AppDatabase) = db.birthdayDAO()