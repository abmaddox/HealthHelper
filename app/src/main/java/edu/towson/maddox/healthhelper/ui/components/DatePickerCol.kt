package edu.towson.maddox.healthhelper.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.towson.maddox.healthhelper.ui.screens.viewmodels.generics.NewItemViewModel
import java.time.LocalDate

@Composable
fun DatePickerCol(
    rowLabel: String = "Start Date:",
    isDayExpanded: Boolean,
    isMonthExpanded: Boolean,
    isYearExpanded: Boolean,
    selectedDay: Int,
    selectedMonth: Int,
    selectedYear: Int,
    setDay: (String, Int) -> Unit,
    setMonth: (String, Int) -> Unit,
    setYear: (String, Int) -> Unit,
    toggleDays: (Boolean?) -> Unit,
    toggleMonths: (Boolean?) -> Unit,
    toggleYears: (Boolean?) -> Unit
){
    Column {
        var days = listOf("")+(1..getMaxDays(selectedMonth+1, selectedYear+1)).map{ i -> i.toString()}
        var months = listOf("")+(1..12).map{i -> i.toString()}
        var years = listOf("")+(1930..LocalDate.now().year).map{ i -> i.toString()}

        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = rowLabel)
            Text(text = "Select Day")
            ComposeMenu(
                menuItems = days,
                menuExpandedState = isDayExpanded,
                itemTypes = "days",
                toggleMenuExpandStatus = { toggleDays(null) },
                onDismissMenuView = { toggleDays(false) },
                onMenuItemClick = { setDay(days[it],it) },
                selectedIndex = selectedDay
            )

        Spacer(modifier = Modifier.padding(10.dp))

            Text(text = " Select Month")
            ComposeMenu(
                menuItems = months,
                menuExpandedState = isMonthExpanded,
                itemTypes = "months",
                toggleMenuExpandStatus = { toggleMonths(null) },
                onDismissMenuView = { toggleMonths(false) },
                onMenuItemClick ={ setMonth(months[it],it) },
                selectedIndex = selectedMonth
            )

        Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Select Year")
            ComposeMenu(
                menuItems = years,
                menuExpandedState = isYearExpanded,
                itemTypes = "years",
                toggleMenuExpandStatus = { toggleYears(null) },
                onDismissMenuView = { toggleYears(false) },
                onMenuItemClick ={ setYear(years[it], it) },
                selectedIndex = selectedYear
            )

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
    vm: NewItemViewModel<A, B, C, D>
){
    DatePickerCol(
        isDayExpanded = vm.isStartDayExpanded.value,
        isMonthExpanded = vm.isStartMonthExpanded.value,
        isYearExpanded = vm.isStartYearExpanded.value,
        selectedDay = vm.startDaySelectedIndex.value,
        selectedMonth = vm.startMonthSelectedIndex.value,
        selectedYear = vm.startYearSelectedIndex.value,
        setDay = {s, i-> vm.setSelectedStartDayIndex(i)
                 vm.setStartDay(s)},
        setMonth ={s, i-> vm.setSelectedStartMonthIndex(i)
            vm.setStartMonth(s)} ,
        setYear = {s, i-> vm.setSelectedStartYearIndex(i)
            vm.setStartYear(s)},
        toggleDays = {vm.toggleIsStartDayExpanded(null)},
        toggleMonths = {vm.toggleIsStartMonthExpanded(null)},
        toggleYears = {vm.toggleIsStartYearExpanded(null)}
    )
    DatePickerCol(
        rowLabel= "End Date",
        isDayExpanded = vm.isEndDayExpanded.value,
        isMonthExpanded = vm.isEndMonthExpanded.value,
        isYearExpanded = vm.isEndYearExpanded.value,
        selectedDay = vm.endDaySelectedIndex.value,
        selectedMonth = vm.endMonthSelectedIndex.value,
        selectedYear = vm.endYearSelectedIndex.value,
        setDay = {s, i-> vm.setSelectedEndDayIndex(i)
            vm.setEndDay(s)},
        setMonth ={s, i-> vm.setSelectedEndMonthIndex(i)
            vm.setEndMonth(s)} ,
        setYear = {s, i-> vm.setSelectedEndYearIndex(i)
            vm.setEndYear(s)},
        toggleDays = {vm.toggleIsEndDayExpanded(null)},
        toggleMonths = {vm.toggleIsEndMonthExpanded(null)} ,
        toggleYears = {vm.toggleIsEndYearExpanded(null)}
    )
}