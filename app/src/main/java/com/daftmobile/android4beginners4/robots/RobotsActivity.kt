package com.daftmobile.android4beginners4.robots

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.daftmobile.android4beginners4.robots.viewmodel.ExternalSourceRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.LiveDataRobotsViewModel
import com.daftmobile.android4beginners4.robots.viewmodel.RobotsViewModel
import kotlinx.android.synthetic.main.activity_robots.*

class RobotsActivity : AppCompatActivity() {
    private lateinit var viewModel: ExternalSourceRobotsViewModel

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.robot_sort_menu, menu)

        val checkedItemId =    if (viewModel.isAscOrder())
                                        R.id.robots_order_asc
                                    else
                                        R.id.robots_order_desc

        val checkedItem = menu.findItem((checkedItemId))
        checkedItem.isChecked = true

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.robots_order_asc -> {
                item.isChecked = true
                true
            }
            R.id.robots_order_desc -> {
                item.isChecked = true
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun addNewItem() {
        viewModel.addRobot()
    }
}
