package ru.mail.technotrack.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mail.technotrack.recyclerview.R
import java.util.*

class EnrollmentsAdapter : RecyclerView.Adapter<EnrollmentsAdapter.EnrollmentsViewHolder>() {
    private val items: List<String>

    init {
        this.items = Arrays.asList("Breaches", "Data Leaks", "Hacker Chatter", "Services Monitored", "xxx", "xxx")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrollmentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.table_layout, parent, false)

//        view.titleTextView.typeface = Typeface.createFromAsset(view.context.assets, "fonts/Montserrat-Regular.ttf")
//        view.countTextView.typeface = Typeface.createFromAsset(view.context.assets, "fonts/Montserrat-Regular.ttf")
//        view.subtextTextView.typeface = Typeface.createFromAsset(view.context.assets, "fonts/Montserrat-Regular.ttf")
//        view.updatedTextView.typeface = Typeface.createFromAsset(view.context.assets, "fonts/Montserrat-Light.ttf")

        return EnrollmentsViewHolder(view)
    }


    override fun onBindViewHolder(holder: EnrollmentsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return 6
    }

    fun getItem(position: Int): String {
        return items[position]
    }

    class EnrollmentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(value: String) {
//            itemView.titleTextView.text = value
        }

    }

}