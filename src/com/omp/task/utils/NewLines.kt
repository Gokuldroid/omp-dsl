package com.omp.task.utils

import java.io.File

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    var old = File("D:\\scripts\\branch.txt").readLines().toHashSet()
    var files = File("D:\\scripts\\head.txt").readLines().filter {
        return@filter old.contains(it).not()
    }.toString()
    println(files)
}