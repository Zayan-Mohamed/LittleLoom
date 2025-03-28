package com.zayan.littleloom.ui.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.databinding.ItemGoalBinding
import com.zayan.littleloom.databinding.ItemTipBinding

// Goal data class
data class Goal(
    val id: String,
    val title: String,
    var isCompleted: Boolean = false
)

// Tip data class
data class Tip(
    val id: String,
    val title: String,
    val description: String
)

// Goals Adapter
class GoalsAdapter(
    private var goals: List<Goal>,
    private val onGoalCheckedChange: ((Goal, Boolean) -> Unit)? = null
) : RecyclerView.Adapter<GoalsAdapter.GoalViewHolder>() {

    inner class GoalViewHolder(
        private val binding: ItemGoalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(goal: Goal) {
            binding.apply {
                tvGoalTitle.text = goal.title
                checkBoxGoal.isChecked = goal.isCompleted

                checkBoxGoal.setOnCheckedChangeListener { _, isChecked ->
                    goal.isCompleted = isChecked
                    onGoalCheckedChange?.invoke(goal, isChecked)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val binding = ItemGoalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        holder.bind(goals[position])
    }

    override fun getItemCount(): Int = goals.size

    fun updateGoals(newGoals: List<Goal>) {
        goals = newGoals
        notifyDataSetChanged()
    }
}

// Tips Adapter
class TipsAdapter(
    private var tips: List<Tip>
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    inner class TipViewHolder(
        private val binding: ItemTipBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tip: Tip) {
            binding.apply {
                tvTipTitle.text = tip.title
                tvTipDescription.text = tip.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemTipBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount(): Int = tips.size

    fun updateTips(newTips: List<Tip>) {
        tips = newTips
        notifyDataSetChanged()
    }
}