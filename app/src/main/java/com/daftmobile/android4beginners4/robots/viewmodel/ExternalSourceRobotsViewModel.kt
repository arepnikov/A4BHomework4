package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daftmobile.android4beginners4.robots.model.SortableListRobotsDataSource

class ExternalSourceRobotsViewModel(
        private val robotDataSource: SortableListRobotsDataSource = SortableListRobotsDataSource()
) : ViewModel(), RobotsViewModel, SortableViewModel {

    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()

    override fun getRobotList(): LiveData<String> = mutableLiveData

    override fun addRobot() {
        robotDataSource.addNew()
        updateRobotList()
    }

    override fun isAscOrder() = !robotDataSource.isRevertedOrder()

    override fun setAscOrder() {
        robotDataSource.setAscOrder()
        updateRobotList()
    }

    override fun setDescOrder() {
        robotDataSource.setDescOrder()
        updateRobotList()
    }

    private fun updateRobotList() {
        mutableLiveData.value = robotDataSource.getRobots().joinToString("\n")
    }

}
