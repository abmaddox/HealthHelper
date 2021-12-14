package edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

interface INewItemViewModel<A, B, C, D>{

    val subItems1: MutableState<List<A>>
    val subItems2: MutableState<List<B>>
    val subItems3: MutableState<List<C>>
    val subItems4: MutableState<List<D>>

    val numeric : MutableState<Double>
    val textEntry: MutableState<String>

    val startDay : MutableState<String>
    val startMonth : MutableState<String>
    val startYear : MutableState<String>

    val endDay : MutableState<String>
    val endMonth : MutableState<String>
    val endYear : MutableState<String>

    fun updateNumeric(double : String)
    fun updateTextEntry(text : String)

    val isMenu1Expanded : MutableState<Boolean>
    val selectedIndex1 : MutableState<Int?>

    val isMenu2Expanded : MutableState<Boolean>
    val selectedIndex2 : MutableState<Int?>

    val isMenu3Expanded : MutableState<Boolean>
    val selectedIndex3 : MutableState<Int?>

    val isMenu4Expanded : MutableState<Boolean>
    val selectedIndex4 : MutableState<Int?>

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

    fun setItems()
    fun addUserItem()

    fun setSubItems1(): List<A>?
    fun getSubItem1() : A

    fun setSubItems2(): List<B>?
    fun getSubItem2() : B

    fun setSubItems3(): List<C>?
    fun getSubItem3() : C

    fun setSubItems4(): List<D>?
    fun getSubItem4() : D

    fun setStartDay(s : String)
    fun setStartMonth(s : String)
    fun setStartYear(s : String)
    fun getStartDate() : String?

    fun setEndDay(s : String)
    fun setEndMonth(s : String)
    fun setEndYear(s : String)
    fun getEndDate() : String?

    fun setSelectedIndex1(i : Int)
    fun toggleMenu1Expansion(b : Boolean?)

    fun setSelectedIndex2(i : Int)
    fun toggleMenu2Expansion(b : Boolean?)

    fun setSelectedIndex3(i : Int)
    fun toggleMenu3Expansion(b : Boolean?)

    fun setSelectedIndex4(i : Int)
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

    val isErrorPopupVisible: MutableState<Boolean>
    fun toggleErrorPopupVisible()
}

abstract class NewItemViewModel<A, B, C, D> : INewItemViewModel<A, B, C, D>, ViewModel()
{
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

    private val _selectedIndex1 : MutableState<Int?> = mutableStateOf(null)
    override val selectedIndex1 = _selectedIndex1

    private val _isMenu2Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu2Expanded = _isMenu2Expanded

    private val _selectedIndex2 : MutableState<Int?> = mutableStateOf(null)
    override val selectedIndex2= _selectedIndex2

    private val _isMenu3Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu3Expanded = _isMenu3Expanded

    private val _selectedIndex3 : MutableState<Int?> = mutableStateOf(null)
    override val selectedIndex3 = _selectedIndex3

    private val _isMenu4Expanded : MutableState<Boolean> = mutableStateOf(false)
    override val isMenu4Expanded = _isMenu4Expanded

    private val _selectedIndex4 : MutableState<Int?> = mutableStateOf(null)
    override val selectedIndex4 = _selectedIndex4

    private val _isStartDayExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartDayExpanded = _isStartDayExpanded

    private val _startDaySelectedIndex : MutableState<Int> = mutableStateOf(1)
    override val startDaySelectedIndex = _startDaySelectedIndex


    private val _isStartMonthExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartMonthExpanded = _isStartMonthExpanded

    private val _startMonthSelectedIndex : MutableState<Int> = mutableStateOf(1)
    override val startMonthSelectedIndex = _startMonthSelectedIndex


    private val _isStartYearExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isStartYearExpanded = _isStartYearExpanded

    private val _startYearSelectedIndex : MutableState<Int> = mutableStateOf(59)
    override val startYearSelectedIndex = _startYearSelectedIndex


    private val _isEndDayExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndDayExpanded = _isEndDayExpanded

    private val _endDaySelectedIndex : MutableState<Int> = mutableStateOf(1)
    override val endDaySelectedIndex = _endDaySelectedIndex


