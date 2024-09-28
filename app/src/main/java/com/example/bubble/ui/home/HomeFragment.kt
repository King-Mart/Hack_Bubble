package com.example.bubble.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bubble.R
import com.example.bubble.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var screenTime: Int = 0  // Variable to hold the number displayed

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fun parseTimeToSeconds(timeString: String): Int {
            // Split the time string by ":" (hours:minutes:seconds)
            val parts = timeString.split(":")

            // Convert hours, minutes, and seconds to integers
            val hours = parts[0].toInt()    // First part is hours
            val minutes = parts[1].toInt()  // Second part is minutes
            val seconds = parts[2].toInt()  // Third part is seconds

            // Convert the entire time to seconds
            return (hours * 3600) + (minutes * 60) + seconds
        }
        fun convertSecondsToTimeString(totalSeconds: Int): String {
            val hours = totalSeconds / 3600        // Calculate the number of hours
            val minutes = (totalSeconds % 3600) / 60  // Calculate the number of minutes (remainder of hours / 60)
            val seconds = totalSeconds % 60        // Remaining seconds after calculating hours and minutes

            // Return the formatted time string as "xxhxxmxxs"
            return String.format("%02dh%02dm%02ds", hours, minutes, seconds)

        }
        fun timeHMS(time : String):String{
            return convertSecondsToTimeString(parseTimeToSeconds(time))
        }


        // Dummy app data with time in hours:minutes:seconds format
        val appList = listOf(
            AppInfo(R.drawable.ic_launcher_foreground, "App 1", convertSecondsToTimeString(parseTimeToSeconds("12:30:02")), parseTimeToSeconds("12:30:02")),
            AppInfo(R.drawable.ic_launcher_foreground, "App 2", convertSecondsToTimeString(parseTimeToSeconds("103:09:45")), parseTimeToSeconds("103:09:45")),
            AppInfo(R.drawable.ic_launcher_foreground, "App 3", convertSecondsToTimeString(parseTimeToSeconds("00:45:10")), parseTimeToSeconds("00:45:10")),
            AppInfo(R.drawable.ic_launcher_foreground, "App 4", convertSecondsToTimeString(parseTimeToSeconds("03:15:00")), parseTimeToSeconds("03:15:00")),
            AppInfo(R.drawable.ic_launcher_foreground, "App 5", convertSecondsToTimeString(parseTimeToSeconds("30:00:00")), parseTimeToSeconds("30:00:00"))
        )

        // Sort the appList by timeSpentInSeconds in descending order
        val sortedAppList = appList.sortedByDescending { it.timeSpentInMinutes }

        // Set up RecyclerView
        binding.appRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.appRecyclerView.adapter = AppAdapter(sortedAppList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}