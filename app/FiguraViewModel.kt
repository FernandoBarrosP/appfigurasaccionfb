class FiguraViewModel {class FiguraViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FiguraRepository
    val allFiguras: LiveData<List<Figura>>

    init {
        val figuraDao = AppDatabase.getDatabase(application).figuraDao()
        repository = FiguraRepository(figuraDao)
        allFiguras = repository.allFiguras
        viewModelScope.launch {
            repository.refreshFiguras()
        }
    }
}

}