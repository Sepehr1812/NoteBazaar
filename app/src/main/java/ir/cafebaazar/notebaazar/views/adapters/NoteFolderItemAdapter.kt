package ir.cafebaazar.notebaazar.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ir.cafebaazar.notebaazar.R
import ir.cafebaazar.notebaazar.data.models.Folder
import ir.cafebaazar.notebaazar.data.models.NoteFolderItem
import ir.cafebaazar.notebaazar.heipers.DigitHelper
import java.util.*

class NoteFolderItemAdapter(private val noteFolderItemList: List<NoteFolderItem>) :
    RecyclerView.Adapter<NoteFolderItemAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_note_folder_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = noteFolderItemList[position]
        val context = holder.itemView.context

        if (item is Folder) holder.imageViewItemIcon.setImageDrawable(
            ContextCompat.getDrawable(context, R.drawable.ic_folder)
        )

        holder.textViewItemTitle.text = item.title

        holder.textViewItemSubtitle.text = Date().time.minus(item.createTime ?: Date().time)
            .div(24 * 60 * 60 * 1000).let {
                if (it <= 0) context.getString(R.string.today) else context.getString(
                    R.string.days_ago,
                    DigitHelper.convertDigitsToPersian(it.toString())
                )
            }
    }

    override fun getItemCount(): Int = noteFolderItemList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewItemIcon = itemView.findViewById<ImageView>(R.id.imageViewItemIcon)
        val textViewItemTitle = itemView.findViewById<TextView>(R.id.textViewItemTitle)
        val textViewItemSubtitle = itemView.findViewById<TextView>(R.id.textViewItemSubtitle)
        val imageViewItemMore = itemView.findViewById<ImageView>(R.id.imageViewItemMore)
    }
}