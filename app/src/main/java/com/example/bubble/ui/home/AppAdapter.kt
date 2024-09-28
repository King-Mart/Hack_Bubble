package com.example.bubble.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bubble.R
import com.example.bubble.databinding.ListItemAppBinding

class AppAdapter(private val appList: List<AppInfo>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(val binding: ListItemAppBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ListItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val appInfo = appList[position]
        holder.binding.appIcon.setImageResource(appInfo.appIcon)  // Set app icon
        holder.binding.appName.text = appInfo.appName  // Set app name
        holder.binding.timeSpent.text = appInfo.timeSpentString  // Set time spent
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}
