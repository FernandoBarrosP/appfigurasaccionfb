class FiguraRepository {(private val figuraDao: FiguraDao) {
    val allFiguras: LiveData<List<Figura>> = figuraDao.getAllFiguras()

    suspend fun refreshFiguras() {
        val figuras = RetrofitClient.apiService.getFiguras()
        figuraDao.insertFiguras(figuras)
    }
}

}