package io.github.hughnatt.naski.app.birthday.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.core.interactor.SaveBirthdayInteractor
import io.github.hughnatt.naski.app.common.SharedViewModel
import kotlinx.coroutines.launch

class EditBirthdayViewModel(
    private val saveBirthdayInteractor: SaveBirthdayInteractor
): SharedViewModel<Action>() {

    private val _birthday = MutableLiveData<Birthday>()
    val birthday: LiveData<Birthday> = _birthday

    // MARK - SharedViewModel

    override fun action(action: Action) {
        when (action) {
            is SaveBirthday -> saveBirthday(action.birthday)
            is ShowDatePicker -> showDatePicker()
        }
    }

    // MARK - Private

    private fun saveBirthday(birthday: Birthday) {
        viewModelScope.launch {
            saveBirthdayInteractor.execute(birthday)
            navigate(EditBirthdayFragmentDirections.actionEditBirthdayToBirthdayList())
        }
    }

    private fun showDatePicker() {
        navigate(EditBirthdayFragmentDirections.actionEditBirthdayToDatePickerDialog())
    }
}