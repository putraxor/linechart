package com.bibitnomic.linechart

import android.util.Log
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by putraxor on 20/02/17.
 */

class Model {
    var id: String = ""
    var product: Int = 0
    var price: Float = 0.toFloat()
    var hdate: Date? = null
    private val defaultDateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val monthYearFormat = SimpleDateFormat("MMM yyyy")
    private val longFormat = SimpleDateFormat("dd MMM yyyy")
    var moneyFormatter = NumberFormat.getCurrencyInstance()

    constructor() {}

    constructor(id: String, product: Int, price: Float, hdate: Date) {
        this.id = id
        this.product = product
        this.price = price
        this.hdate = hdate
    }


    /**
     * Parse model data from string array
     */
    fun parseArray(array: Array<String>) {
        try {
            this.id = array[0]
            this.hdate = defaultDateFormat.parse(array[1])
            this.product = Integer.parseInt(array[2])
            this.price = java.lang.Float.parseFloat(array[3])
        } catch (e: Exception) {
            Log.e(Dataset::class.java.name, "Failed to parse date ${array.joinToString(",")}", e)
        }

    }

    val monthYear: String
        get() = monthYearFormat.format(this.hdate)

    val fullDate: String
        get() = longFormat.format(this.hdate)

    val formatedPrice: String
        get() = moneyFormatter.format(this.price)
}
