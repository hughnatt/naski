package io.github.hughnatt.naski.app.birthday.list


sealed class Action

object FetchBirthdays: Action()
object RequestCreateBirthday: Action()
