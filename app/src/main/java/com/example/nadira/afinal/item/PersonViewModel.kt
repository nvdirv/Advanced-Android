package com.example.nadira.afinal.item

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso


class PersonViewModel(val context: Context, var person: Person) : BaseObservable() {

    fun getPicture() = person.picture.medium

    fun getFullName() = formattedFullName(arrayOf(person.name.title, person.name.first, person.name.last))

    fun getPhone() = person.mphone



    fun onClick(view: View) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("person", person)
        context.startActivity(intent)
    }
}