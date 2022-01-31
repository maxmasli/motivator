package masli.prof.motivator.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import masli.prof.motivator.REPOSITORY
import masli.prof.motivator.models.TaskModel
import masli.prof.motivator.sharedpreferences.SharedPreferences

class DetailViewModel : ViewModel() {
    fun delete(taskModel: TaskModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteTask(taskModel, onSuccess)
        }
    }

    fun addScore(s: Int) {
        var score = SharedPreferences.getScore() + s
        if (score <= 0) score = 0
        SharedPreferences.setScore(score)
    }
}