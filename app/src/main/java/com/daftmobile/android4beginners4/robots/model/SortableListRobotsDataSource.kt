package com.daftmobile.android4beginners4.robots.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.daftmobile.android4beginners4.robots.showMsgDialog
import java.util.Comparator

class SortableListRobotsDataSource: RobotsDataSource, SortableDataSource {

    private val robots = mutableListOf<Robot>()
    private var isReversedOrder : Boolean = false

    override fun getRobots() = robots.toList()

    override fun addNew(robot: Robot) {
        robots.add(robot)
        refreshRobotsList()
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
        if (isReversedOrder)
            robots.sortWith(Comparator { o1, o2 -> o2.name.compareTo(o1.name) })
        else
            robots.sortWith(RobotComparator())
    }

    // chcialem to rozwiazac przy pomocy .reversed(), ale android-studio krzyczalo, z tego co
    // zrozumialem to chodzi o wersje SDK, ze w starszych nie ma wsparcia tej metody i przez
    // to trzeba jakos sie zabespieczac ze tylko od nowej wersji uzywac tej metody a w pozostalych
    // przypadkach cos innego.
    //
    // to rozwiazanie nie za bardzo mi sie spodobalo, a innego po dluzszych poszukiwaniach nie
    // wymyslilem / nie znalazlem, plus termin juz jutro wiec zapytac tez juz nie zdaze...
    //
    // Prosil bym o jakis komentarz jak trzeba bylo to rozwiazac / naprawic, lub czego nie
    // zrozumialem.
    //
    //
    //    private fun refreshRobotsList() {
    //        val comparator =
    //            if (isReversedOrder)
    //                RobotComparator().reversed()
    //            else
    //                RobotComparator()
    //
    //        robots.sortWith(comparator)
    //    }

}
