package id.anantyan.chapter2_minichallenge2.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.ViewSizeResolver
import coil.transform.RoundedCornersTransformation
import id.anantyan.chapter2_minichallenge2.R
import id.anantyan.chapter2_minichallenge2.databinding.ListItemComponent4Binding
import id.anantyan.chapter2_minichallenge2.model.DataComponent4

class Component4Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class viewHolder(private val binding: ListItemComponent4Binding) :
        RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("SetTextI18n")
            fun bind(item: DataComponent4) {
                binding.imgView.load("https://i.ibb.co/zJHYGBP/binarlogo.jpg") {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_image_24)
                    transformations(RoundedCornersTransformation(0f))
                    size(ViewSizeResolver(binding.imgView))
                }
                binding.txtTitle.text = item.title
                binding.txtOpened.text = item.opened
                binding.txtRating.text = "${item.rating}"
                binding.txtReviews.text = "(${item.reviews} Reviews)"
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(
            ListItemComponent4Binding.inflate(
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
    private val diffCallback = object : DiffUtil.ItemCallback<DataComponent4>() {
        override fun areItemsTheSame(oldItem: DataComponent4, newItem: DataComponent4): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: DataComponent4, newItem: DataComponent4): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)
}