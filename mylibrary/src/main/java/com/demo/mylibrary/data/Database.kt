package com.demo.mylibrary.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = arrayOf(Record::class, Word::class), version = 1)
abstract class Database : RoomDatabase() {

    abstract fun recordDao() : RecordDao

    companion object {
        var instant : Database? = null
        fun getInstant(context: Context) : Database? {
            if (instant == null) {
                instant = Room.databaseBuilder(
                    context, Database::class.java, "game.db"
                ).build()
            }
            return instant
        }
    }
}