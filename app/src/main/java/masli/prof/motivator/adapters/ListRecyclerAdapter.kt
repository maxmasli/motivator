package masli.prof.motivator.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import masli.prof.motivator.APP
import masli.prof.motivator.R
import masli.prof.motivator.TASK_KEY
import masli.prof.motivator.models.TaskModel

class ListRecyclerAdapter : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private var list = emptyList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<TaskModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: ListViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(TASK_KEY, list[holder.adapterPosition])
            APP.navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(taskModel: TaskModel) {
            itemView.findViewById<AppCompatTextView>(R.id.task_tv).text = taskModel.task
            itemView.findViewById<AppCompatTextView>(R.id.title_tv).text = taskModel.title
        }
    }
}