package com.example.nadira.afinal.list

class ListViewModel : ViewModel() {

    var personModel: ListModel = ListModel()
    var people = MutableLiveData<List<Person>>()
    val isLoading = ObservableField<Boolean>()
    val compositeDisposable = CompositeDisposable()

    fun start() {
        isLoading.set(true)
        val disposable = personModel.getPeople()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onPersonListReceived, this::onPersonListReceptionError)
        compositeDisposable.add(disposable)
    }

    private fun onPersonListReceived(peopleResult: PeopleResult) {
        isLoading.set(false)
        this.people.value = peopleResult.results
    }

    private fun onPersonListReceptionError(throwable: Throwable) {
        isLoading.set(false)
        this.people.value = null
        Log.e(ListingViewModel::class.java.simpleName, "Error while loading people data: " + throwable.message)
    }

    override public fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}