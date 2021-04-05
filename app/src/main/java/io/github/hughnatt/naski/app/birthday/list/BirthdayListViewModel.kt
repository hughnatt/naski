package io.github.hughnatt.naski.app.birthday.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.core.repository.BirthdayRepository
import io.github.hughnatt.naski.app.common.SharedViewModel
import kotlinx.coroutines.launch
import java.util.*

class BirthdayListViewModel(
    private val birthdayRepository: BirthdayRepository,
): SharedViewModel<Action>() {

    private val _birthdays = MutableLiveData<List<Birthday>>()
    val birthdays: LiveData<List<Birthday>> = _birthdays

    // Mark - SharedViewModel

    override fun action(action: Action) {
        when (action) {
            is FetchBirthdays -> fetchBirthdays()
            is RequestCreateBirthday -> createBirthday()
        }
    }

    // MARK - Private

    private fun fetchBirthdays() {
        viewModelScope.launch {
            _birthdays.value = birthdayRepository.getBirthdays();
        }
    }

    private fun createBirthday() {
        navigate(BirthdayListFragmentDirections.actionBirthdayListToEditBirthday())
    }
}