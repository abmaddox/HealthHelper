package edu.towson.maddox.healthhelper.ui.screens.vitals.vitalslist

import androidx.compose.runtime.Composable
import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign
import edu.towson.maddox.healthhelper.data.model.vitals.uVitals
import java.util.*

@Composable
fun UVitalsRow(vital: VitalSign,
                methodName : String,
                ts : String,
                meas : Double,
                onDelete : (uVitals)->Unit) {

}