package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    val node = Node("LITIGATION_HOLD_CHANGES") {
        styleClass = "gsection"
        node {
            styleClass = "gspan_2_of_4 gcolumn line line-right o365-mb-15"
            node {
                styleClass = "o365-ml-40 o365-mb-15"
                label = "litigation_hold"

            }
            node {
                styleClass = "o365-ml-60 o365-pr-20"
                node {
                    styleClass = "form-horizontal align-right o365-make-relative"
                    node {
                        styleClass = "form-group"
                        node {
                            emberComponent = EmberComponent.RADIO_GROUP
                            componetId = 1
                        }
                    }
                    node {
                        styleClass = "form-group o365-make-relative"
                        node {
                            emberComponent = EmberComponent.REP_POPUP
                            componetId = 35
                        }
                    }
                    node {
                        styleClass = "form-group o365-make-relative o365-mb-5"
                        node {
                            emberComponent = EmberComponent.TEXT
                        }
                    }
                }
            }
        }
    }
}