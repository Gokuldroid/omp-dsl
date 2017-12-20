package com.omp.task.layout

import com.omp.task.utils.addParam
import com.omp.task.utils.newLine
import com.omp.task.utils.toClipBoard
import org.apache.commons.lang3.StringEscapeUtils


/**
 * Created by gokul-4192.
 */

class Node {
    var parentNode: Node? = null
    var id: Int? = null
    var componetId: Any? = null
    var emberComponent: EmberComponent? = null
    var label: String? = null
    var labelWrapper: String? = null
    var visible: Boolean = true
    var enabled: Boolean = true
    var mandatory: Boolean = false
    var priority: Int? = null
    var taskId: String
    var htmlTag: String? = null
    var width: String? = null
    var styleClass: String? = null
    var value: String? = null
    var tooltip: String? = null
    var placeHolderText: String? = null
    var rules: StringBuilder = StringBuilder()
    val childNodes = ArrayList<Node>()

    constructor(taskId: String, receiver: (Node.() -> Unit)? = null) {
        this.taskId = taskId
        receiver?.invoke(this)
    }

    fun node(styleClass: String? = null, receiver: (Node.() -> Unit)? = null): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }


    fun spanNode(styleClass: String? = null, receiver: (Node.() -> Unit)? = null): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "span"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun labelNode(styleClass: String? = null, receiver: (Node.() -> Unit)?): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "label"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun tableNode(styleClass: String? = null, receiver: (Node.() -> Unit)?): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "table"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun tbodyNode(styleClass: String? = null, receiver: (Node.() -> Unit)?): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "tbody"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun trNode(styleClass: String? = null, receiver: (Node.() -> Unit)?): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "tr"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun tdNode(styleClass: String? = null, receiver: (Node.() -> Unit)?): Node {
        val node = Node(this.taskId, receiver)
        node.parentNode = this
        node.htmlTag = "td"
        styleClass?.also { node.styleClass = it }
        this.childNodes.add(node)
        return node
    }

    fun hide() {
        visible = false
    }

    fun mandatory() {
        mandatory = true
    }

    fun disabled() {
        enabled = true
    }

    fun addRule(trigger: Node, target: Node, action: Action, condition: Condition, value: String) {
        val sb = StringBuilder("<O365LayoutComponentRules ")
        ruleId = ruleId.inc()
        with(sb) {
            addParam("UNIQUE_ID", "O365LayoutComponentRules:UNIQUE_ID:" + taskId + "_" + ruleId)
            addParam("TASK_ID", "O365MgmtTasks:TASK_ID:" + taskId)
            addParam("TRIGGER_COMPONENT_GROUP_ID", "O365LayoutComponentGroup:COMPONENT_GROUP_ID:" + taskId + "_" + trigger.id!!)
            addParam("TARGET_COMPONENT_GROUP_ID", "O365LayoutComponentGroup:COMPONENT_GROUP_ID:" + taskId + "_" + target.id!!)
            addParam("ACTION", action)
            addParam("VALUE", value)
            addParam("CONDITION", condition)
        }
        rules.append(sb.toString() + "/>".newLine())
    }

    override fun toString(): String {
        val sb = StringBuilder("<O365LayoutComponentGroup ")
        layoutComponentStartId = layoutComponentStartId.inc()
        id = layoutComponentStartId
        with(sb) {
            addParam("COMPONENT_GROUP_ID", "O365LayoutComponentGroup:COMPONENT_GROUP_ID:" + taskId + "_" + id!!)
            parentNode?.also { addParam("PARENT_GROUP_ID", "O365LayoutComponentGroup:COMPONENT_GROUP_ID:" + taskId + "_" + it.id) }
            componetId?.also { addParam("COMPONENT_ID", "O365Components:COMPONENT_ID:" + it) }
            emberComponent?.also { addParam("EMBER_COMPONENT", it.componentName) }
            emberComponent?.also { addParam("COMPONENT_HANDLER", it.handler) }
            if (labelWrapper == null)
                label?.also { addParam("LABEL", "o365.input_fields." + label) }
            else
                addParam("LABEL", StringEscapeUtils.escapeHtml4(labelWrapper!!.format("{{o365.input_fields." + label!! + "}}")))
            addParam("IS_VISIBLE", visible)
            addParam("IS_ENABLED", enabled)
            addParam("IS_MANDATORY", mandatory)
            addParam("PRIORITY", (parentNode?.childNodes?.indexOf(this@Node) ?: 0).inc())
            addParam("TASK_ID", "O365MgmtTasks:TASK_ID:" + taskId)
            htmlTag?.also { addParam("HTML_TAG_NAME", it) }
            width?.also { addParam("WIDTH", it) }
            styleClass?.also { addParam("STYLE_CLASSES", it) }
            value?.also { addParam("VALUE", it) }
            tooltip?.also { addParam("TOOL_TIP", "o365.tooltip." + it) }
            placeHolderText?.also { addParam("PLACE_HOLDER_TEXT", "o365.input_fields."+it) }
        }
        var result = sb.append("/>").trim().toString().newLine()
        childNodes.forEach {
            result += it.toString()
        }
        return result
    }

    companion object {
        var layoutComponentStartId: Int = 0
        var ruleId: Int = 0;
    }

    fun copyToClipBoard(receiver: (Node.() -> Unit)? = null) {
        var myString = toString()
        myString += "\n"
        receiver?.invoke(this)
        myString += rules.toString()
        myString.toClipBoard()
    }
}

