package com.example.todoapp.db

import androidx.room.*

/**
 * Created by Manasa on 26,May,2021
 */
@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)

    @Query("DELETE FROM Task WHERE id=:id")
    fun delete(id: Int)

    @Query("SELECT * FROM Task")
    fun getAllTasks(): List<Task>

    @Query("UPDATE Task SET isChecked= :state WHERE Task.id = :id")
    fun changeState( state: Boolean,id:Int)

}