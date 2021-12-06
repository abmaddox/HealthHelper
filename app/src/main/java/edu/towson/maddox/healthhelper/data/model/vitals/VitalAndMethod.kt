package edu.towson.maddox.healthhelper.data.model.vitals

import androidx.room.Embedded
import androidx.room.Relation

data class VitalAndMethod (
    @Embedded
    val vitalSign : VitalSign,
    @Relation(
        parentColumn = "vital_id",
        entityColumn = "vital_id"
    )
    val methods : List<RecordingMethod>
        )