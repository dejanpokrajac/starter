package com.sample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sample.data.local.converter.Converters
import com.sample.data.local.dao.ReposDao
import com.sample.data.local.dao.UserDao
import com.sample.data.model.Repo
import com.sample.data.model.User

@Database(entities = [User::class, Repo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun reposDao(): ReposDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "App.db")
                .build()
    }
}