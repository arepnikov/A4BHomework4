package com.daftmobile.android4beginners4.robots.model


interface SortableDataSource {
    fun isRevertedOrder() : Boolean
    fun setAscOrder()
    fun setDescOrder()
}
