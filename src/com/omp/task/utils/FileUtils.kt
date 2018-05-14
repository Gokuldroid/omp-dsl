package com.omp.task.utils

import java.io.File

/**
 * Created by gokul-4192.
 */

val InstallDir = "D:\\newval\\mgmt ui\\"

fun main(args: Array<String>) {
    val lines = File("D:\\scripts\\new.txt").readLines()
    val old = File("D:\\scripts\\old.txt").readLines()
    old.filter { !lines.contains(it) }.joinToString("\n").toClipBoard()
}