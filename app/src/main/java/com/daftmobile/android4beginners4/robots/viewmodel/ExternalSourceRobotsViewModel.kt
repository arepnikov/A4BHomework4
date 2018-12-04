package com.daftmobile.android4beginners4.robots.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.daftmobile.android4beginners4.robots.model.ListRobotsDataSource
import com.daftmobile.android4beginners4.robots.model.SortableListRobotsDataSource

class ExternalSourceRobotsViewModel(
        private val robotDataSource: SortableListRobotsDataSource = SortableListRobotsDataSource()
) : ViewModel(), RobotsViewModel, SortableViewModel {

    override fun isAscOrder() = !robotDataSource.isRevertedOrder()
    override fun setAscOrder() = robotDataSource.setAscOrder()
    override fun setDescOrder() = robotDataSource.setDescOrder()

    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()

    override fun getRobotList(): LiveData<String> = mutableLiveData

    override fun addRobot() {
        robotDataSource.addNew()
        mutableLiveData.value = robotDataSource.getRobots().joinToString("\n")
    }
}
