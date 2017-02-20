package com.bibitnomic.linechart

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import kotlinx.android.synthetic.main.marker_view.view.*
import java.util.*

/**
 * Created by putraxor on 20/02/17.
 */

class CustomMarkerView(context: Context, layoutResource: Int, private val models: ArrayList<Model>) : MarkerView(context, layoutResource) {

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    override fun refreshContent(e: Entry, highlight: Highlight) {
        val xIndex = e.xIndex
        val model = models[xIndex]
        tvPrice.text = "Price: " + model.formatedPrice
        tvDate.text = "Date: " + model.fullDate
    }

    override fun getXOffset(f: Float): Int {
        // this will center the marker-view horizontally
        return -(width / 2)
    }

    override fun getYOffset(f: Float): Int {
        // this will cause the marker-view to be above the selected value
        return -height
    }

}