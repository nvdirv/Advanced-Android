package com.example.nadira.afinal.item

class PersonViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(person: Person) {
        if (binding.itemPersonViewModel == null) {
            binding.itemPersonViewModel = PersonViewModel(itemView.context, person)
        } else {
            binding.itemPersonViewModel!!.person = person
        }
    }
}