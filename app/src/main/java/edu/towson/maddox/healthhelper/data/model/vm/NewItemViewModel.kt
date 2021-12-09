package edu.towson.maddox.healthhelper.data.model.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.towson.maddox.healthhelper.data.repo.HealthRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

interface INewItemViewModel<A, B, C, D>{

    val subItems1: MutableState<List<A>>
    val subItems2: MutableState<List<B>>
    val subItems3: MutableState<List<C>>
    val subItems4: MutableState<List<D>>

    val numeric : MutableState<Double>
    val textEntry: MutableState<String>

    fun updateNumeric(double : String)
    fun updateTextEntry(text : String)

    val isMenu1Expanded : MutableState<Boolean>
    val selectedIndex1 : MutableState<Int>

    val isMenu2Expanded : MutableState<Boolean>
    val selectedIndex2 : MutableState<Int>

    val isMenu3Expanded : MutableState<Boolean>
    val selectedIndex3 : MutableState<Int>

    val isMenu4Expanded : MutableState<Boolean>
    val selectedIndex4 : MutableState<Int>

    val isStartDayExpanded : MutableState<Boolean>
    val startDaySelectedIndex : MutableState<Int>

    val isStartMonthExpanded : MutableState<Boolean>
    val startMonthSelectedIndex : MutableState<Int>

    val isStartYearExpanded : MutableState<Boolean>
    val startYearSelectedIndex : MutableState<Int>

    val isEndDayExpanded : MutableState<Boolean>
    val endDaySelectedIndex : MutableState<Int>

    val isEndMonthExpanded : MutableState<Boolean>
    val endMonthSelectedIndex : MutableState<Int>

    val isEndYearExpanded : MutableState<Boolean>
    val endYearSelectedIndex : MutableState<Int>

    suspend fun setItems()
    suspend fun addUserItem()

    suspend fun setSubItems1(): List<A>
    suspend fun setSubItems2():List<B>
    suspend fun setSubItems3():List<C>
    suspend fun setSubItems4():List<D>



    fun setSelectedConditionIndex1(i : Int)
    fun toggleMenu1Expansion(b : Boolean?)

    fun setSelectedConditionIndex2(i : Int)
    fun toggleMenu2Expansion(b : Boolean?)

    fun setSelectedConditionIndex3(i : Int)
    fun toggleMenu3Expansion(b : Boolean?)

    fun setSelectedConditionIndex4(i : Int)
    fun toggleMenu4Expansion(b : Boolean?)

    fun setSelectedStartDayIndex(i : Int)
    fun toggleIsStartDayExpanded(b : Boolean?)

    fun setSelectedStartMonthIndex(i : Int)
    fun toggleIsStartMonthExpanded(b : Boolean?)

    fun setSelectedStartYearIndex(i : Int)
    fun toggleIsStartYearExpanded(b : Boolean?)

    fun setSelectedEndDayIndex(i : Int)
    fun toggleIsEndDayExpanded(b : Boolean?)

    fun setSelectedEndMonthIndex(i : Int)
    fun toggleIsEndMonthExpanded(b : Boolean?)

    fun setSelectedEndYearIndex(i : Int)
    fun toggleIsEndYearExpanded(b : Boolean?)

}

abstract class NewItemViewModel<A, B, C, D>(private val repo: HealthRepo,private val user_id : Int) : ViewModel(), INewItemViewModel<A,B,C,D>{
    private val _subItems1: MutableState<List<A>> = mutableStateOf(listOf())
    private val _subItems2: MutableState<List<B>> = mutableStateOf(listOf())
    private val _subItems3: MutableState<List<C>> = mutableStateOf(listOf())
    private val _subItems4: MutableState<List<D>> = mutableStateOf(listOf())

    override val subItems1: MutableState<List<A>> = _subItems1
    override val subItems2: MutableState<List<B>> = _subItems2
    override val subItems3: MutableState<List<C>> = _subItems3
    override val subItems4: MutableState<List<D>> = _subItems4

    private val _numeric: MutableState<Double> = mutableStateOf(0.0)
    override val numeric = _numeric

    private val _textEntry : MutableState<String> = mutableStateOf("")
    override val textEntry =_textEntry

    override fun updateNumeric(double : String) {
        try {
            _numeric.value = double.toDouble()
        }catch (e : Exception){
            _numeric.value = 0.0
        }
    }

    override fun updateTextEntry(text : String) {
        _textEntry.value = text
    }


    private val _isMenu1Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu1Expanded = _isMenu1Expanded

    private val _selectedIndex1 : MutableState<Int> = mutableStateOf(0)
    override val selectedIndex1 = _selectedIndex1

    private val _isMenu2Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu2Expanded = _isMenu2Expanded

    private val _selectedIndex2 : MutableState<Int> = mutableStateOf(0)
    override val selectedIndex2= _selectedIndex2

    private val _isMenu3Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu3Expanded = _isMenu3Expanded

    private val _selectedIndex3 : MutableState<Int> = mutableStateOf(0)
    override val selectedIndex3 = _selectedIndex3

