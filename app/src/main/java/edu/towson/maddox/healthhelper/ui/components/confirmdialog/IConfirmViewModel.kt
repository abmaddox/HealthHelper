package edu.towson.cosc435.valis.labsapp.ui.confirmdialog

import androidx.compose.runtime.State

interface IConfirmViewModel {
    val showConfirmDialog: State<Boolean>
    val waiting: State<Boolean>
    val waitingProgress: State<Float>
    fun showConfirmDelete(onConfirm: suspend () -> Unit)
    fun onConfirmDelete()
    fun dismissDialog()
}