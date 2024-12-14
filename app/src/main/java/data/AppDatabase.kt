package data

class AppDatabase {@Database(entities = [Figura::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun figuraDao(): FiguraDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "figura_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

    class Converters {
        @TypeConverter
        fun fromList(value: List<String>?): String {
            return value?.joinToString(",") ?: ""
        }

        @TypeConverter
        fun toList(value: String): List<String> {
            return value.split(",").map { it.trim() }
        }
    }

}