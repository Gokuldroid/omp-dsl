package com.omp.task

import com.google.common.base.Stopwatch
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by gokul-4192.
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {


        val stopwatch = Stopwatch.createStarted()
        for (i in 0..9999) {
            val map = HashMap<String, String>()
            map.put("DE", "HELLO")
            map.clear()
        }
        println(stopwatch.elapsed(TimeUnit.MILLISECONDS))
    }
}
