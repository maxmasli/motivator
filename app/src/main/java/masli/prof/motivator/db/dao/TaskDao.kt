package masli.prof.motivator.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import masli.prof.motivator.models.TaskModel

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskModel: TaskModel)

    @Delete
    suspend fun delete(taskModel: TaskModel)

    @Query("SELECT * from task_table")
    fun getAllTasks(): LiveData<List<TaskModel>>
}