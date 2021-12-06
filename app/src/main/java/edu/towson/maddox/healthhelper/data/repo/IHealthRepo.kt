package edu.towson.maddox.healthhelper.data.repo

import edu.towson.maddox.healthhelper.data.model.vitals.VitalSign

interface IHealthRepo {
    suspend fun getUserVitals() : List<VitalSign>
}