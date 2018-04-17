package com.omp.task.utils

import java.io.File
import java.util.*

/**
 * Created by Gokul.
 */

fun main(args: Array<String>) {
    val prop = Properties()
    prop.load(File("D:\\o365_source\\O365_4116_I18N_BRANCH_TEMP_NEW\\o365\\product_package\\resources\\o365\\old.properties").inputStream())

    val propNew = Properties()
    propNew.load(File("D:\\o365_source\\O365_4116_I18N_BRANCH_TEMP_NEW\\o365\\product_package\\resources\\o365\\new.properties").inputStream())

    val newProps = Properties()

    propNew.forEach { key, value ->
        if (!prop.containsValue(value)) {
            newProps[key] = value
        }
    }

    newProps.forEach { t, u ->
        println(t as String + "=" + u)
    }
}