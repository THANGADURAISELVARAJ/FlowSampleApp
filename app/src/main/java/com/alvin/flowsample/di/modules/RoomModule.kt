package com.alvin.flowsample.di.modules

import android.content.Context
import androidx.room.Room
import com.alvin.flowsample.db.constants.DbNames
import com.alvin.flowsample.db.roomDb.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context): AppDatabase {
        synchronized(this) {
            return Room.databaseBuilder(app, AppDatabase::class.java, DbNames.ROOM_DB_NAME)
                .build()
        }
    }
}