package com.alvin.flowsample.db.roomDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvin.flowsample.network.models.post.BasePostModelItem
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM post")
    fun getAllRestaurants(): Flow<List<BasePostModelItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurants: List<BasePostModelItem>)

    @Query("DELETE FROM post")
    suspend fun deleteAllRestaurants()
}