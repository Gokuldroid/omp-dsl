package com.omp.task.utils

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

fun String.toClipBoard() {
    val stringSelection = StringSelection(this)
    val clpbrd = Toolkit.getDefaultToolkit().systemClipboard
    clpbrd.setContents(stringSelection, null)
}

fun StringBuilder.addParam(parm: String, value: Any) {
    this.append(parm).append("=\"").append(value).append("\" ")
}

fun String.newLine(): String {
    return this + "\n"
}

inline fun safeExecute(receiver: () -> Unit) {
    try {
        receiver.invoke()
    }catch (e:Exception){

    }
}