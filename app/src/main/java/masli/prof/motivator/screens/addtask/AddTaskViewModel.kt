package masli.prof.motivator.screens.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import masli.prof.motivator.REPOSITORY
import masli.prof.motivator.models.TaskModel

class AddTaskViewModel : ViewModel() {
    fun insert(taskModel: TaskModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertTask(taskModel, onSuccess)
        }
    }
}