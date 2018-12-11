package com.example.nadira.afinal.model

import android.os.Parcelable


class ContactResults(val results: List<Person>,
                   val info: Metadata)

@Parcelize
class Person(val id: Id,
             val name: Name,
             val mphone: String,
             val hphone: String,
             val wphone: String,
             val picture: Picture) : Parcelable

annotation class Parcelize

@Parcelize
class Name(val title: String,
           val first: String,
           val last: String) : Parcelable

@Parcelize
class Phone(val mphone: String,
            hphone: String,
            wphone: String): Parcelable


@Parcelize
class Id(val name: String,
         val value: String) : Parcelable

@Parcelize
class Picture(val large: String,
              val medium: String) : Parcelable

class Metadata(val version: String)