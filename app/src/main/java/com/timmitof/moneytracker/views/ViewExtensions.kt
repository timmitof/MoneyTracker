package com.timmitof.moneytracker.views

import android.view.View

fun View.isVisible () : Boolean {
    return this.visibility == View.VISIBLE
}
fun View.isGone () : Boolean {
    return this.visibility == View.GONE
}
fun View.isInVisible () : Boolean {
    return this.visibility == View.INVISIBLE
}
fun View.setVisible () {
     this.visibility = View.VISIBLE
}
fun View.setGone () {
     this.visibility = View.GONE
}
fun View.setInVisible () {
     this.visibility = View.INVISIBLE
}

fun View.reverseVisibility (){
    if (isVisible()) this.visibility = View.GONE
    else this.visibility = View.VISIBLE
}
