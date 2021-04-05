package io.github.hughnatt.naski.app

import io.github.hughnatt.core.interactor.SaveBirthdayInteractor
import io.github.hughnatt.core.interactor.SaveBirthdayInteractorImpl
import io.github.hughnatt.core.repository.BirthdayRepository
import io.github.hughnatt.data.repository.BirthdayRepositoryImpl
import io.github.hughnatt.naski.app.birthday.edit.EditBirthdayViewModel
import io.github.hughnatt.naski.app.birthday.list.BirthdayListViewModel
import io.github.hughnatt.naski.app.common.datepicker.DatePickerViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // MARK - View Models

    viewModel { BirthdayListViewModel(get()) }
    viewModel { EditBirthdayViewModel(get()) }
    viewModel { DatePickerViewModel() }

    // MARK - Repositories

    single<BirthdayRepository> { BirthdayRepositoryImpl(get()) }

    // MARK - Interactors

    single<SaveBirthdayInteractor> { SaveBirthdayInteractorImpl(get()) }
}