package com.route.islamic43.ui.screens.hadeth_details

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic43.R
import com.route.islamic43.ui.model.HadethDM

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var nameAr: TextView
    lateinit var nameEn: TextView
    lateinit var backArrow: ImageView
    lateinit var suraContentTextView: TextView
    lateinit var hadeth: HadethDM

    companion object {
        const val HADETH_KEY = "hadeth"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        initViews()
        initListeners()

    }

    private fun initListeners() {
        backArrow.setOnClickListener {
            finish()
        }
    }

    private fun initViews() {
        hadeth =
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getSerializableExtra(
                HADETH_KEY,
                HadethDM::class.java
            ) else intent.getSerializableExtra(HADETH_KEY) as HadethDM)!!

        nameAr = findViewById(R.id.suraNameAr)
        nameEn = findViewById(R.id.suraNameEn)
        backArrow = findViewById(R.id.icBackArrow)
        suraContentTextView = findViewById(R.id.suraContent)
        nameAr.text = hadeth.title
        suraContentTextView.text = hadeth.content

    }
}