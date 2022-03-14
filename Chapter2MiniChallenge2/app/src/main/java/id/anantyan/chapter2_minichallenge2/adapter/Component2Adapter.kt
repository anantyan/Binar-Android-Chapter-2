package id.anantyan.chapter2_minichallenge2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import coil.request.ImageRequest
import coil.size.ViewSizeResolver
import coil.transform.RoundedCornersTransformation
import id.anantyan.chapter2_minichallenge2.R
import id.anantyan.chapter2_minichallenge2.databinding.ListItemComponent2Binding
import id.anantyan.chapter2_minichallenge2.model.DataComponent2

class Component2Adapter(
    private val listener: Component2Callback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<DataComponent2>() {
        override fun areItemsTheSame(oldItem: DataComponent2, newItem: DataComponent2): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: DataComponent2, newItem: DataComponent2): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)

    interface Component2Callback {
        fun onClick(item: DataComponent2, position: Int)
    }

    inner class viewHolder(private val binding: ListItemComponent2Binding) :
        RecyclerView.ViewHolder(binding.root) {

            init {
                itemView.setOnClickListener {
                    listener.onClick(differ.currentList[adapterPosition], adapterPosition)
                }
            }

            @SuppressLint("SetTextI18n")
            fun bind(item: DataComponent2) {
                binding.imgView.load("https://i.ibb.co/zJHYGBP/binarlogo.jpg") {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_image_24)
                    transformations(RoundedCornersTransformation(0f))
                    size(ViewSizeResolver(binding.imgView))
                }
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
}