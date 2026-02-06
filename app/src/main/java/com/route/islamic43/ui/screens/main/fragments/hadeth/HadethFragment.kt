package com.route.islamic43.ui.screens.main.fragments.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy
import com.route.islamic43.R
import com.route.islamic43.ui.model.HadethDM
import com.route.islamic43.ui.screens.hadeth_details.HadethDetailsActivity

class HadethFragment : Fragment() {

    var ahadeth: MutableList<HadethDM> = emptyList<HadethDM>().toMutableList()
    lateinit var hadethAdapter: HadethAdapter
    lateinit var hadethRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readAhadethFile()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        hadethRecyclerView = view!!.findViewById(R.id.hadethRecyclerView)
        hadethAdapter = HadethAdapter(ahadeth) { hadeth ->

            startActivity(Intent(activity, HadethDetailsActivity::class.java).apply {
                putExtra(HadethDetailsActivity.HADETH_KEY, hadeth)
            })
        }
        hadethRecyclerView.adapter = hadethAdapter
        val layoutManager = CarouselLayoutManager(HeroCarouselStrategy())
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        hadethRecyclerView.layoutManager = layoutManager
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(hadethRecyclerView)
    }

    fun readAhadethFile() {
        val inputStream = activity!!.assets.open("ahadeth.txt")
        var title = ""
        var content = ""
        inputStream.reader().forEachLine {
            if (title.isEmpty()) {
                title = it
            } else {
                if (it.equals("#")) {
                    ahadeth.add(HadethDM(title, content))
                    title = ""
                    content = ""
                    return@forEachLine
                }
                content += it
            }
        }
        ahadeth.add(HadethDM(title, content))
        println(ahadeth)
    }
}