    private val _isEndMonthExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndMonthExpanded = _isEndMonthExpanded

    private val _endMonthSelectedIndex : MutableState<Int> = mutableStateOf(1)
    override val endMonthSelectedIndex = _endMonthSelectedIndex


    private val _isEndYearExpanded : MutableState<Boolean> = mutableStateOf(false)
    override val isEndYearExpanded = _isEndYearExpanded

    private val _endYearSelectedIndex : MutableState<Int> = mutableStateOf(60)
    override val endYearSelectedIndex = _endYearSelectedIndex

    private val _startDay : MutableState<String> = mutableStateOf("")
    private val _startMonth : MutableState<String>  = mutableStateOf("")
    private val _startYear : MutableState<String>  = mutableStateOf("")

    private val _endDay : MutableState<String>  = mutableStateOf("")
    private val _endMonth : MutableState<String>  = mutableStateOf("")
    private val _endYear : MutableState<String>  = mutableStateOf("")

    override val startDay = _startDay
    override val startMonth = _startMonth
    override val startYear = _startYear

    override val endDay = _endDay
    override val endMonth = _endMonth
    override val endYear = _endYear

    override fun setStartDay(s : String){
        _startDay.value = s
    }
    override fun setStartMonth(s : String){
        _startMonth.value = s
    }
    override fun setStartYear(s : String){
        _startYear.value = s
    }

    override fun setEndDay(s : String){
        _endDay.value = s
    }
    override fun setEndMonth(s : String){
        _endMonth.value = s
    }
    override fun setEndYear(s : String){
        _endYear.value = s
    }

    override fun getStartDate(): String {
        return if (startDay.value == "" || startMonth.value=="" || startYear.value=="")
            ""
        else{
            "${startYear.value}-${startMonth.value}-${startDay.value}"
        }
    }

    override fun getEndDate(): String {
        return if (endDay.value == "" || endMonth.value=="" || endYear.value=="")
            ""
        else{
            "${endYear.value}-${endMonth.value}-${endDay.value}"
        }
    }

    override fun getSubItem1(): A
    {
        return _subItems1.value[_selectedIndex1.value!!]
    }

    override fun getSubItem2(): B
    {
        return _subItems2.value[_selectedIndex2.value!!]
    }

    override fun getSubItem3(): C
    {
        return _subItems3.value[_selectedIndex3.value!!]
    }

    override fun getSubItem4(): D
    {
        return _subItems4.value[_selectedIndex4.value!!]
    }

    override fun setItems(){
        _subItems1.value = setSubItems1()
        _subItems2.value = setSubItems2()
        _subItems3.value = setSubItems3()
        _subItems4.value = setSubItems4()
    }

    abstract override fun setSubItems1(): List<A>
    abstract override fun setSubItems2():List<B>
    abstract override fun setSubItems3():List<C>
    abstract override fun setSubItems4():List<D>

    abstract override fun addUserItem()

    private val _isErrorPopupVisible : MutableState<Boolean> = mutableStateOf(false)
    override val isErrorPopupVisible = _isErrorPopupVisible

    override fun toggleErrorPopupVisible(){
        _isErrorPopupVisible.value = !_isErrorPopupVisible.value
    }

    override fun setSelectedIndex1(i : Int){
        _selectedIndex1.value = i
    }
    override fun toggleMenu1Expansion(b : Boolean?){
        if(b == null) _isMenu1Expanded.value = !_isMenu1Expanded.value else _isMenu1Expanded.value = b
    }

    override fun setSelectedIndex2(i : Int){
        _selectedIndex2.value = i
    }
    override fun toggleMenu2Expansion(b : Boolean?){
        if(b == null) _isMenu2Expanded.value = !_isMenu2Expanded.value else _isMenu2Expanded.value = b
    }

    override fun setSelectedIndex3(i : Int){
        _selectedIndex3.value = i
    }
    override fun toggleMenu3Expansion(b : Boolean?){
        if(b == null) _isMenu3Expanded.value = !_isMenu3Expanded.value else _isMenu3Expanded.value = b
    }

    override fun setSelectedIndex4(i : Int){
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