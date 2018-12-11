package com.example.nadira.afinal.list

class ListModel {

    var EMPTY_URL = ""
    fun getPeople() = PeopleService().personApi.getPersonList(EMPTY_URL)

}