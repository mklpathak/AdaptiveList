package co.mukulpathak.adaptivelist

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback : DiffUtil.ItemCallback<BaseModel>() {
    override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
        return oldItem===newItem
    }
    override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
        return oldItem == newItem
    }
}
