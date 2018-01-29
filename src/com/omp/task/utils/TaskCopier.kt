package com.omp.task.utils

import java.io.File

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
//    copy("SHARED_MBX_FEATURES_SETTINGS","MAILBOX_FEATURES_SETTINGS")
//    copy("SHARED_MBX_AUDIT_SETTINGS","MAILBOX_AUDIT_SETTINGS")
//    copy("SHARED_MBX_LITIGATION_HOLD_CHANGES","LITIGATION_HOLD_CHANGES")
//    //copy("HIDE_SHARED_MBX_FROM_ADDRESSLIST","HIDE_FROM_ADDRESSLIST")
//    //copy("UNHIDE_SHARED_MBX_FROM_ADDRESSLIST","UNHIDE_FROM_ADDRESSLIST")
//    copy("SHARED_MBX_PERMISSION_CHANGES","MAILBOX_PERMISSION_CHANGES")
//    copy("SHARED_MBX_ADDRESS_BOOK_POLICY_CHANGES","ADDRESS_BOOK_POLICY_CHANGES")
//    copy("SHARED_MBX_AUTO_REPLY_CONFIGURATION","MAILBOX_AUTO_REPLY_CONFIGURATION")
//    copy("SHARED_MBX_FORWARD_TO","MAILBOX_FORWARD_TO")
//    copy("ENABLE_EXCHANGE_SHARED_MBX","ENABLE_EXCHANGE_MAILBOX")
//    copy("DISABLE_EXCHANGE_SHARED_MBX","DISABLE_EXCHANGE_MAILBOX")
//    copy("SHARED_MBX_MAILTIP_SETTINGS","MAILTIP_SETTINGS")
//    copy("SHARED_MBX_CONVERSION","MAILBOX_CONVERSION")
//    copy("SHARED_MBX_MESSAGE_SIZE_RESTRICTION","MAILBOX_MESSAGE_SIZE_RESTRICTION")
//    copy("SHARED_MBX_RETENTION_POLICY_CHANGES","MAILBOX_RETENTION_POLICY_CHANGES")
        copy("SHARED_MBX_DELEGATION","MAILBOX_DELEGATION")
}

fun copy(copy: String, orginal: String){
    copyTask(copy, orginal, "D:\\newval\\ui revamp\\team val\\O365 Manager Plus\\conf\\o365\\management\\O365LayoutComponentGroup.xml")
    copyTask(copy, orginal, "D:\\newval\\ui revamp\\team val\\O365 Manager Plus\\conf\\o365\\management\\O365LayoutComponentRules.xml")
}

fun copyTask(copy: String, orginal: String, file: String) {
    var copyTemp = "O365MgmtTasks:TASK_ID:" + copy
    var orginalTemp = "O365MgmtTasks:TASK_ID:" + orginal
    val result = ArrayList<String>()
    val newentires = ArrayList<String>()
    File(file).forEachLine {
        if (it.contains(copy).not()) {
            if (it.contains(orginal)) {
                newentires.add(it.replace(orginal, copy))
            }
            result.add(it)
        }
    }
    result.addAll(newentires)
    File(file).writeText(result.joinToString(separator = "\n"))
}
