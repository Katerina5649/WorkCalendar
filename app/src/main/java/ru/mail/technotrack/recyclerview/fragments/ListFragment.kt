package ru.mail.technotrack.recyclerview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import ru.mail.technotrack.recyclerview.*
import ru.mail.technotrack.recyclerview.adapters.EnrollmentsAdapter
import ru.mail.technotrack.recyclerview.adapters.PageAdapter

class ListFragment : Fragment() {
    companion object {
        private const val STYLE_KEY = "STYLE_KEY"

        fun createListFragment(style : Int) : Fragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putInt(ListFragment.STYLE_KEY, style)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var router : Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        router = Router(requireActivity(), R.id.fragment_container)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.list, container, false)
        val recycler : RecyclerView = layout.findViewById(R.id.list)

        recycler.setHasFixedSize(true)

        val style = arguments?.getInt(STYLE_KEY) ?: LIST

        when(style) {
            //TODO DIFFERENT TABLES
            TABLE -> createTableList(recycler)
        }

        return layout
    }


    private fun createTableList(recycler: RecyclerView) {
        recycler.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.HORIZONTAL,
            false
        )

        PagerSnapHelper().attachToRecyclerView(recycler)
        recycler.adapter = EnrollmentsAdapter()
    }
}