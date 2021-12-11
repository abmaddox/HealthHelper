package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.INewItemViewModel
import java.time.LocalDate

@Composable
fun DatePickerRow(
    rowLabel: String = "Start Date:",
    isDayExpanded: Boolean,
    isMonthExpanded: Boolean,
    isYearExpanded: Boolean,
    selectedDay: Int,
    selectedMonth: Int,
    selectedYear: Int,
    setDay: (Int) -> Unit,
    setMonth: (Int) -> Unit,
    setYear: (Int) -> Unit,
    toggleDays: (Boolean?) -> Unit,
    toggleMonths: (Boolean?) -> Unit,
    toggleYears: (Boolean?) -> Unit
){
    Row() {
        var days = listOf("")+(1..getMaxDays(selectedMonth+1, selectedYear+1)).map{ i -> i.toString()}
        var months = listOf("")+(1..12).map{i -> i.toString()}
        var years = listOf("")+(1930..LocalDate.now().year).map{ i -> i.toString()}

        Text(text = rowLabel)
        Column{
            Text(text = "Select Day")
            ComposeMenu(
                menuItems = days,
                menuExpandedState = isDayExpanded,
                selectedIndex = selectedDay,
                updateMenuExpandStatus = { toggleDays(null) },
                onDismissMenuView = { toggleDays(false) },
                onMenuItemClick = { setDay(days[it].toInt()) }
            )
        }

        Column{
            Text(text = " Select Month")
            ComposeMenu(
                menuItems = months,
                menuExpandedState = isMonthExpanded,
                selectedIndex = selectedMonth,
                updateMenuExpandStatus = { toggleMonths(null) },
                onDismissMenuView = { toggleMonths(false) },
                onMenuItemClick ={ setMonth(months[it].toInt()) }
            )
        }

        Column{
            Text(text = "Select Year")
            ComposeMenu(
                menuItems = years,
                menuExpandedState = isYearExpanded,
                selectedIndex = selectedYear,
                updateMenuExpandStatus = { toggleYears(null) },
                onDismissMenuView = { toggleYears(false) },
                onMenuItemClick ={ setYear(years[it].toInt()) }
            )
        }
    }
}
fun getMaxDays(month : Int, year: Int):Int{
    return when (month+1){
        2 -> if ((year+1930)%4!=0) 29 else 28
        4,6,9,11->30
        else -> {31}
    }
}

@Composable
fun <A,B,C,D> StartEndDatePicker(
    vm: INewItemViewModel<A, B, C, D>
){
    DatePickerRow(
        isDayExpanded = vm.isStartDayExpanded.value,
        isMonthExpanded = vm.isStartMonthExpanded.value,
        isYearExpanded = vm.isStartYearExpanded.value,
        selectedDay = vm.startDaySelectedIndex.value,
        selectedMonth = vm.startMonthSelectedIndex.value,
        selectedYear = vm.startYearSelectedIndex.value,
        setDay = {vm.setSelectedStartDayIndex(it)},
        setMonth ={vm.setSelectedStartMonthIndex(it)} ,
        setYear = {vm.setSelectedStartYearIndex(it)},
        toggleDays = {vm.toggleIsStartDayExpanded(null)},
        toggleMonths = {vm.toggleIsStartMonthExpanded(null)},
        toggleYears = {vm.toggleIsStartYearExpanded(null)}
    )
    DatePickerRow(
        rowLabel= "End Date",
        isDayExpanded = vm.isEndDayExpanded.value,
        isMonthExpanded = vm.isEndMonthExpanded.value,
        isYearExpanded = vm.isEndYearExpanded.value,
        selectedDay = vm.endDaySelectedIndex.value,
        selectedMonth = vm.endMonthSelectedIndex.value,
        selectedYear = vm.endYearSelectedIndex.value,
        setDay = {vm.setSelectedEndDayIndex(it)},
        setMonth ={vm.setSelectedEndMonthIndex(it)} ,
        setYear = {vm.setSelectedEndYearIndex(it)},
        toggleDays = {vm.toggleIsEndDayExpanded(null)},
        toggleMonths = {vm.toggleIsEndMonthExpanded(null)} ,
        toggleYears = {vm.toggleIsEndYearExpanded(null)}
    )
}