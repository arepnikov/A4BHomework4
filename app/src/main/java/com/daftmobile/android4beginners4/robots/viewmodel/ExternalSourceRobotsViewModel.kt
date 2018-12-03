package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners4.robots.model.ListRobotsDataSource

class ExternalSourceRobotsViewModel(
        private val robotDataSource: ListRobotsDataSource = ListRobotsDataSource()
) : ViewModel(), RobotsViewModel {

    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()

    override fun getRobotList(): LiveData<String> = mutableLiveData

    override fun addRobot() {
        robotDataSource.addNew()
        mutableLiveData.value = robotDataSource.getRobots().toString()
    }
}
