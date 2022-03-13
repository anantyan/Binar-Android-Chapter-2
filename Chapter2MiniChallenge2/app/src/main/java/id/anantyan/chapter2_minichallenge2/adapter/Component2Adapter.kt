package id.anantyan.chapter2_minichallenge2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.anantyan.chapter2_minichallenge2.databinding.ListItemComponent2Binding
import id.anantyan.chapter2_minichallenge2.model.DataComponent2

class Component2Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class viewHolder(private val binding: ListItemComponent2Binding) :
        RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("SetTextI18n")
            fun bind(item: DataComponent2) {
                binding.txtTitle.text = item.title
                binding.txtLocation.text = item.location
                binding.txtPrice.text = "$ ${item.price}"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(
            ListItemComponent2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as viewHolder
        val item = differ.currentList[position]
        item?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    /**
     * untuk setup diffUtil recycler view
     * guna meningkatkan performa
     */
    private val diffCallback = object : DiffUtil.ItemCallback<DataComponent2>() {
        override fun areItemsTheSame(oldItem: DataComponent2, newItem: DataComponent2): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: DataComponent2, newItem: DataComponent2): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)
}