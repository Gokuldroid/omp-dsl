package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("row") {
        node("col-md-6") {
            node("form-horizontal align-right line line-right o365-ml-20") {
                node("form-group") {
                    node("col-md-4 control-label") {
                        label = "retention_policy"
                    }
                    node("col-md-7 o365-valign-top") {
                        node {
                            emberComponent = EmberComponent.REP_POPUP
                            componetId = "RETENTION_POLICY"
                        }
                    }
                }
                node("form-group") {
                    node("col-md-4 control-label") {
                        label = "retention_policy"
                    }
                    node("col-md-7 o365-valign-top") {
                        node {
                            emberComponent = EmberComponent.REP_POPUP
                            componetId = "RETENTION_URL"
                        }
                    }
                }
                node("form-group") {
                    node("col-md-4 control-label") {
                        label = "retention_policy"
                    }
                    node("col-md-7 o365-valign-top") {
                        node {
                            emberComponent = EmberComponent.REP_POPUP
                            componetId = "RETAIN_DELETED_ITEMS_FOR"
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("static-container-sm") {

            }
        }
    }.copyToClipBoard()

}