package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.daftmobile.android4beginners4.robots.viewmodel.ExternalSourceRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.LiveDataRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel
import kotlinx.android.synthetic.main.activity_robots.*

class RobotsActivity : AppCompatActivity() {
    private lateinit var viewModel: RobotsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robots)

        viewModel = ViewModelProviders.of(this).get(ExternalSourceRobotsViewModel::class.java)
        viewModel.getRobotList().observe(this, Observer {
            robotTextView.text = it
        })

        addRobotFab.setOnClickListener {
            addNewItem()
        }
    }

    private fun addNewItem() {
        viewModel.addRobot()
    }
}
