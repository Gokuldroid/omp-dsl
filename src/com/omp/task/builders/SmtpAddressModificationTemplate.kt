package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by Gokul.
 */
fun main(args: Array<String>) {
    Node("SMTP_ADDRESS_MODIFICATION_TEMPLATE"){
        styleClass = "row"
        node("col-md-12") {
            node ("static-container-sm center-block") {
                node("form-horizontal align-right"){
                    node("form-group o365-mb-5") {
                        labelNode ("col-md-4 control-label o365-pt-0") {
                            label = "proxy_address"
                        }
                        node("col-md-7") {
                            node {
                                componetId = "SMTP_ADDRESSES"
                                emberComponent = EmberComponent.SMTP_ADDRESSES
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml {

    }
}