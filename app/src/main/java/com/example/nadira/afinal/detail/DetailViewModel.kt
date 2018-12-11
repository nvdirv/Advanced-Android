package com.example.nadira.afinal.detail

import android.arch.lifecycle.ViewModel
import com.example.nadira.afinal.model.Person


class DetailViewModel(var person: Person) : ViewModel() {

    fun getFullName() = formattedFullName(arrayOf(person.name.first, person.name.last))

    fun getPicture() = person.picture.large

    fun getUsername() = person.username

    fun getPhone() = person.mphone

    fun getCell() = person.hphone

    fun getWorkPhone() = person.wphone
}