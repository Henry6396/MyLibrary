package com.demo.mylibrary.data

import androidx.room.*

@Dao
interface RecordDao {
    // 在coroutines上面執行，必須加上suspend

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 如果有重複資料就更新它
    suspend fun insert(record: Record)

    @Query("select * from record")
    suspend fun getAll() : List<Record>

    @Delete
    suspend fun delete(record: Record)
}