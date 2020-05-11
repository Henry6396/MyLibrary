package com.demo.mylibrary.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Record::class, Word::class), version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun recordDao() : RecordDao

    companion object {
        private var instant : MyDatabase? = null
        fun getInstant(context: Context) : MyDatabase? {
            if (instant == null) {
                instant = Room.databaseBuilder(
                    context, MyDatabase::class.java, "game.db"
                ).build()
            }
            return instant
        }
    }
}