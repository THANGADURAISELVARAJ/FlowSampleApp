package com.alvin.flowsample.db.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvin.flowsample.network.models.post.BasePostModelItem

@Database(entities = [BasePostModelItem::class], version = 1)
abstract class AppDatabase :RoomDatabase() {

    abstract fun appDao(): AppDao
}