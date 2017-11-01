package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val node = Node("ADDRESS_BOOK_POLICY_CHANGES") {
        styleClass = "row"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "static-container-sm center-block"
                node {
                    styleClass = "form-horizontal align-right"
                    node {
                        styleClass = "form-group o365-mb-20"
                        node {
                            htmlTag = "label"
                            styleClass = "col-md-4 control-label"

                            node {
                                htmlTag = "span"
                                styleClass = "o365-nowrap"
                                label = "address_book_policy"
                            }
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                node {
                                    componetId = "ADDRESS_BOOK_POLICY"
                                    emberComponent = EmberComponent.REP_POPUP
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    node.copyToClipBoard()
}