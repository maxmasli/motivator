package masli.prof.motivator.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_table")
class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var title: String = "",

    @ColumnInfo
    var task: String = "",

    @ColumnInfo
    var difficulty: Int = 1
    ) : Serializable
