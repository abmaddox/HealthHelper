package edu.towson.maddox.healthhelper.ui.screens.medications.medlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.maddox.healthhelper.data.model.medications.*

@ExperimentalFoundationApi
@Composable
fun UMedicationRow(
    med: Medication,
    freq: Frequency,
    method: AdministrationMethod,
    unit: DoseUnit,
    uMedications: uMedications,
    onDelete: (uMedications)-> Unit,
) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        onDelete(uMedications)
                    }
                ){}
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Name:", modifier = Modifier.weight(1.0f))
                    Text(text = med.toString(), modifier = Modifier.weight(2.0f), fontSize = 28.sp, color = MaterialTheme.colors.secondary)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Dosage:", modifier = Modifier.weight(1.0f))
                    Text(text = "${uMedications.dosage} $unit", modifier = Modifier.weight(2.0f))
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Start Date:", modifier = Modifier.weight(1.0f))
                    Text(uMedications.startDate.toString(), modifier = Modifier.weight(2.0f))
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("End Date:", modifier = Modifier.weight(1.0f))
                    Text(if (uMedications.endDate != null) uMedications.endDate.toString() else "n/a", modifier = Modifier.weight(2.0f))
                }
            }
            Column(
                modifier = Modifier.weight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(bottom=5.dp))
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Frequency:", modifier = Modifier.weight(1.0f))
                    Text(text = freq.toString(), modifier = Modifier.weight(2.0f))
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Administration\n method:", modifier = Modifier.weight(1.0f))
                    Text(text = method.toString(), modifier = Modifier.weight(2.0f))
                }
                if (uMedications.reason != null){
                    Row(
                        modifier = Modifier.padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Administration\n method:", modifier = Modifier.weight(1.0f))
                        Text(text = uMedications.reason, modifier = Modifier.weight(2.0f))
                    }
                }
            }
        }
    }
}
