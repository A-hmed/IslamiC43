package com.route.islamic43.ui.screens.main.fragments.quran

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic43.R
import com.route.islamic43.ui.Constants

class QuranFragment : Fragment() {
    lateinit var suraRecyclerView: RecyclerView
    lateinit var suraAdapter: SurasAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("onViewCreated", "$view")
        initSuraRecyclerView(view)
    }

    private fun initSuraRecyclerView(view: View) {
        suraRecyclerView = view.findViewById(R.id.suraRecyclerView)
        suraAdapter = SurasAdapter(Constants.suras)
        suraRecyclerView.adapter = suraAdapter
    }
}