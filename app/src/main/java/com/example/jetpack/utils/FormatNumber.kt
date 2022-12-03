package com.example.jetpack.utils


object FormatNumber {

    fun formatMoney(money: String?) : String {
        return "${Utils.formatMoney(Utils.formatDouble(money?.toDouble()))} VNĐ"
    }
}