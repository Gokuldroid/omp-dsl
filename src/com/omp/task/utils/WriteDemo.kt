package com.omp.task.utils

import java.io.File

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    for (i in 0..100){
        Write().start()
    }
}


class Write : Thread(){
    override fun run() {
        super.run()
        File("D:\\newval\\i18n two\\O365 Manager Plus\\logs\\serverout0.txt").appendText(File("D:\\newval\\i18n two\\O365 Manager Plus\\logs\\serverout0.txt").readLines().toString())
    }
}