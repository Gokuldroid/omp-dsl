package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MFA_SETTINGS") {
        styleClass = "row"
        node("col-md-6") {
            node("line line-right o365-pl-20") {
                node("form-horizontal align-right") {
                    node("form-group") {
                        node("col-md-4 control-label o365-pt-0") {
                            htmlTag = "label"
                            labelWrapper = "<span class=\"o365-nowrap\">%s</span>"
                            label = "mfa_settings"
                        }
                        node("col-md-7 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "IS_MFA_ENABLED"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node("col-md-4 control-label") {
                            htmlTag = "label"
                            label = "select_mfa_method"
                        }
                        node("col-md-6") {
                            node {
                                emberComponent = EmberComponent.DR_SELECT_MUL
                                componetId = "ALLOWED_MFA_METHODS"
                            }
                        }
                    }

                    node("form-group o365-make-relative") {
                        node("col-md-4 control-label") {
                            htmlTag = "label"
                            label = "default_mfa_method"
                        }
                        node("col-md-6") {
                            node {
                                emberComponent = EmberComponent.DR_SELECT
                                componetId = "DEFAULT_MFA_METHOD"
                            }
                        }
                    }
                }
            }
        }
        node ("col-md-6"){
            node("form-horizontal align-left  o365-ml-10") {
                node("form-group") {
                    labelNode ("col-md-12 o365-thin-bold"){
                        label = "manage_user_settings"
                    }
                }
            }
        }
    }.copyToClipBoard()
}