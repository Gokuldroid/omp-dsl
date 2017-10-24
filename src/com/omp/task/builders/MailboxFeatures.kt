package com.omp.task.builders

import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val root = Node("MAILBOX_FEATURES") {
        node {
            node {

            }
            node {

            }
        }
    }
    println(root.toString())
}