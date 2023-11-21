package ru.stan.starswars

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.stan.starswars.data.room.dataBase.ItemDataBase

@HiltAndroidApp
class App : Application() {

    lateinit var db: ItemDataBase
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        db = ItemDataBase.getInstance(this)
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}