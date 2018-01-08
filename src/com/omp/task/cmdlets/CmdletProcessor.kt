package com.omp.task.cmdlets

import com.omp.task.utils.toClipBoard
import java.io.File

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    var cmdlet = File("E:\\intellij\\omp-dsl\\src\\com\\omp\\task\\cmdlets\\GroupAcceptMAilFrom.ps1").readLines().joinToString(separator = "\n")
    var map: HashMap<String, String> = HashMap()
    with(map) {
        putString("groupacceptmailfrom","Internal");
        putString("identity", "rakesh")
        put("restrictusersui","\$true")
        put("groupsandusers","rakesh,o365team")
        put("groupacceptmailfromui","\$true")
    }

    map.forEach({ key, value ->
        run {
            cmdlet = cmdlet.replace("%$key%", value)
        }
    })
    cmdlet.toClipBoard()
}

fun HashMap<String, String>.putString(key: String, value: String) {
    put(key, "'$value'")
}

//message size restriction
fun dummy(){
    var map: HashMap<String, String> = HashMap()
    with(map) {
        put("modifymessagesendsize", "\$true")
        put("usedefaultsendsize", "\$false")
        put("modifymessagereceivesize", "\$true")
        put("usedefaultreceivesize", "\$false")
        put("modifymessagerestrictions", "\$true")
        put("acceptfromallsenders", "\$false")
        put("rejectfromnosenders", "\$false")
        put("maxsendsize", "20000")
        put("maxreceivesize", "30000")
        putString("acceptmessagesfrom", "o365team")
        putString("rejectmessagesfrom", "a321@zohocorpadmgrplus.mail.onmicrosoft.com")
        putString("identity", "rakesh")
    }
}