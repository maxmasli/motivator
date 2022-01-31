package masli.prof.motivator.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import masli.prof.motivator.REPOSITORY
import masli.prof.motivator.db.TaskDatabase
import masli.prof.motivator.db.repository.TaskRealization
import masli.prof.motivator.models.TaskModel

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDatabase() {
        val daoTask = TaskDatabase.getInstance(context).getTaskDao()
        REPOSITORY = TaskRealization(daoTask)
    }

    fun getAllTasks(): LiveData<List<TaskModel>> {
        return REPOSITORY.allTasks
    }

}