package com.trendyol.timelineview

import android.content.Context
import android.graphics.Color
import android.view.View

class TimelineItemViewState(
    private val timelineItem: TimelineItem,
    val dotSize: Float,
    val borderWidth: Float,
    val textSize: Float,
    val lineWidth: Float,
    val fontFamily: String
) {

    fun getOutsideColor(): Int = Color.parseColor(timelineItem.outsideColor)

    fun getInsideColor(): Int = Color.parseColor(timelineItem.insideColor)

    fun getText(): String =
        timelineItem.text.replaceFirst(" ","\n")

    fun getTextColor(): Int = Color.parseColor(timelineItem.textColor)

    fun getLeftLineColor(): Int = Color.parseColor(timelineItem.leftLineColor ?: hexColorWhite)

    fun getRightLineColor(): Int = Color.parseColor(timelineItem.rightLineColor ?: hexColorWhite)

    fun getLeftLineVisibility(): Int =
        if (timelineItem.leftLineColor != null) View.VISIBLE else View.GONE

    fun getRightLineVisibility(): Int =
        if (timelineItem.rightLineColor != null) View.VISIBLE else View.GONE

    fun getOutsideDotSize(): Float = dotSize

    fun getInsideDotSize(): Float = dotSize - (borderWidth * 2)

    fun getShadowDotSize(): Float = dotSize + borderWidth

    fun getItemWidth(): Float =
        dotSize + borderWidth + lineWidth

    companion object {
        private const val hexColorWhite = "#000000"
    }
}