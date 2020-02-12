package com.sample.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sample.data.model.User

abstract class BaseUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun insert(user: User)
}