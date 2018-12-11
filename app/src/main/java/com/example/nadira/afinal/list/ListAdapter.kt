package com.example.nadira.afinal.list


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class ListAdapter(var people: List<Person>) : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = LayoutInflater.inflate<ItemPersonBinding>(layoutInflater, R.layout.item_person, parent, false)
        return PersonViewHolder(itemPersonBinding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(people.get(position))
    }

    override fun getItemCount(): Int = people.size

    override fun getItemViewType(position: Int) = position

    fun replaceData(people: List<Person>) {
        this.people = people
    }
}