package com.daftmobile.android4beginners4.robots.model

class RobotComparator: Comparator<Robot> {
    override fun compare(o1: Robot, o2: Robot) = o1.name.compareTo(o2.name)
}