package com.sample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.data.model.Repo

@Dao
interface ReposDao {

    @Query("SELECT * FROM Repo")
    suspend fun getRepos(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repos: List<Repo>)
}