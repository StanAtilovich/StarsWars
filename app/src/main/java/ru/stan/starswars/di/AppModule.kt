package ru.stan.starswars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.stan.starswars.App
import ru.stan.starswars.data.room.dao.ItemDao

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesItemsDao(): ItemDao {
        return App.INSTANCE.db.dao()
    }
}