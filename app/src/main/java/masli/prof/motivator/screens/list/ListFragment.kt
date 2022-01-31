package masli.prof.motivator.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import masli.prof.motivator.APP
import masli.prof.motivator.R
import masli.prof.motivator.adapters.ListRecyclerAdapter
import masli.prof.motivator.databinding.FragmentListBinding
import masli.prof.motivator.sharedpreferences.SharedPreferences

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.initDatabase()
        val adapter = ListRecyclerAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.getAllTasks().observe(viewLifecycleOwner) {list ->
            adapter.setList(list)
        }

        binding.toolbarMain.tvScore.text = SharedPreferences.getScore().toString()

        binding.addFab.setOnClickListener {
            APP.navController.navigate(R.id.action_listFragment_to_addTaskFragment)
        }
    }

}