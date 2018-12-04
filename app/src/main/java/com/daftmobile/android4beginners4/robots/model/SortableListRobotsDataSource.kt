package com.daftmobile.android4beginners4.robots.model

class SortableListRobotsDataSource: RobotsDataSource, SortableDataSource {

    private val robots = mutableListOf<Robot>()
    private var isReversedOrder : Boolean = false

    override fun getRobots() = robots.toList()

    override fun addNew(robot: Robot) {
        robots.add(robot)
    }

    override fun isRevertedOrder() = isReversedOrder
    override fun setAscOrder() = setOrder(!isReversedOrder)
    override fun setDescOrder() = setOrder(isReversedOrder)

    private fun setOrder(condition: Boolean) {
        if (condition) return
        // jesli warunek spelniony - nic nie trzeba robic
        // wpp trzeba odwrocic kolejnosc i zrobic porzadek w kolejce
        isReversedOrder = !isReversedOrder
        refreshRobotsList()
    }

    private fun refreshRobotsList() {
        return
    }

}
