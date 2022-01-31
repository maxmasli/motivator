package masli.prof.motivator.db.repository

import androidx.lifecycle.LiveData
import masli.prof.motivator.db.dao.TaskDao
import masli.prof.motivator.models.TaskModel

class TaskRealization(private val taskDao: TaskDao) : TaskRepository {
    override val allTasks: LiveData<List<TaskModel>>
        get() = taskDao.getAllTasks()

    override suspend fun insertTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.insert(taskModel)
        onSuccess()
    }

    override suspend fun deleteTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.delete(taskModel)
        onSuccess()
    }
}