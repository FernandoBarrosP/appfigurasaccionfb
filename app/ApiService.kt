interface ApiService {
    @GET("figuras")
    suspend fun getFiguras(): List<Figura>

    @GET("figuras/{id}")
    suspend fun getFiguraDetail(@Path("id") id: Int): Figura
}

}