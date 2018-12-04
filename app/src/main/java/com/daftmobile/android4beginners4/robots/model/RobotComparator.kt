package com.daftmobile.android4beginners4.robots.model

class RobotComparator: Comparator<Robot> {
    override fun compare(o1: Robot, o2: Robot): Int {
        val leftRobotName = o1.name
        val rightRobotName = o2.name

        return leftRobotName.compareTo(rightRobotName)
    }

}