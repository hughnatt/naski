package io.github.hughnatt.naski.app.common.datepicker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class DatePickerViewModel: ViewModel() {

    private val _date = MutableLiveData<Date>()
    val date: LiveData<Date> = _date

    fun updateDate(year: Int, month: Int, day: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        _date.value = calendar.time
    }
}