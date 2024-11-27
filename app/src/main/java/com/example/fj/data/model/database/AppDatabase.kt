package com.example.fj.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fj.data.model.ServiceEntity
import com.example.fj.data.model.dao.ServiceDao


@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
}