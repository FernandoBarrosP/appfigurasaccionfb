package data

class FiguraDao {@Dao
interface FiguraDao {
    @Query("SELECT * FROM figuras")
    fun getAllFiguras(): LiveData<List<Figura>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFiguras(figuras: List<Figura>)
}

}