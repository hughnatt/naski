package io.github.hughnatt.naski.app.common

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

abstract class SharedViewModel<ActionT: Any>: ViewModel() {
    private val _navLiveData = MutableLiveData<NavigationOrder>()
    val navLiveData: LiveData<NavigationOrder> = _navLiveData

    protected fun navigate(navDirections: NavDirections) {
        _navLiveData.value = NavigateTo(navDirections)
    }

    protected fun navigateBack() {
        _navLiveData.value = PopBackStack
    }

    protected fun startActivity(intent: Intent) {
        _navLiveData.value = StartActivity(intent)
    }

    abstract fun action(action: ActionT)
}