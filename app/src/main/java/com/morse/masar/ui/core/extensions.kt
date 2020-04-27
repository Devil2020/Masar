package com.morse.masar.ui.core

fun Any.checkIfNull (block : (String) -> Unit) {
    if (this == ""){
        block (" - Not Defiend Yet -")
    }
    else {
        block (this?.toString())
    }
}