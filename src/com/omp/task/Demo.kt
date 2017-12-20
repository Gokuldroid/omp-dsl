package com.omp.task

import java.io.File

/**
 * Created by gokul-4192.
 */
object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
//        var pre:String? = null
//        var priority = 1
//        File("D:\\newval\\dsl-bug\\O365 Manager Plus\\conf\\o365\\management\\O365ComponentDefaultValues.xml").forEachLine {
//            if(it.contains("O365DropdownRadioMenuVals").not()){
//                println(it)
//            }else{
//                val currentCom = it.substring(it.indexOf("O365Components:COMPONENT_ID:"),it.indexOf("\"",it.indexOf("O365Components:COMPONENT_ID:")));
//                if(pre == null){
//                    pre = it.substring(it.indexOf("O365Components:COMPONENT_ID:"),it.indexOf("\"",it.indexOf("O365Components:COMPONENT_ID:")))
//                }
//                if(currentCom != pre){
//                    priority = 1
//                    pre = currentCom
//                }else{
//                    priority += 1
//                }
//                println(it.replace("/>","PRIORITY=\"$priority\"/>"))
//            }
//        }

        val list = ArrayList<String>()
        for (dem in  0..1000){
            list.add("demo"+dem);
        }

        for (s in list) {
            list.remove(s)
        }
    }
}
