package masli.prof.motivator.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import masli.prof.motivator.APP
import masli.prof.motivator.R
import masli.prof.motivator.TASK_KEY
import masli.prof.motivator.databinding.FragmentDetailBinding
import masli.prof.motivator.models.TaskModel
import masli.prof.motivator.sharedpreferences.SharedPreferences

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var currentTask: TaskModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentTask = arguments?.get(TASK_KEY) as TaskModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitle.text = currentTask?.title
        binding.tvTask.text = currentTask?.task
        binding.tvDifficultyValue.text = when(currentTask?.difficulty) {
            1 -> getString(R.string.easy)
            2 -> getString(R.string.medium)
            3 -> getString(R.string.hard)
            else -> throw IllegalArgumentException()
        }

        binding.fabComplete.setOnClickListener {
            viewModel.addScore(currentTask?.difficulty!!)
            currentTask.let{taskModel ->
                viewModel.delete(taskModel!!){}
            }
            APP.navController.navigate(R.id.action_detailFragment_to_listFragment)
        }

        binding.fabDelete.setOnClickListener {

            viewModel.addScore(-1)
            currentTask.let{taskModel ->
                viewModel.delete(taskModel!!){}
            }
            APP.navController.navigate(R.id.action_detailFragment_to_listFragment)
        }
    }

}