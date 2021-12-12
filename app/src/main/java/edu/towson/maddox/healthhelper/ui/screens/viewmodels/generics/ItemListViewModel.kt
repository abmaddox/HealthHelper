package edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import edu.towson.maddox.healthhelper.data.repo.IHealthRepo
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

    suspend fun setItems()
    suspend fun setUserItems(): List<A>?
    suspend fun setSubItems1(): List<B>?
    suspend fun setSubItems2(): List<C>?
    suspend fun setSubItems3(): List<D>?
    suspend fun setSubItems4(): List<E>?

    fun getSubItem1(subitem_id : Int):B
    fun getSubItem2(subitem_id : Int):C
    fun getSubItem3(subitem_id : Int):D
    fun getSubItem4(subitem_id : Int):E

    fun deleteUserItem(item : A)
    suspend fun reloadUserItems()
}

@ExperimentalCoroutinesApi
abstract class ItemListViewModel<A,B,C,D,E>(app : Application) : AndroidViewModel(app), IItemListViewModel<A, B, C, D, E>
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

    val repo : IHealthRepo = HealthRepo(app)

    override suspend fun setItems(){
        setUserItems()
        setSubItems1()
        setSubItems2()
        setSubItems3()
        setSubItems4()
    }

    abstract override suspend fun setUserItems(): List<A>?
    abstract override suspend fun setSubItems1(): List<B>?
    abstract override suspend fun setSubItems2():List<C>?
    abstract override suspend fun setSubItems3():List<D>?
    abstract override suspend fun setSubItems4():List<E>?

    abstract override fun getSubItem1(subitem_id : Int):B
    abstract override fun getSubItem2(subitem_id : Int):C
    abstract override fun getSubItem3(subitem_id : Int):D
    abstract override fun getSubItem4(subitem_id : Int):E

    abstract override fun deleteUserItem(item: A)
    override suspend fun reloadUserItems()
    {
        viewModelScope.launch { setUserItems() }
    }
}