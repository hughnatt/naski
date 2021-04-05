package io.github.hughnatt.naski.app.birthday.edit

import io.github.hughnatt.core.entity.Birthday

sealed class Action

object ShowDatePicker: Action()
data class SaveBirthday(val birthday: Birthday): Action()