    private val _isMenu4Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu4Expanded = _isMenu4Expanded

    private val _selectedIndex4 : MutableState<Int> = mutableStateOf(0)
    override val selectedIndex4 = _selectedIndex4

    private val _isStartDayExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartDayExpanded = _isStartDayExpanded

    private val _startDaySelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val startDaySelectedIndex = _startDaySelectedIndex


    private val _isStartMonthExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartMonthExpanded = _isStartMonthExpanded

    private val _startMonthSelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val startMonthSelectedIndex = _startMonthSelectedIndex


    private val _isStartYearExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartYearExpanded = _isStartYearExpanded

    private val _startYearSelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val startYearSelectedIndex = _startYearSelectedIndex


    private val _isEndDayExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndDayExpanded = _isEndDayExpanded

    private val _endDaySelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val endDaySelectedIndex = _endDaySelectedIndex


    private val _isEndMonthExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndMonthExpanded = _isEndMonthExpanded

    private val _endMonthSelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val endMonthSelectedIndex = _endMonthSelectedIndex


    private val _isEndYearExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndYearExpanded = _isEndYearExpanded

    private val _endYearSelectedIndex : MutableState<Int> = mutableStateOf(0)
    override val endYearSelectedIndex = _endYearSelectedIndex

    init {

        viewModelScope.launch(Dispatchers.Main)
        {
            setItems()
        }
    }

    override suspend fun setItems(){
        _subItems1.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                setSubItems1()
            }
        _subItems2.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                setSubItems2()
            }
        _subItems3.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                setSubItems3()
            }
        _subItems4.value =
            withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                setSubItems4()
            }
    }

    abstract override suspend fun setSubItems1(): List<A>
    abstract override suspend fun setSubItems2():List<B>
    abstract override suspend fun setSubItems3():List<C>
    abstract override suspend fun setSubItems4():List<D>

    abstract override suspend fun addUserItem(    )

    override fun setSelectedConditionIndex1(i : Int){
        _selectedIndex1.value = i
    }
    override fun toggleMenu1Expansion(b : Boolean?){
        if(b == null) _isMenu1Expanded.value = !_isMenu1Expanded.value else _isMenu1Expanded.value = b
    }

    override fun setSelectedConditionIndex2(i : Int){
        _selectedIndex2.value = i
    }
    override fun toggleMenu2Expansion(b : Boolean?){
        if(b == null) _isMenu2Expanded.value = !_isMenu2Expanded.value else _isMenu2Expanded.value = b
    }

    override fun setSelectedConditionIndex3(i : Int){
        _selectedIndex3.value = i
    }
    override fun toggleMenu3Expansion(b : Boolean?){
        if(b == null) _isMenu3Expanded.value = !_isMenu3Expanded.value else _isMenu3Expanded.value = b
    }

    override fun setSelectedConditionIndex4(i : Int){
        _selectedIndex4.value = i
    }
    override fun toggleMenu4Expansion(b : Boolean?){
        if(b == null) _isMenu4Expanded.value = !_isMenu4Expanded.value else _isMenu4Expanded.value = b
    }

    override fun setSelectedStartDayIndex(i: Int) {
        _startDaySelectedIndex.value = i
    }

    override fun toggleIsStartDayExpanded(b: Boolean?) {
        if(b == null) _isStartDayExpanded.value = !_isStartDayExpanded.value else _isStartDayExpanded.value = b
    }

    override fun setSelectedStartMonthIndex(i: Int) {
        _startMonthSelectedIndex.value = i
    }

    override fun toggleIsStartMonthExpanded(b: Boolean?) {
        if(b == null) _isStartMonthExpanded.value = !_isStartMonthExpanded.value else _isStartMonthExpanded.value = b
    }

    override fun setSelectedStartYearIndex(i: Int) {
        _startYearSelectedIndex.value = i
    }

    override fun toggleIsStartYearExpanded(b: Boolean?) {
        if(b == null) _isStartYearExpanded.value = !_isStartYearExpanded.value else _isStartYearExpanded.value = b
    }

    override fun setSelectedEndDayIndex(i: Int) {
        _endDaySelectedIndex.value = i
    }

    override fun toggleIsEndDayExpanded(b: Boolean?) {
        if(b == null) _isEndDayExpanded.value = !_isEndDayExpanded.value else _isEndDayExpanded.value = b
    }

    override fun setSelectedEndMonthIndex(i: Int) {
        _endMonthSelectedIndex.value = i
    }

    override fun toggleIsEndMonthExpanded(b: Boolean?) {
        if(b == null) _isEndMonthExpanded.value = !_isEndMonthExpanded.value else _isEndMonthExpanded.value = b
    }

    override fun setSelectedEndYearIndex(i: Int) {
        _endYearSelectedIndex.value = i
    }

    override fun toggleIsEndYearExpanded(b: Boolean?) {
        if(b == null) _isEndYearExpanded.value = !_isEndYearExpanded.value else _isEndYearExpanded.value = b
    }

}