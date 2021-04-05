package io.github.hughnatt.naski.app.common

import android.content.Intent
import androidx.navigation.NavDirections

sealed class NavigationOrder

class NavigateTo(val navDirections: NavDirections): NavigationOrder()
object PopBackStack: NavigationOrder()
class StartActivity(val intent: Intent): NavigationOrder()