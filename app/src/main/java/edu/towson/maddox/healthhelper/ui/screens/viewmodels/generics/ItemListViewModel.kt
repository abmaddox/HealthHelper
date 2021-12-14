package edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
interface IItemListViewModel<A,B,C,D,E>{
    val userItems : MutableState<List<A>>
    val subItems1 : MutableState<List<B>>
    val subItems2 : MutableState<List<C>>
    val subItems3 : MutableState<List<D>>
    val subItems4 : MutableState<List<E>>

    val waiting : MutableState<Boolean>

    fun setItems()
    fun setUserItems(): List<A>
    fun setSubItems1(): List<B>
    fun setSubItems2(): List<C>
    fun setSubItems3(): List<D>
    fun setSubItems4(): List<E>

    fun getSubItem1(subitem_id : Int):B
    fun getSubItem2(subitem_id : Int):C
    fun getSubItem3(subitem_id : Int):D
    fun getSubItem4(subitem_id : Int):E

    fun deleteUserItem(idx : Int)
}

@ExperimentalCoroutinesApi
abstract class ItemListViewModel<A,B,C,D,E>(private val repo: HealthRepo) : ViewModel(), IItemListViewModel<A, B, C, D, E>
{
    private val _userItems : MutableState<List<A>> = mutableStateOf(listOf())
    private val _subItems1 : MutableState<List<B>> = mutableStateOf(listOf())
    private val _subItems2 : MutableState<List<C>> = mutableStateOf(listOf())
    private val _subItems3 : MutableState<List<D>> = mutableStateOf(listOf())
    private val _subItems4 : MutableState<List<E>> = mutableStateOf(listOf())

    private val _waiting : MutableState<Boolean> = mutableStateOf(true)
    override val waiting = _waiting

    override val userItems = _userItems
    override val subItems1 = _subItems1
    override val subItems2 = _subItems2
    override val subItems3 = _subItems3
    override val subItems4 = _subItems4

    override fun setItems(){
        _userItems.value = setUserItems()
        _subItems1.value = setSubItems1()
        _subItems2.value = setSubItems2()
        _subItems3.value = setSubItems3()
        _subItems4.value = setSubItems4()
    }

    abstract override fun setUserItems(): List<A>
    abstract override fun setSubItems1(): List<B>
    abstract override fun setSubItems2(): List<C>
    abstract override fun setSubItems3(): List<D>
    abstract override fun setSubItems4(): List<E>

    abstract override fun getSubItem1(subitem_id : Int):B
    abstract override fun getSubItem2(subitem_id : Int):C
    abstract override fun getSubItem3(subitem_id : Int):D
    abstract override fun getSubItem4(subitem_id : Int):E

    override fun deleteUserItem(idx : Int){
        val item = _userItems.value[idx]
        when
        {
            _userItems.value.size==1 ->
            {
                _userItems.value = listOf()
            }
            _userItems.value.lastIndex == idx ->
            {
                _userItems.value = _userItems.value.subList(0,idx)
            }
            else ->
            {
                _userItems.value = _userItems.value.subList(0,idx) + _userItems.value.subList(idx+1, _userItems.value.lastIndex)
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            deleteUserItemFromDb(item)
            repo.loadUserItems()
            setUserItems()
        }
    }

    abstract suspend fun deleteUserItemFromDb(item : A)
}