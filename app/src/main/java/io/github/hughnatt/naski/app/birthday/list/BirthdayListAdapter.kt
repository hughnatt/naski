package io.github.hughnatt.naski.app.birthday.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.hughnatt.core.entity.Birthday
import io.github.hughnatt.naski.databinding.BirthdayListRecyclerViewItemBinding

interface BirthdayListItemListener {}

class BirthdayListAdapter(
    var dataSet: List<Birthday>,
    var listener: BirthdayListItemListener?,
): RecyclerView.Adapter<BirthdayListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: BirthdayListRecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BirthdayListRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val birthday = dataSet[position]
        with (holder.binding) {
            itemName.text = birthday.name
            itemDate.text = birthday.date.toString()
        }
    }

    override fun getItemCount(): Int = dataSet.size
}