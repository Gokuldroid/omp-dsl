package com.omp.task.layout

/**
 * Created by gokul-4192.
 */

enum class EmberComponent(val componentName: String, val handler: String) {
    DR_SELECT("management.input.drop-down-select", "SelectComponent"),
    REP_POPUP("management.input.report-popup-select", "ReportPopupComponent"),
    O365_LICENSES("management.input.o365-licenses", "LicensesComponent"),
    RADIO_GROUP("management.input.radio-group", "RadioGroupComponent"),
    TEXT("management.input.text-box", "SingleLineComponent"),
}

class AbsTractComponent() {
    var id: String? = null
    var name: String? = null
    var regex: String? = null
    var parmName: String? = null
    var dataTable: String? = null
    var inputFieldType: String? = null
    var dataType: ObjectType? = null

    override fun toString(): String {
         return ""
    }
}

val O365DropdownRadioMenuVals = "O365DropdownRadioMenuVals"