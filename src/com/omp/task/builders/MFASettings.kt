package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    var enabled: Node? = null
    var options1: Node? = null
    var options2: Node? = null

    Node("MFA_SETTINGS") {
        styleClass = "row"
        node("col-md-12") {
            node("static-container-sm center-block ember-view") {
                node("form-horizontal align-right o365-ml-m22") {
                    node("form-group") {
                        node("col-md-4 control-label o365-pt-0") {
                            htmlTag = "label"
                            labelWrapper = "<span class=\"o365-nowrap\">%s</span>"
                            label = "mfa_settings"
                        }
                        node("col-md-7 o365-valign-top") {
                            enabled = node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "IS_MFA_ENABLED"
                                value = "Enforce"
                                mandatory()
                            }
                        }
                    }
                    options1 = node("form-group o365-make-relative") {
                        node("col-md-4 control-label") {
                            htmlTag = "label"
                            label = "select_mfa_method"
                        }
                        node("col-md-6") {
                            node {
                                emberComponent = EmberComponent.DR_SELECT_MUL
                                componetId = "ALLOWED_MFA_METHODS"
                                placeHolderText = "select_mfa_methods"
                                label = "select_mfa_method"
                                mandatory()
                            }
                        }
                    }

                    options2 = node("form-group o365-make-relative") {
                        node("col-md-4 control-label") {
                            htmlTag = "label"
                            label = "default_mfa_method"
                        }
                        node("col-md-6") {
                            node {
                                emberComponent = EmberComponent.DR_SELECT
                                componetId = "DEFAULT_MFA_METHOD"
                                mandatory()
                                label = "default_mfa_method"
                            }
                        }
                    }
                }
            }
        }
//        node ("col-md-6"){
//            node("form-horizontal align-left  o365-ml-10") {
//                node("form-group") {
//                    labelNode ("col-md-12 o365-thin-bold"){
//                        label = "manage_user_settings"
//                    }
//                }
//                node("form-group") {
//                    node("col-md-12") {
//                        node("o365-pl-20") {
//                            labelNode("checkbox") {
//                                node {
//                                    componetId = "REQUIRE_CONTACTS_AGAIN"
//                                    emberComponent = EmberComponent.CHECK_BOX
//                                }
//                                spanNode("o365-space-2")
//                                spanNode {
//                                    label = "require_contact_methods_again"
//                                }
//                            }
//                        }
//                    }
//                }
//
//                node("form-group") {
//                    node("col-md-12") {
//                        node("o365-pl-20") {
//                            labelNode("checkbox") {
//                                node {
//                                    componetId = "DELETE_EXISTING_APP_PASSWORDS"
//                                    emberComponent = EmberComponent.CHECK_BOX
//                                }
//                                spanNode("o365-space-2")
//                                spanNode {
//                                    label = "delete_existing_app_passwords"
//                                }
//                            }
//                        }
//                    }
//                }
//
//                node("form-group") {
//                    node("col-md-12") {
//                        node("o365-pl-20") {
//                            labelNode("checkbox") {
//                                node {
//                                    componetId = "RESTORE_MFA_ALL_REMEMBERED_DEVICES"
//                                    emberComponent = EmberComponent.CHECK_BOX
//                                }
//                                spanNode("o365-space-2")
//                                spanNode {
//                                    label = "restore_mfa_all_remembered_devices"
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }.copyToClipBoard({
        addRule(enabled,options1,Action.HIDE,Condition.EQUAL,"Disabled")
        addRule(enabled,options2,Action.HIDE,Condition.EQUAL,"Disabled")
    })
}