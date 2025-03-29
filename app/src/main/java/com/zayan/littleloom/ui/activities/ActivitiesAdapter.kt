package com.zayan.littleloom.ui.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.databinding.ItemActivityBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Enum for activity categories
enum class ActivityCategory {
    ACHIEVEMENT, MEDICAL, HEALTH, SPOT_CHECK
}

// Data class for Activity
data class Activity(
    val id: String,
    val title: String,
    val category: ActivityCategory,
    val roomName: String,
    val timestamp: Long
)

class ActivitiesAdapter(
    private var activities: List<Activity>,
    private val onItemClick: ((Activity) -> Unit)? = null
) : RecyclerView.Adapter<ActivitiesAdapter.ActivityViewHolder>() {

    inner class ActivityViewHolder(
        private val binding: ItemActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())

        fun bind(activity: Activity) {
            binding.apply {
                tvActivityTitle.text = activity.title
                tvActivityCategory.text = activity.category.name.replace("_", " ").capitalize()
                tvRoomName.text = activity.roomName
                tvTimestamp.text = timeFormat.format(Date(activity.timestamp))

                root.setOnClickListener {
                    onItemClick?.invoke(activity)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ItemActivityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.bind(activities[position])
    }

    override fun getItemCount(): Int = activities.size

    fun updateActivities(newActivities: List<Activity>) {
        activities = newActivities
        notifyDataSetChanged()
    }
}