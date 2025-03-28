package com.zayan.littleloom.ui.messages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zayan.littleloom.databinding.ItemMessageBinding

// Data class to represent a message
data class Message(
    val id: String,
    val senderName: String,
    val lastMessage: String,
    val timestamp: Long,
    val isRead: Boolean = false
)

class MessagesAdapter(
    private var messages: List<Message>,
    private val onItemClick: ((Message) -> Unit)? = null
) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {

    // ViewHolder class to bind message data to view
    inner class MessageViewHolder(
        private val binding: ItemMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            binding.tvSenderName.text = message.senderName
            binding.tvLastMessage.text = message.lastMessage

            // Change background or add visual indicator for unread messages
            binding.rootLayout.alpha = if (message.isRead) 1.0f else 1.2f

            // Set click listener
            binding.root.setOnClickListener {
                onItemClick?.invoke(message)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size

    // Method to update messages list
    fun updateMessages(newMessages: List<Message>) {
        messages = newMessages
        notifyDataSetChanged()
    }
}