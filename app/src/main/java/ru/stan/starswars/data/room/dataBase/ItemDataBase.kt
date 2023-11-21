package ru.stan.starswars.data.room.dataBase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.stan.starswars.data.room.dao.ItemDao
import ru.stan.starswars.data.room.entity.ItemDbModel

@Database(version = 1, entities = [ItemDbModel::class], exportSchema = false)
abstract class ItemDataBase : RoomDatabase() {

    abstract fun dao(): ItemDao

    companion object {
        private val LOCK = Any()
        private var INSTANCE: ItemDataBase? = null
        private const val DB_NAME = "items.db"

        fun getInstance(@ApplicationContext application: Application): ItemDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    ItemDataBase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db

            }
        }
    }


}