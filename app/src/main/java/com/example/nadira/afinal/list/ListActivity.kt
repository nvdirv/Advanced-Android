package com.example.nadira.afinal.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.nadira.afinal.R


class ListingActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ListingViewModel
    lateinit var bar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListingViewModel::class.java)
        binding.viewModel = viewModel

        binding.rvPeople.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.people_list_span))
        binding.rvPeople.setHasFixedSize(true)
        val personAdapter = ListingAdapter(ArrayList())
        binding.rvPeople.adapter = personAdapter

        viewModel.people.observe(this, Observer<List<Person>> {
            if (it == null || it.isEmpty())
                onLoadingDataError()
            else {
                personAdapter.replaceData(it)
            }
        })

        viewModel.start()
    }

    private fun onLoadingDataError() {
        bar = Snackbar.make(rootView(), getString(R.string.error_loading_people), Snackbar.LENGTH_INDEFINITE);
        bar.setAction(getString(R.string.retry), { view -> viewModel.start() })
        bar.show();
    }

    private fun rootView(): View = findViewById(android.R.id.content)
}