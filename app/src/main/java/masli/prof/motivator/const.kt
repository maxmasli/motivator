package masli.prof.motivator

import masli.prof.motivator.db.repository.TaskRepository

const val TASK_KEY = "task"
const val APP_PREFERENCES  = "settings"
const val APP_PREFERENCES_SCORE = "score"

lateinit var APP: MainActivity
lateinit var REPOSITORY: TaskRepository