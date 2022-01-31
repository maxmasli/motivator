package masli.prof.motivator.db.repository

import androidx.lifecycle.LiveData
import masli.prof.motivator.models.TaskModel

interface TaskRepository {
    val allTasks: LiveData<List<TaskModel>>
    suspend fun insertTask(taskModel: TaskModel, onSuccess:() -> Unit)
    suspend fun deleteTask(taskModel: TaskModel, onSuccess:() -> Unit)
}