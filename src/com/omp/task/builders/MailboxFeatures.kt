package com.omp.task.builders

import com.omp.task.Powerhsell
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    //SHARED_MAILBOX_FEATURES_SETTINGS
    val root = Node("MAILBOX_FEATURES_SETTINGS") {
        styleClass = "row o365-mb-5"
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "form-horizontal align-right line line-right o365-ml-40"

                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "imap"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "IMAP_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "mapi"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "MAPI_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "pop"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "POP_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "ews"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "EWS_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
            }
        }
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "form-horizontal align-right"

                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "owa"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "OWA_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "owa_for_devices"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "OWA_FOR_DEVICES_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
                node{
                    styleClass = "form-group"
                    node {
                        htmlTag = "label"
                        styleClass = "col-md-3 control-label"
                        label = "ews"
                    }
                    node {
                        styleClass = "col-md-7 o365-valign-top"
                        node {
                            componetId = "ACTIVE_SYNC_ENABLED"
                            emberComponent = EmberComponent.DR_SELECT
                            width = "100px"
                            value = Powerhsell.TRUE
                        }
                    }
                }
            }
        }
    }
    root.copyToClipBoard()
}