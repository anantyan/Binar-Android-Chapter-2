package id.anantyan.chapter2challenge.adapter.gojek

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import id.anantyan.chapter2challenge.R
import id.anantyan.chapter2challenge.databinding.GridViewGojekBinding

class GridAdapter(
    private val itemContext: Context,
    private val listTitle: Array<String>,
    private val listIcon: IntArray
) : ArrayAdapter<GridAdapter.ItemViewHolder>(itemContext, R.layout.grid_view_gojek) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private lateinit var itemBinding: GridViewGojekBinding

    inner class ItemViewHolder {
        var name: TextView? = null
        var icon: ImageView? = null
    }

    override fun getCount(): Int {
        return listTitle.size
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ItemViewHolder
        if (convertView == null) {
            itemBinding = GridViewGojekBinding.inflate(inflater)
            convertView = itemBinding.root
            holder = ItemViewHolder()
            holder.name = itemBinding.tvGridMenuTitle
            holder.icon = itemBinding.ivGridMenuIcon
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemViewHolder
        }
        holder.name!!.text = this.listTitle[position]
        Glide.with(itemContext).load(listIcon[position]).centerInside().into(holder.icon!!)
        return convertView
    }
}