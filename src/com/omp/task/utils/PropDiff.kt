package com.omp.task.utils

import java.io.File
import java.util.*

/**
 * Created by Gokul.
 */

fun main(args: Array<String>) {
    val prop = Properties()
    prop.load(File("D:\\omp_git\\o365plus\\product_package\\resources\\o365\\server\\common\\ApplicationResources_en_US.properties").inputStream())

    val propNew = Properties()
    propNew.load(File("E:\\intellij\\omp-dsl\\ApplicationResources_server_ja_JP.properties").inputStream())

    val newProps = Properties()

    prop.forEach { key, value ->
        if (prop.getProperty(key.toString()).equals(propNew.getProperty(key.toString()))) {
            newProps[key] = value
        }
    }

    println("" + prop.size + "  " + propNew.size)

    newProps.forEach { t, u ->
        println(t as String + "=" + u)
    }
}