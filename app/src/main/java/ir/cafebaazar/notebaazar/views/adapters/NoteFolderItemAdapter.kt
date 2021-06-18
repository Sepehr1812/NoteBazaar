package ir.cafebaazar.notebaazar.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ir.cafebaazar.notebaazar.R
import ir.cafebaazar.notebaazar.data.models.Folder
import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.data.models.NoteFolderItem
import ir.cafebaazar.notebaazar.heipers.DigitHelper
import java.util.*

class NoteFolderItemAdapter(
    private val noteFolderItemList: List<NoteFolderItem>,
    private val onItemClickListener: OnItemClickListener
) :
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

        holder.cardViewItem.setOnClickListener {
            if (item is Note)
                onItemClickListener.onNoteClickListener(item.id ?: -1)
            else onItemClickListener.onFolderClickListener(item.id ?: -1)
        }
    }

    override fun getItemCount(): Int = noteFolderItemList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardViewItem: CardView = itemView.findViewById(R.id.cardViewItem)
        val imageViewItemIcon: ImageView = itemView.findViewById(R.id.imageViewItemIcon)
        val textViewItemTitle: TextView = itemView.findViewById(R.id.textViewItemTitle)
        val textViewItemSubtitle: TextView = itemView.findViewById(R.id.textViewItemSubtitle)
        val imageViewItemMore: ImageView = itemView.findViewById(R.id.imageViewItemMore)
    }

    interface OnItemClickListener {
        fun onNoteClickListener(noteId: Int)
        fun onFolderClickListener(folderId: Int)
    }
}