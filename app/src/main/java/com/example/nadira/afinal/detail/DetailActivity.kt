package com.example.nadira.afinal.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nadira.afinal.model.Person


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = intent.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)

        val person = intent.getParcelableExtra("person") as Person
        val factory = DetailViewModel(person)
        binding.detailViewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)
    }
}