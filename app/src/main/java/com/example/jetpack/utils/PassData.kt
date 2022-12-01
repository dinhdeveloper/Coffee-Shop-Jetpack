package com.example.jetpack.utils

import androidx.navigation.NavController
import java.io.Serializable


fun <T> NavController.getArgument(name: String): T {
    return previousBackStackEntry?.arguments?.getSerializable(name) as? T
        ?: throw IllegalArgumentException()
}

fun NavController.putArgument(name: String, arg: Serializable?) {
    currentBackStackEntry?.arguments?.putSerializable(name, arg)
}