package com.sample.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.sample.data.model.User
import java.util.*

@Dao
abstract class UserDao : BaseUserDao() {

    @Query("SELECT * FROM User LIMIT 1")
    abstract suspend fun getUser(): User

    suspend fun save(user: User) {
        insert(user.apply { lastRefreshed = Date() })
    }
}