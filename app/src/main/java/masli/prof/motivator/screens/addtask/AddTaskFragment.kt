package masli.prof.motivator.screens.addtask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import masli.prof.motivator.APP
import masli.prof.motivator.R
import masli.prof.motivator.databinding.FragmentAddTaskBinding
import masli.prof.motivator.models.TaskModel


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private var difficulty = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)

        binding.addBtn.setOnClickListener {
            val title = binding.titleEd.text.toString()
            val task = binding.taskEd.text.toString()
            if (title.isEmpty() || task.isEmpty()) {
                Toast.makeText(context, getString(R.string.warning), Toast.LENGTH_LONG).show()
            } else {
                viewModel.insert(TaskModel(title = title, task = task, difficulty = difficulty)) {}
                APP.navController.navigate(R.id.action_addTaskFragment_to_listFragment)
            }
        }

        binding.rgDifficulty.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.rb_easy -> {difficulty = 1}
                R.id.rb_medium -> {difficulty = 2}
                R.id.rb_hard -> {difficulty = 3}
            }
        }
    }

}